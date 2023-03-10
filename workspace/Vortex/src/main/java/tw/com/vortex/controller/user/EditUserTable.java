package tw.com.vortex.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tw.com.vortex.model.user.bean.UserBean;
import tw.com.vortex.model.user.service.UserServiceImpl;

@WebServlet("/EditUserTable")
public class EditUserTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		response.setStatus(200);
		UserServiceImpl service = new UserServiceImpl();
		UserBean bean = new UserBean();
		bean.setEmail(request.getParameter("email"));
		bean.setGender(request.getParameter("gender"));
		bean.setImage(request.getParameter("file_temp"));
		bean.setUsername(request.getParameter("username"));
		bean.setPassword(request.getParameter("password"));
		bean.setRegDay(Date.valueOf(request.getParameter("regDay")));
//        Enumeration<String> parameterNames = request.getParameterNames();
//        
//        while (parameterNames.hasMoreElements()) {System.out.println(parameterNames.nextElement());}
//		System.out.println("regday: " + request.getParameter("regDay"));
		List<UserBean> list = new ArrayList<>();
//		System.out.println("type: " + request.getParameter("type"));
		switch (request.getParameter("type_")) {
		case "insert":
			try {
				list.add(bean);
				service.insertUser(list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "update":
			try {
				bean.setUserId(Integer.parseInt(request.getParameter("userId")));
//				System.out.println("image:" + bean.getImage());
				list.add(bean);
				service.updateUser(list);
				bean.setImage(service.findUserById(new int[] { bean.getUserId() }).get(0).getImage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				int[] arr = { Integer.parseInt(request.getParameter("userId")) };
				list.add(bean);
				service.deleteUser(arr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//		System.out.println(gson.toJson(list));
		writer.write(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

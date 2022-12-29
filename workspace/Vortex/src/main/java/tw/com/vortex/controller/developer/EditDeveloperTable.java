package tw.com.vortex.controller.developer;

import java.io.IOException;
import java.io.PrintWriter;
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

import tw.com.vortex.model.developer.bean.DeveloperBean;
import tw.com.vortex.model.developer.service.DeveloperServiceImpl;

@WebServlet("/EditDeveloperTable")
public class EditDeveloperTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		response.setStatus(200);
		DeveloperServiceImpl service = new DeveloperServiceImpl();
		DeveloperBean bean = new DeveloperBean();
		bean.setName(request.getParameter("name"));
		bean.setUrl(request.getParameter("url"));
//        Enumeration<String> parameterNames = request.getParameterNames();
//        
//        while (parameterNames.hasMoreElements()) {System.out.println(parameterNames.nextElement());}
//		System.out.println("regday: " + request.getParameter("regDay"));
		List<DeveloperBean> list = new ArrayList<>();
//		System.out.println("type: " + request.getParameter("type"));
		switch (request.getParameter("type_")) {
		case "insert":
			try {
				list.add(bean);
				service.insertDeveloper(list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "update":
			try {
				bean.setDeveloperId(Integer.parseInt(request.getParameter("developerId")));
				list.add(bean);
				service.updateDeveloper(list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				int[] arr = { Integer.parseInt(request.getParameter("developerId")) };
				list.add(bean);
				service.deleteDeveloper(arr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}

		Gson gson = new GsonBuilder().create();
//		System.out.println(gson.toJson(list));
		writer.write(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

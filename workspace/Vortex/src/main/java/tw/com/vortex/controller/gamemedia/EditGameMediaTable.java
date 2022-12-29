package tw.com.vortex.controller.gamemedia;

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

import tw.com.vortex.model.gamemedia.bean.GameMediaBean;
import tw.com.vortex.model.gamemedia.service.GameMediaServiceImpl;

@WebServlet("/EditGameMediaTable")
public class EditGameMediaTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		response.setStatus(200);
//		Enumeration<String> parameterNames = request.getParameterNames();
//		String temp = "";
//		while (parameterNames.hasMoreElements()) 
//		{	temp = parameterNames.nextElement();
//			System.out.println(temp + ": "+ request.getParameter(temp));
//			}
		GameMediaServiceImpl service = new GameMediaServiceImpl();
		GameMediaBean bean = new GameMediaBean();
		if (request.getParameter("file_temp") != null) {
			bean.setResource(request.getParameter("file_temp"));
		}else {
			bean.setResource(request.getParameter("resource"));
		}
		bean.setResourceType(request.getParameter("resourceType"));
		bean.setGameId(Integer.parseInt(request.getParameter("gameId")));
//		System.out.println("regday: " + request.getParameter("regDay"));
		List<GameMediaBean> list = new ArrayList<>();
//		System.out.println("type: " + request.getParameter("type"));
		switch (request.getParameter("type_")) {
		case "insert":
			try {
				list.add(bean);
				service.insertGameMedia(list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "update":
			try {
				bean.setMediaId(Integer.parseInt(request.getParameter("mediaId")));
//				System.out.println("image:" + bean.getResource());
				list.add(bean);
				service.updateGameMedia(list);
				bean.setResource(service.findGameMediaById(new int[] { bean.getMediaId() }).get(0).getResource());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				int[] arr = { Integer.parseInt(request.getParameter("mediaId")) };
				list.add(bean);
				service.deleteGameMedia(arr);
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

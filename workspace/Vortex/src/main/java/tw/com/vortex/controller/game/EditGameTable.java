package tw.com.vortex.controller.game;

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

import tw.com.vortex.model.game.bean.GameBean;
import tw.com.vortex.model.game.service.GameServiceImpl;

@WebServlet("/EditGameTable")
public class EditGameTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		response.setStatus(200);
		GameServiceImpl service = new GameServiceImpl();
		GameBean bean = new GameBean();
		bean.setName(request.getParameter("name"));
		bean.setType(request.getParameter("type"));
		bean.setReleaseDate(Date.valueOf(request.getParameter("releaseDate")));
		bean.setIntro(request.getParameter("intro"));
		bean.setAdult(request.getParameter("adult"));
		bean.setDeveloperId(Integer.parseInt(request.getParameter("developerId")));
//        Enumeration<String> parameterNames = request.getParameterNames();
//        
//        while (parameterNames.hasMoreElements()) {System.out.println(parameterNames.nextElement());}
//		System.out.println("regday: " + request.getParameter("regDay"));
		List<GameBean> list = new ArrayList<>();
//		System.out.println("type: " + request.getParameter("type"));
		switch (request.getParameter("type_")) {
		case "insert":
			try {
				list.add(bean);
				service.insertGame(list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "update":
			try {
				bean.setGameId(Integer.parseInt(request.getParameter("gameId")));
				list.add(bean);
				service.updateGame(list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				int[] arr = { Integer.parseInt(request.getParameter("gameId")) };
				list.add(bean);
				service.deleteGame(arr);
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

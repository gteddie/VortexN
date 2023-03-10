package tw.com.vortex.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.vortex.util.RandomInsert;

@WebServlet("/InsertFake")
public class InsertFake extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int count = Integer.parseInt(request.getParameter("count"));
		int start = Integer.parseInt(request.getParameter("s"));
		int end = Integer.parseInt(request.getParameter("e"));
		
		RandomInsert.insertUsers(count, start, end);
		response.sendRedirect("/Vortex/view/controlpanel/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

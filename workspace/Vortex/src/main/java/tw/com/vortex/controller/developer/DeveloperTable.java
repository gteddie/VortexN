package tw.com.vortex.controller.developer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

@WebServlet("/DeveloperTable")
public class DeveloperTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("application/json");
	    response.setCharacterEncoding("utf-8");
	    PrintWriter writer = response.getWriter();
	    response.setStatus(200);
	    DeveloperServiceImpl service = new DeveloperServiceImpl();
	    List<DeveloperBean> list = null;
		try {
			list = service.findAllDeveloper();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder().create();
		writer.write(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

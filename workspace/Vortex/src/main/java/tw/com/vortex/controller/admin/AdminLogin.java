package tw.com.vortex.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.vortex.model.Admin.service.AdminServiceImpl;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pass = request.getParameter("password");		
		AdminServiceImpl service = new AdminServiceImpl();
		if (service.login(name,pass)) {
			HttpSession sess = request.getSession(true);
			sess.setAttribute("name", name);
			sess.setAttribute("pass", pass);
			response.sendRedirect("/Vortex/view/controlpanel/index.jsp");
		} else {
			response.sendRedirect("/Vortex/view/login.html");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}

package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmpBean;
import dao.SQLEmpDao;
import service.EmpServiceImpl;
import util.ConnectionFactory;

@WebServlet("/DeleteControl")
public class DeleteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int[] empnos = Arrays.stream(request.getParameterValues("empnoDel[]")).mapToInt(Integer::parseInt).toArray();
		EmpServiceImpl service = new EmpServiceImpl();
		try {
			List<EmpBean> empList = service.deleteEmp(empnos);
			request.setAttribute("opType", "刪除");
			request.setAttribute("employees", empList);
			request.getRequestDispatcher("/view/Result.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("opType", "刪除");
			request.setAttribute("errM",  e.getMessage());
			request.getRequestDispatcher("/view/fail.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

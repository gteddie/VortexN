package control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmpBean;
import service.EmpService;
import service.EmpServiceImpl;

@WebServlet("/GetUpdateData")
public class GetUpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetUpdateData() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int[] empnos = Arrays.stream(request.getParameterValues("empnoUp[]")).mapToInt(Integer::parseInt).toArray();
		EmpServiceImpl service = new EmpServiceImpl();
		try {
			List<EmpBean> empList = service.findEmpByNo(empnos);
			request.setAttribute("employees", empList);
			request.getRequestDispatcher("/view/updateInterface.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("opType", "取得更新資料");
			request.setAttribute("errM",  e.getMessage());
			request.getRequestDispatcher("/view/fail.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

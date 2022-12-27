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

@WebServlet("/InsertControl")
public class InsertControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int[] empnos = Arrays.stream(request.getParameterValues("empno[]")).mapToInt(Integer::parseInt).toArray();
		int[] salarys = Arrays.stream(request.getParameterValues("salary[]")).mapToInt(Integer::parseInt).toArray();
		int[] deptnos = Arrays.stream(request.getParameterValues("deptno[]")).mapToInt(Integer::parseInt).toArray();
		String[] enames = request.getParameterValues("ename[]");
		String[] titles = request.getParameterValues("title[]");
		Object[] hiredates =  Arrays.stream(request.getParameterValues("hiredate[]")).map(Date::valueOf).toArray();
		List<EmpBean> empList = new ArrayList<>();
		for (int i = 0; i < empnos.length; i++) {
			EmpBean bean = new EmpBean();	
			bean.setEmpno(empnos[i]);
			bean.setEname(enames[i]);
			bean.setHiredate((Date)hiredates[i]);
			bean.setSalary(salarys[i]);
			bean.setDeptno(deptnos[i]);
			bean.setTitle(titles[i]);
			empList.add(bean);			
		}
		EmpServiceImpl service = new EmpServiceImpl();
		try {
			service.insertEmp(empList);
			request.setAttribute("opType", "新增");
			request.setAttribute("employees", empList);
			request.getRequestDispatcher("/view/Result.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("opType", "新增");
			request.setAttribute("errM",  e.getMessage());
			request.getRequestDispatcher("/view/fail.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

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

@WebServlet("/UpdateControl")
public class UpdateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int[] empnos = Arrays.stream(request.getParameterValues("empnoUpd[]")).mapToInt(Integer::parseInt).toArray();
		int[] salarys = Arrays.stream(request.getParameterValues("salaryUpd[]")).mapToInt(Integer::parseInt).toArray();
		int[] deptnos = Arrays.stream(request.getParameterValues("deptnoUpd[]")).mapToInt(Integer::parseInt).toArray();
		String[] enames = request.getParameterValues("enameUpd[]");
		String[] titles = request.getParameterValues("titleUpd[]");
		Object[] hiredates =  Arrays.stream(request.getParameterValues("hiredateUpd[]")).map(Date::valueOf).toArray();
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
			service.updateEmp(empList);
			request.setAttribute("opType", "修改");
			request.setAttribute("employees", empList);
			request.getRequestDispatcher("/view/Result.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("opType", "修改");
			request.setAttribute("errM",  e.getMessage());
			request.getRequestDispatcher("/view/fail.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

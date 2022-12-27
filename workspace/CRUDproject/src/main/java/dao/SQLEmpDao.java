package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EmpBean;

public class SQLEmpDao implements EmpDao {
	private Connection conn;

	public SQLEmpDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertEmp(List<EmpBean> empList) throws SQLException {
		String sql = "INSERT INTO [servdb].[dbo].[employee] VALUES(?,?,?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (EmpBean bean : empList) {
				stmt.setInt(1, bean.getEmpno());
				stmt.setString(2, bean.getEname());
				stmt.setDate(3, bean.getHiredate());
				stmt.setInt(4, bean.getSalary());
				stmt.setInt(5, bean.getDeptno());
				stmt.setString(6, bean.getTitle());
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public void deleteEmpByNo(int[] empnos) throws SQLException {
		String sql = "DELETE FROM [servdb].[dbo].[employee] WHERE empno = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (int empno : empnos) {
				stmt.setInt(1, empno);
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public void updateEmp(List<EmpBean> empList) throws SQLException {
		String sql = "UPDATE [servdb].[dbo].[employee] "
				+ "SET ename = ?, "
				+ "hiredate = ?, "
				+ "salary = ?, "
				+ "deptno = ?, "
				+ "title = ? "
				+ " WHERE empno = ?; ";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (EmpBean bean : empList) {
				stmt.setInt(6, bean.getEmpno());
				stmt.setString(1, bean.getEname());
				stmt.setDate(2, bean.getHiredate());
				stmt.setInt(3, bean.getSalary());
				stmt.setInt(4, bean.getDeptno());
				stmt.setString(5, bean.getTitle());
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public List<EmpBean> findEmpByNo(int[] empnos) throws SQLException {
		int counts = empnos.length;
		List<EmpBean> empList = new ArrayList<>();
		String sql = "SELECT * FROM [servdb].[dbo].[employee] WHERE empno IN (";
		for (int i = 0; i < counts - 1; i++)
			sql += "?,";		
		sql += "?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (int i = 1; i <= counts; i++) {
				stmt.setInt(i, empnos[i-1]);
			}
			ResultSet rs = stmt.executeQuery();
			EmpBean emp = null;
			while(rs.next()) {
				emp = new EmpBean();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setTitle(rs.getString("title"));
				empList.add(emp);
			}
		};
		return empList;
	}

	@Override
	public List<EmpBean> findAllEmp() throws SQLException {
		String sql = "SELECT * FROM [servdb].[dbo].[employee]";
		List<EmpBean> empList = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			EmpBean emp = null;
			while(rs.next()) {
				emp = new EmpBean();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setTitle(rs.getString("title"));
				empList.add(emp);
			}
		};
		return empList;
		
	}

}

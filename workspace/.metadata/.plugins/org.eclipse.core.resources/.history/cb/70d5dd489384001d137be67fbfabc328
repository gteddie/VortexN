package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import bean.EmpBean;
import dao.SQLEmpDao;
import util.ConnectionFactory;

public class EmpServiceImpl implements EmpService {

	@Override
	public List<EmpBean> insertEmp(List<EmpBean> empList) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();) {
			SQLEmpDao dao = new SQLEmpDao(conn);
			dao.insertEmp(empList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<EmpBean> deleteEmp(int[] empnos) throws SQLException {
		List<EmpBean> empList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			SQLEmpDao dao = new SQLEmpDao(conn);
			empList = dao.findEmpByNo(empnos);
			dao.deleteEmpByNo(empnos);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return empList;
	}
	

	@Override
	public List<EmpBean> updateEmp(List<EmpBean> empList) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();) {
			SQLEmpDao dao = new SQLEmpDao(conn);
			dao.updateEmp(empList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<EmpBean> findEmpByNo(int[] empnos) throws SQLException {
		List<EmpBean> empList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			SQLEmpDao dao = new SQLEmpDao(conn);
			empList = dao.findEmpByNo(empnos);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<EmpBean> findAllEmp() throws SQLException {
		List<EmpBean> empList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			SQLEmpDao dao = new SQLEmpDao(conn);
			empList = dao.findAllEmp();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return empList;
	}

}

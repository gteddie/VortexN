package tw.com.vortex.model.developer.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import tw.com.vortex.model.developer.bean.DeveloperBean;
import tw.com.vortex.model.developer.dao.DeveloperDaoImpl;
import tw.com.vortex.util.ConnectionFactory;

public class DeveloperServiceImpl implements DeveloperService {

	@Override
	public List<DeveloperBean> insertDeveloper(List<DeveloperBean> developerList) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();) {
			DeveloperDaoImpl dao = new DeveloperDaoImpl(conn);
			dao.insertDeveloper(developerList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return developerList;
	}

	@Override
	public List<DeveloperBean> deleteDeveloper(int[] developerIds) throws SQLException {
		List<DeveloperBean> developerList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			DeveloperDaoImpl dao = new DeveloperDaoImpl(conn);
			developerList = dao.findDeveloperById(developerIds);
			dao.deleteDeveloperById(developerIds);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return developerList;
	}
	

	@Override
	public List<DeveloperBean> updateDeveloper(List<DeveloperBean> developerList) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();) {
			DeveloperDaoImpl dao = new DeveloperDaoImpl(conn);
			dao.updateDeveloper(developerList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return developerList;
	}

	@Override
	public List<DeveloperBean> findDeveloperById(int[] developerIds) throws SQLException {
		List<DeveloperBean> developerList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			DeveloperDaoImpl dao = new DeveloperDaoImpl(conn);
			developerList = dao.findDeveloperById(developerIds);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return developerList;
	}

	@Override
	public List<DeveloperBean> findAllDeveloper() throws SQLException {
		List<DeveloperBean> developerList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			DeveloperDaoImpl dao = new DeveloperDaoImpl(conn);
			developerList = dao.findAllDeveloper();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return developerList;
	}

}

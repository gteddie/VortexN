package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import bean.UserBean;
import dao.UserDaoImpl;
import util.ConnectionFactory;

public class UserServiceImpl implements UserService {

	@Override
	public List<UserBean> insertUser(List<UserBean> userList) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();) {
			UserDaoImpl dao = new UserDaoImpl(conn);
			dao.insertUser(userList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<UserBean> deleteUser(int[] userids) throws SQLException {
		List<UserBean> userList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			UserDaoImpl dao = new UserDaoImpl(conn);
			userList = dao.findUserById(userids);
			dao.deleteUserById(userids);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return userList;
	}
	

	@Override
	public List<UserBean> updateUser(List<UserBean> userList) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();) {
			UserDaoImpl dao = new UserDaoImpl(conn);
			dao.updateUser(userList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<UserBean> findUserById(int[] userids) throws SQLException {
		List<UserBean> userList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			UserDaoImpl dao = new UserDaoImpl(conn);
			userList = dao.findUserById(userids);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<UserBean> findAllUser() throws SQLException {
		List<UserBean> userList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			UserDaoImpl dao = new UserDaoImpl(conn);
			userList = dao.findAllUser();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
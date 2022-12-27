package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import dao.AdminDaoImpl;
import util.ConnectionFactory;

public class AdminServiceImpl implements AdminService {

	@Override
	public boolean login(String name, String pass) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			AdminDaoImpl dao = new AdminDaoImpl(conn);
			return dao.findAdmin(name, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		}
	}

}

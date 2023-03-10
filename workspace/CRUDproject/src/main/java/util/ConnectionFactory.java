package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {

	public static Connection getConnection() throws NamingException, SQLException {

		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/MSSQL");
		Connection conn = ds.getConnection();
		return conn;
	}

}

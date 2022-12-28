package tw.com.vortex.model.Admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
	private Connection conn;

	public AdminDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean findAdmin(String name, String pass) throws SQLException {
		String sql = "SELECT * FROM [Vortex].[dbo].[Admin] WHERE name =? AND password =?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,name);
		stmt.setString(2,pass);
		ResultSet rs = stmt.executeQuery();
		return rs.next();
	}

}

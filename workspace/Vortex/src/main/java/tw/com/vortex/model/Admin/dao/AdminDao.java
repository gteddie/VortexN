package tw.com.vortex.model.Admin.dao;

import java.sql.SQLException;

public interface AdminDao {
	boolean findAdmin(String name, String pass) throws SQLException;
}

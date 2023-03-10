package tw.com.vortex.model.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.vortex.model.user.bean.UserBean;

public class UserDaoImpl implements UserDao {
	private Connection conn;

	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertUser(List<UserBean> userList) throws SQLException {
		String sql = "INSERT INTO [Vortex].[dbo].[User]([username],[password],[email],[image],[registration_date],[gender]) VALUES(?,?,?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (UserBean bean : userList) {
				stmt.setString(1, bean.getUsername());
				stmt.setString(2, bean.getPassword());
				stmt.setString(3, bean.getEmail());
				stmt.setString(4, bean.getImage());
				stmt.setDate(5, bean.getRegDay());
				stmt.setString(6, bean.getGender());
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public void deleteUserById(int[] userIds) throws SQLException {
		String sql = "DELETE FROM [Vortex].[dbo].[User] WHERE user_id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (int userId : userIds) {
				stmt.setInt(1, userId);
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public void updateUser(List<UserBean> userList) throws SQLException {
		String sql = "UPDATE [Vortex].[dbo].[User] " + "SET username = ?, " + "password = ?, " + "email = ?, "
				+ "image = ?, " + "registration_date = ?, " + "gender = ? " + " WHERE user_id = ?; ";
		String sqlNoImg = "UPDATE [Vortex].[dbo].[User] " + "SET username = ?, " + "password = ?, " + "email = ?, "
				+ "registration_date = ?, " + "gender = ? " + " WHERE user_id = ?; ";

		try (PreparedStatement stmt = conn.prepareStatement(sql);PreparedStatement stmt2 = conn.prepareStatement(sqlNoImg);) {
			for (UserBean bean : userList) {
				if(bean.getImage() == null) {
					stmt2.setString(1, bean.getUsername());
					stmt2.setString(2, bean.getPassword());
					stmt2.setString(3, bean.getEmail());
					stmt2.setDate(4, bean.getRegDay());
					stmt2.setString(5, bean.getGender());
					stmt2.setInt(6, bean.getUserId());
					stmt2.addBatch();
				}else {
//					System.out.println("image: " + bean.getImage());
					stmt.setString(1, bean.getUsername());
					stmt.setString(2, bean.getPassword());
					stmt.setString(3, bean.getEmail());
					stmt.setString(4, bean.getImage());
					stmt.setDate(5, bean.getRegDay());
					stmt.setString(6, bean.getGender());
					stmt.setInt(7, bean.getUserId());
					stmt.addBatch();					
				}
			}
			stmt.executeBatch();
			stmt2.executeBatch();
		}
	}

	@Override
	public List<UserBean> findUserById(int[] userIds) throws SQLException {
		int counts = userIds.length;
		List<UserBean> userList = new ArrayList<>();
		String sql = "SELECT * FROM [Vortex].[dbo].[User] WHERE user_id IN (";
		for (int i = 0; i < counts - 1; i++)
			sql += "?,";
		sql += "?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (int i = 1; i <= counts; i++) {
				stmt.setInt(i, userIds[i - 1]);
			}
			ResultSet rs = stmt.executeQuery();
			UserBean user = null;
			while (rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setImage(rs.getString("image"));
				user.setRegDay(rs.getDate("registration_date"));
				user.setGender(rs.getString("gender"));
				userList.add(user);
			}
		}
		;
		return userList;
	}

	@Override
	public List<UserBean> findAllUser() throws SQLException {
		String sql = "SELECT * FROM [Vortex].[dbo].[User]";
		List<UserBean> userList = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			UserBean user = null;
			while (rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setImage(rs.getString("image"));
				user.setRegDay(rs.getDate("registration_date"));
				user.setGender(rs.getString("gender"));
				userList.add(user);
			}
		}
		;
		return userList;

	}

}

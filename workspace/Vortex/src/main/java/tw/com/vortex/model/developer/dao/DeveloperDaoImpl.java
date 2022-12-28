package tw.com.vortex.model.developer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.vortex.model.developer.bean.DeveloperBean;

public class DeveloperDaoImpl implements DeveloperDao {
	private Connection conn;

	public DeveloperDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertDeveloper(List<DeveloperBean> developerList) throws SQLException {
		String sql = "INSERT INTO [Vortex].[dbo].[GameDeveloper]([name],[url]) VALUES(?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (DeveloperBean bean : developerList) {
				stmt.setString(1, bean.getName());
				stmt.setString(2, bean.getUrl());

				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public void deleteDeveloperById(int[] developerIds) throws SQLException {
		String sql = "DELETE FROM [Vortex].[dbo].[GameDeveloper] WHERE developer_id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (int developerId : developerIds) {
				stmt.setInt(1, developerId);
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public void updateDeveloper(List<DeveloperBean> developerList) throws SQLException {
		String sql = "UPDATE [Vortex].[dbo].[GameDeveloper] " + "SET name = ?, " + "url = ?, " + " WHERE developer_id = ?; ";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (DeveloperBean bean : developerList) {
					stmt.setString(1, bean.getName());
					stmt.setString(2, bean.getUrl());
					stmt.setInt(3, bean.getDeveloperId());
					stmt.addBatch();					
				
			}
			stmt.executeBatch();

		}
	}

	@Override
	public List<DeveloperBean> findDeveloperById(int[] developerIds) throws SQLException {
		int counts = developerIds.length;
		List<DeveloperBean> developerList = new ArrayList<>();
		String sql = "SELECT * FROM [Vortex].[dbo].[GameDeveloper] WHERE developer_id IN (";
		for (int i = 0; i < counts - 1; i++)
			sql += "?,";
		sql += "?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (int i = 1; i <= counts; i++) {
				stmt.setInt(i, developerIds[i - 1]);
			}
			ResultSet rs = stmt.executeQuery();
			DeveloperBean developer = null;
			while (rs.next()) {
				developer = new DeveloperBean();
				developer.setDeveloperId(rs.getInt("developer_id"));
				developer.setName(rs.getString("name"));
				developer.setUrl(rs.getString("url"));
				developerList.add(developer);
			}
		}
		;
		return developerList;
	}

	@Override
	public List<DeveloperBean> findAllDeveloper() throws SQLException {
		String sql = "SELECT * FROM [Vortex].[dbo].[GameDeveloper]";
		List<DeveloperBean> developerList = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			DeveloperBean developer = null;
			while (rs.next()) {
				developer = new DeveloperBean();
				developer.setDeveloperId(rs.getInt("developer_id"));
				developer.setName(rs.getString("name"));
				developer.setUrl(rs.getString("url"));
				developerList.add(developer);
			}
		}
		;
		return developerList;

	}

}

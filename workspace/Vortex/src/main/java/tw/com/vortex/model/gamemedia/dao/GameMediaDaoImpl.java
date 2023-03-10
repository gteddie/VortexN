package tw.com.vortex.model.gamemedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.vortex.model.gamemedia.bean.GameMediaBean;

public class GameMediaDaoImpl implements GameMediaDao {
	private Connection conn;

	public GameMediaDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertGameMedia(List<GameMediaBean> gameMediaList) throws SQLException {
		String sql = "INSERT INTO [Vortex].[dbo].[GameMedia]([resource],[resource_type],[game_id]) VALUES(?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (GameMediaBean bean : gameMediaList) {
				stmt.setString(1, bean.getResource());
				stmt.setString(2, bean.getResourceType());
				stmt.setInt(3, bean.getGameId());
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public void deleteGameMediaById(int[] gameMediaIds) throws SQLException {
		String sql = "DELETE FROM [Vortex].[dbo].[GameMedia] WHERE media_id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (int gameMediaId : gameMediaIds) {
				stmt.setInt(1, gameMediaId);
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public void updateGameMedia(List<GameMediaBean> gameMediaList) throws SQLException {
		String sql = "UPDATE [Vortex].[dbo].[GameMedia] " 
					 + "SET resource = ?, " + "resource_type = ?, " 
		   			 + "game_id = ? "+" WHERE media_id = ?; ";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (GameMediaBean bean : gameMediaList) {
//					System.out.println("image: " + bean.getImage());
				stmt.setString(1, bean.getResource());
				stmt.setString(2, bean.getResourceType());
				stmt.setInt(3, bean.getGameId());
				stmt.setInt(4, bean.getMediaId());
				stmt.addBatch();
			}
			stmt.executeBatch();

		}
	}

	@Override
	public List<GameMediaBean> findGameMediaById(int[] gameMediaIds) throws SQLException {
		int counts = gameMediaIds.length;
		List<GameMediaBean> gameMediaList = new ArrayList<>();
		String sql = "SELECT * FROM [Vortex].[dbo].[GameMedia] WHERE media_id IN (";
		for (int i = 0; i < counts - 1; i++)
			sql += "?,";
		sql += "?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (int i = 1; i <= counts; i++) {
				stmt.setInt(i, gameMediaIds[i - 1]);
			}
			ResultSet rs = stmt.executeQuery();
			GameMediaBean gameMedia = null;
			while (rs.next()) {
				gameMedia = new GameMediaBean();
				gameMedia.setMediaId(rs.getInt("media_id"));
				gameMedia.setResource(rs.getString("resource"));
				gameMedia.setResourceType(rs.getString("resource_type"));
				gameMedia.setGameId(rs.getInt("game_id"));
				gameMediaList.add(gameMedia);
			}
		}
		;
		return gameMediaList;
	}

	@Override
	public List<GameMediaBean> findAllGameMedia() throws SQLException {
		String sql = "SELECT * FROM [Vortex].[dbo].[GameMedia]";
		List<GameMediaBean> gameMediaList = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			GameMediaBean gameMedia = null;
			while (rs.next()) {
				gameMedia = new GameMediaBean();
				gameMedia.setMediaId(rs.getInt("media_id"));
				gameMedia.setResource(rs.getString("resource"));
				gameMedia.setResourceType(rs.getString("resource_type"));
				gameMedia.setGameId(rs.getInt("game_id"));
				gameMediaList.add(gameMedia);
			}
		}
		;
		return gameMediaList;

	}

}

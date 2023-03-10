package tw.com.vortex.model.game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.vortex.model.game.bean.GameBean;

public class GameDaoImpl implements GameDao {
	private Connection conn;

	public GameDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertGame(List<GameBean> gameList) throws SQLException {
		String sql = "INSERT INTO [Vortex].[dbo].[Game]([name],[type],[release_date],[intro],[adult],[developer_id]) VALUES(?,?,?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (GameBean bean : gameList) {
				stmt.setString(1, bean.getName());
				stmt.setString(2, bean.getType());
				stmt.setDate(3, bean.getReleaseDate());
				stmt.setString(4, bean.getIntro());
				stmt.setString(5, bean.getAdult());
				stmt.setInt(6, bean.getDeveloperId());
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public void deleteGameById(int[] gameIds) throws SQLException {
		String sql = "DELETE FROM [Vortex].[dbo].[Game] WHERE game_id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (int gameId : gameIds) {
				stmt.setInt(1, gameId);
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
	}

	@Override
	public void updateGame(List<GameBean> gameList) throws SQLException {
		String sql = "UPDATE [Vortex].[dbo].[Game] " + "SET name = ?, " + "type = ?, " + "release_date = ?, "
				+ "intro = ?, " + "adult = ?, " + "developer_id = ? " + " WHERE game_id = ?; ";

		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (GameBean bean : gameList) {

					stmt.setString(1, bean.getName());
					stmt.setString(2, bean.getType());
					stmt.setDate(3, bean.getReleaseDate());
					stmt.setString(4, bean.getIntro());
					stmt.setString(5, bean.getAdult());
					stmt.setInt(6, bean.getDeveloperId());
					stmt.setInt(7, bean.getGameId());
					stmt.addBatch();					
				
			}
			stmt.executeBatch();

		}
	}

	@Override
	public List<GameBean> findGameById(int[] gameIds) throws SQLException {
		int counts = gameIds.length;
		List<GameBean> gameList = new ArrayList<>();
		String sql = "SELECT * FROM [Vortex].[dbo].[Game] WHERE game_id IN (";
		for (int i = 0; i < counts - 1; i++)
			sql += "?,";
		sql += "?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			for (int i = 1; i <= counts; i++) {
				stmt.setInt(i, gameIds[i - 1]);
			}
			ResultSet rs = stmt.executeQuery();
			GameBean game = null;
			while (rs.next()) {
				game = new GameBean();
				game.setGameId(rs.getInt("game_id"));
				game.setName(rs.getString("name"));
				game.setType(rs.getString("type"));
				game.setReleaseDate(rs.getDate("release_date"));
				game.setIntro(rs.getString("intro"));
				game.setAdult(rs.getString("adult"));
				game.setDeveloperId(rs.getInt("developer_id"));
				gameList.add(game);
			}
		}
		;
		return gameList;
	}

	@Override
	public List<GameBean> findAllGame() throws SQLException {
		String sql = "SELECT * FROM [Vortex].[dbo].[Game]";
		List<GameBean> gameList = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			GameBean game = null;
			while (rs.next()) {
				game = new GameBean();
				game.setGameId(rs.getInt("game_id"));
				game.setName(rs.getString("name"));
				game.setType(rs.getString("type"));
				game.setReleaseDate(rs.getDate("release_date"));
				game.setIntro(rs.getString("intro"));
				game.setAdult(rs.getString("adult"));
				game.setDeveloperId(rs.getInt("developer_id"));
				gameList.add(game);
			}
		}
		;
		return gameList;

	}

}

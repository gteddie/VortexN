package tw.com.vortex.model.game.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import tw.com.vortex.model.game.bean.GameBean;
import tw.com.vortex.model.game.dao.GameDaoImpl;
import tw.com.vortex.util.ConnectionFactory;

public class GameServiceImpl implements GameService {

	@Override
	public List<GameBean> insertGame(List<GameBean> gameList) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();) {
			GameDaoImpl dao = new GameDaoImpl(conn);
			dao.insertGame(gameList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return gameList;
	}

	@Override
	public List<GameBean> deleteGame(int[] gameIds) throws SQLException {
		List<GameBean> gameList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			GameDaoImpl dao = new GameDaoImpl(conn);
			gameList = dao.findGameById(gameIds);
			dao.deleteGameById(gameIds);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return gameList;
	}
	

	@Override
	public List<GameBean> updateGame(List<GameBean> gameList) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();) {
			GameDaoImpl dao = new GameDaoImpl(conn);
			dao.updateGame(gameList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return gameList;
	}

	@Override
	public List<GameBean> findGameById(int[] gameIds) throws SQLException {
		List<GameBean> gameList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			GameDaoImpl dao = new GameDaoImpl(conn);
			gameList = dao.findGameById(gameIds);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return gameList;
	}

	@Override
	public List<GameBean> findAllGame() throws SQLException {
		List<GameBean> gameList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			GameDaoImpl dao = new GameDaoImpl(conn);
			gameList = dao.findAllGame();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return gameList;
	}

}

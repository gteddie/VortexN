package tw.com.vortex.model.gamemedia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import tw.com.vortex.model.gamemedia.bean.GameMediaBean;
import tw.com.vortex.model.gamemedia.dao.GameMediaDaoImpl;
import tw.com.vortex.util.ConnectionFactory;

public class GameMediaServiceImpl implements GameMediaService {

	@Override
	public List<GameMediaBean> insertGameMedia(List<GameMediaBean> gameMediaList) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();) {
			GameMediaDaoImpl dao = new GameMediaDaoImpl(conn);
			dao.insertGameMedia(gameMediaList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return gameMediaList;
	}

	@Override
	public List<GameMediaBean> deleteGameMedia(int[] gameMediaIds) throws SQLException {
		List<GameMediaBean> gameMediaList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			GameMediaDaoImpl dao = new GameMediaDaoImpl(conn);
			gameMediaList = dao.findGameMediaById(gameMediaIds);
			dao.deleteGameMediaById(gameMediaIds);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return gameMediaList;
	}
	

	@Override
	public List<GameMediaBean> updateGameMedia(List<GameMediaBean> gameMediaList) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();) {
			GameMediaDaoImpl dao = new GameMediaDaoImpl(conn);
			dao.updateGameMedia(gameMediaList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return gameMediaList;
	}

	@Override
	public List<GameMediaBean> findGameMediaById(int[] gameMediaIds) throws SQLException {
		List<GameMediaBean> gameMediaList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			GameMediaDaoImpl dao = new GameMediaDaoImpl(conn);
			gameMediaList = dao.findGameMediaById(gameMediaIds);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return gameMediaList;
	}

	@Override
	public List<GameMediaBean> findAllGameMedia() throws SQLException {
		List<GameMediaBean> gameMediaList = null;
		try (Connection conn = ConnectionFactory.getConnection();) {
			GameMediaDaoImpl dao = new GameMediaDaoImpl(conn);
			gameMediaList = dao.findAllGameMedia();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return gameMediaList;
	}

}

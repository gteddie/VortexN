package tw.com.vortex.model.game.dao;

import java.sql.SQLException;
import java.util.List;

import tw.com.vortex.model.game.bean.GameBean;

public interface GameDao {
	void insertGame(List<GameBean> gameList) throws SQLException;

	void deleteGameById(int[] gameIds) throws SQLException;

	void updateGame(List<GameBean> gameList) throws SQLException;

	List<GameBean> findGameById(int[] gameIds) throws SQLException;

	List<GameBean> findAllGame() throws SQLException;
}

package tw.com.vortex.model.game.service;

import java.sql.SQLException;
import java.util.List;

import tw.com.vortex.model.game.bean.GameBean;

public interface GameService {
	List<GameBean> insertGame(List<GameBean> gameList) throws SQLException;
	List<GameBean> deleteGame(int[] gameIds) throws SQLException;
	List<GameBean> updateGame(List<GameBean> gameList) throws SQLException;
	List<GameBean> findGameById(int[] gameIds) throws SQLException;
	List<GameBean> findAllGame() throws SQLException;
}

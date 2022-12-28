package tw.com.vortex.model.gamemedia.dao;

import java.sql.SQLException;
import java.util.List;

import tw.com.vortex.model.gamemedia.bean.GameMediaBean;

public interface GameMediaDao {
	void insertGameMedia(List<GameMediaBean> gameMediaList) throws SQLException;

	void deleteGameMediaById(int[] gameMediaIds) throws SQLException;

	void updateGameMedia(List<GameMediaBean> gameMediaList) throws SQLException;

	List<GameMediaBean> findGameMediaById(int[] gameMediaIds) throws SQLException;

	List<GameMediaBean> findAllGameMedia() throws SQLException;
}

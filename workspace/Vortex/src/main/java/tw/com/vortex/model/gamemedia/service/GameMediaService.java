package tw.com.vortex.model.gamemedia.service;

import java.sql.SQLException;
import java.util.List;

import tw.com.vortex.model.gamemedia.bean.GameMediaBean;

public interface GameMediaService {
	List<GameMediaBean> insertGameMedia(List<GameMediaBean> gameMediaList) throws SQLException;

	List<GameMediaBean> deleteGameMedia(int[] gameMediaIds) throws SQLException;

	List<GameMediaBean> updateGameMedia(List<GameMediaBean> gameMediaList) throws SQLException;

	List<GameMediaBean> findGameMediaById(int[] gameMediaIds) throws SQLException;

	List<GameMediaBean> findAllGameMedia() throws SQLException;
}

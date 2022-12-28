package tw.com.vortex.model.developer.dao;

import java.sql.SQLException;
import java.util.List;

import tw.com.vortex.model.developer.bean.DeveloperBean;

public interface DeveloperDao {
	void insertDeveloper(List<DeveloperBean> developerList) throws SQLException;

	void deleteDeveloperById(int[] developerIds) throws SQLException;

	void updateDeveloper(List<DeveloperBean> developerList) throws SQLException;

	List<DeveloperBean> findDeveloperById(int[] developerIds) throws SQLException;

	List<DeveloperBean> findAllDeveloper() throws SQLException;
}

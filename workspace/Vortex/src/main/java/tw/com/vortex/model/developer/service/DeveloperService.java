package tw.com.vortex.model.developer.service;

import java.sql.SQLException;
import java.util.List;

import tw.com.vortex.model.developer.bean.DeveloperBean;

public interface DeveloperService {
	List<DeveloperBean> insertDeveloper(List<DeveloperBean> developerList) throws SQLException;

	List<DeveloperBean> deleteDeveloper(int[] developerIds) throws SQLException;

	List<DeveloperBean> updateDeveloper(List<DeveloperBean> developerList) throws SQLException;

	List<DeveloperBean> findDeveloperById(int[] developerIds) throws SQLException;

	List<DeveloperBean> findAllDeveloper() throws SQLException;
}

package dao;

import java.sql.SQLException;
import java.util.List;

import bean.UserBean;

public interface UserDao {
	void insertUser(List<UserBean> userList) throws SQLException;

	void deleteUserById(int[] userIds) throws SQLException;

	void updateUser(List<UserBean> userList) throws SQLException;

	List<UserBean> findUserById(int[] userIds) throws SQLException;

	List<UserBean> findAllUser() throws SQLException;
}

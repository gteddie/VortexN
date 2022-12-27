package service;

import java.sql.SQLException;
import java.util.List;

import bean.UserBean;

public interface UserService {
	List<UserBean> insertUser(List<UserBean> userList) throws SQLException;
	List<UserBean> deleteUser(int[] userIds) throws SQLException;
	List<UserBean> updateUser(List<UserBean> userList) throws SQLException;
	List<UserBean> findUserById(int[] userIds) throws SQLException;
	List<UserBean> findAllUser() throws SQLException;
}
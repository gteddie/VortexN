package dao;

import java.sql.SQLException;
import java.util.List;

import bean.EmpBean;

public interface EmpDao {
	void insertEmp(List<EmpBean> empList) throws SQLException;

	void deleteEmpByNo(int[] empnos) throws SQLException;

	void updateEmp(List<EmpBean> empList) throws SQLException;

	List<EmpBean> findEmpByNo(int[] empnos) throws SQLException;

	List<EmpBean> findAllEmp() throws SQLException;
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "java.util.*,bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改資料</title>
</head>
<body style="background-color:#fdf5e6">
	<div align = "center">
		<form action="./UpdateControl">
			<h2>請修改以下資料</h2>
			<table border = "1">
				<tr style="background-color:#a8fefa">
					<th>員工編號</th>
					<th>姓名</th>
					<th>到職日</th>
					<th>薪水</th>
					<th>部門編號</th>
					<th>職稱</th>
				</tr>
				<%
				List<UserBean> emps = (ArrayList<UserBean>) request.getAttribute("employees");
						   	for(UserBean emp : emps) {
				%>
				   	<tr><td><input value="<%= emp.getEmpno() %>" name="empnoUpd[]" readonly>
				   	<td><input value="<%= emp.getEname() %>" name="enameUpd[]">
					<td><input value="<%= emp.getHiredate() %>" name="hiredateUpd[]">
					<td><input value="<%= emp.getSalary() %>" name="salaryUpd[]">
					<td><input value="<%= emp.getDeptno() %>" name="deptnoUpd[]">
					<td><input value="<%= emp.getTitle() %>" name="titleUpd[]">
				<%}%>
			</table>		
			<button>送出</button>
		</form>
		<h3>請修改以上<%= emps.size() %>筆員工資料</h3>
		<button onclick="location.href = './view/controlPanel.html';">返回首頁</button>	
	</div>
</body>
</html>
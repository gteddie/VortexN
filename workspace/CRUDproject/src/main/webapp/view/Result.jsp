<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "java.util.*,bean.UserBean"%>
<%
String type = (String)request.getAttribute("opType");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=type%>結果</title>
</head>
<body style="background-color:#fdf5e6">
	<div align = "center">
		<h2>以下資料被<%=type%></h2>
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
			   	<tr><td><%= emp.getEmpno() %>	
			   	<td><%= emp.getEname() %>
				<td><%= emp.getHiredate() %>
				<td><%= emp.getSalary() %>
				<td><%= emp.getDeptno() %>
				<td><%= emp.getTitle() %>
			<%}%>
		</table>
		<h3>總共<%=type %><%= emps.size() %>筆員工資料</h3>
		<button onclick="location.href = './view/controlPanel.html';">返回首頁</button>	
	</div>
</body>
</html>
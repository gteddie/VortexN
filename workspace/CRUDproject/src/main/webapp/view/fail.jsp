<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "java.util.*,bean.UserBean"%>
<% String type = (String)request.getAttribute("opType"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=type %>結果</title>
</head>
<body style="background-color:#fdf5e6">
	<div align = "center">
		<h2><%=type %>結果</h2>
		<h3 style="color:red"><%=type %>發生錯誤</h3>
		<h3>原因:<%=(String)request.getAttribute("errM") %></h3>
		<button onclick="location.href = './view/controlPanel.html';">返回首頁</button>	
	</div>
</body>
</html>
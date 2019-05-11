<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.domain.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="../management/css/student.css">
	   <style>
    </style>
</head>

<body>
    <!-- 状态栏 -->
	<div id="state">
		<div id="left_nav">
			<span>欢迎您！</span>
			<span>${Sname }</span>
			<span><a href="${pageContext.request.contextPath}/login.jsp" target="_top">退出</a></span>
		</div>
	</div>
	
		<!-- 底部 -->
	<div id="footer"></div>

		
</body>
</html>
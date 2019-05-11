<%@ page language="java" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="../management/css/student.css">
    <style>
    </style>
  </head>
  
<frameset rows="70,*,80" frameborder=0 border="0" framespacing="0">
  <frame src="${pageContext.request.contextPath}/header.jsp" name="topFrame" scrolling="NO" noresize>
  <frameset cols="159,*" frameborder="0" border="0" framespacing="0">
  
		<frame src="${pageContext.request.contextPath}/manage_left.jsp" name="leftFrame" noresize scrolling="NO">
		<frame src="${pageContext.request.contextPath}/shutter.html" name="mainFrame" scrolling="YES">
  </frameset>
  <frame src="${pageContext.request.contextPath}/footer.jsp" name="bottomFrame" scrolling="NO"  noresize>
</frameset>

<script src="../management/js/student.js"></script>
</html>

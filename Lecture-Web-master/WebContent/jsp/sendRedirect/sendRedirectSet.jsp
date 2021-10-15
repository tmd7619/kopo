<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과화면</h2> 
	<c:if test="${param.id eq 'admin' }">
		<%
			response.sendRedirect("admin.jsp"); // url이 admin.jsp로 변경됨
		%>
	</c:if>
	<c:if test="${param.id ne 'admin' }">
		<%
			response.sendRedirect("user.jsp?id= " + request.getParameter("id"));			
		%>
	</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* 	session.removeAttribute("id"); // 삭제방법 1
	session.removeAttribute("password"); */
	
	session.invalidate(); // 삭제방법 2

 %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 삭제 완료</h2>
	<a href="get.jsp">삭제된 세션 조회</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("phone", "0100-222-333");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	request 공유영역 id : ${id }<br>
	날라온 파라미터 name정보:	 : ${param.name }<br>
	날라온 파미터 age 정보 : ${param.age }<br>
	<h3>인클루드된 내용</h3>
	<h3>인클루드된 내용</h3>
	<h3>인클루드된 내용</h3>
	<h3>인클루드된 내용</h3>
	<h3>인클루드된 내용</h3>
	<hr>
</body>
</html>
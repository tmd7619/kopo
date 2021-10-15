<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="msg" value="hello!"/>
	value 속성만 지정 : <c:out value="hello world" /><br>
	msg변수 미설정 : <c:out value="${msg }" /> <br>
	msg변수 미설정 : <c:out value="${msg }" default="값이 없음"/> <br>
	
	value속성에 태그가 들어있는 경우(escapeXml=true)<br>
	<c:out value="<h1>Hello</h1>" />
	<br> 
	value속성에 태그가 들어있는 경우(escapeXml=false)<br>
	<c:out value="<h1>Hello</h1>" escapeXml="false"/>
</body>
</html>
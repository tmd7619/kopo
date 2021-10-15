<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1값을 가지는 변수 cnt를 공유영역에 등록(page)<br> <%-- default scope : page --%>
	<c:set var="cnt" value="1" ></c:set>
	공유영역에 등록한 변수 cnt 출력 <br>
	cnt : ${cnt } <br>
	
	cnt변수에 1을 더한 후 cnt 값을 출력 <br>
	<c:set var="cnt" value="${cnt +  1}" scope="request" /> 
	request cnt: ${requestScope.cnt }<br>
</body>
</html>

<%--

	JSP공유영역					EL 공유영역			JSTL공유영역
	pageContext					pageScope			page
	request						requestScope		request
	ssession					sessionScope		session
	application					applicationScope	appilication




--%>
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
	1값을 가지는 변수 cnt를 공유영역에 등록(page)<br>
	<c:set var="cnt" value="1" ></c:set>
	공유영역에 등록한 변수 cnt 출력 <br>
	cnt : ${cnt }
	
	cnt변수에 1을 더한 후 cnt 값을 출력 <br>
	<c:set val="cnt" value="${cnt +  1}" scope="" /> 
	request cnt: ${requestScope.cnt }<br>
	
	request 공유영역에 등록된 cnt 변수 삭제 <br>
	<c:remove var="cnt" scope="request" /> <%--주의 : scope 미 설정시 모든 영역이 삭제 대상 --%>
	cnt삭제후<br>
	cnt : ${cnt };
	request cnt : ${requestScope.cnt }<br>
	
</body>
</html>

<%--

	JSP공유영역					EL 공유영역			JSTL공유영역
	pageContext					pageScope			page
	request						requestScope		request
	ssession					sessionScope		session
	application					applicationScope	appilication




--%>
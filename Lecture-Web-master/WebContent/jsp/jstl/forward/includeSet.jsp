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
	<h2>결과화면</h2> <%-- '결과화면'은 출력되지 않음. foward jsp가 출력됨 --%>
	<c:if test="${param.id eq 'admin' }">
	<jsp:forward page="admin.jsp" /> <%-- url는 forwardSet.jsp --%>
	</c:if>
</body>
</html>
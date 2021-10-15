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
	<c:choose>
		<c:when test="${empty param.type  }">
			<h2>파라미터가 잘못되었습니다.</h2>
		</c:when>
		<c:when test="${param.type == 'U' }">
			<h2>일반사용자님 환영합니다.</h2>
		</c:when>
		<c:otherwise>
			<h2>관리자님 환영합니다.</h2>			
		</c:otherwise>
	</c:choose>

</body>
</html> 
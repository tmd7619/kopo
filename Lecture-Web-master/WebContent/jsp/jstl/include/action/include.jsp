<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<% 

	request.setAttribute("id", "hong");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	msg : <%= msg %><br>
	id : ${id }<br>
	one.jsp에 요청 전: phone : ${phone }
	<h2>인클루드전</h2><br>
	<strong>파라미터 미설정</strong><br>
	<jsp:include page="one.jsp" />
	
	<strong>파라미터 설정</strong><br>
	<jsp:include page="one.jsp" > <%-- 실행시점에서 one.jsp불러옴 --%>
		<jsp:param name="name" value="hong gil dong"/>	
		<jsp:param name="age" value="30" />
	</jsp:include>
	<h2>인클루드후</h2>
	
	
	one.jsp에 요청 후 :  phone : ${phone }
	
</body>
</html>
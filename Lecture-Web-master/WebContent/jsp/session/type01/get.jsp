<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	String password = (String)session.getAttribute("password");
	String gid = session.getId();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	설정된 세션 ID : <%=id	 %><br>
	설정된 고유 ID : <%=gid	 %><br>
	설정된 세션 PASSWORD : <%= password%><br>
	<br>
	설정된 세션 ID : ${sessionScope.id }<br> <%-- EL표현식으로 나타내기 --%>
	설정된 세션 PASSWORD : ${sessionScope.password }<br>
	<a href="remove.jsp">세션삭제</a>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//	객체 등록 : 공유영역명.setAttribute("name",'value")
	//  객체 조회 : 공유영역명.getAttribute("name")
	//	공유영역 4가지 : pageContext, request, session, application
	
	pageContext.setAttribute("msg", "pageContext영역에 등록");
	String message = (String) pageContext.getAttribute("msg");
	
	// request 영역에 id라는 이름으로 hong 값을 등록
	request.setAttribute("id","hong");
	
	request.setAttribute("msg", "request영역에 객체 등록");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	empty msg true or false? : ${empty msg }
	<br> msg : <%=message%><br> 
	msg : <%=pageContext.getAttribute("msg")%><br> 
	el defalut msg : ${msg }<br>
	el request msg : ${requestScope.msg } <br> <%-- 공유객체명.객체명 으로 동일한 name값을 구별하여 출력할 수 있다 --%>
	el id : ${id } <br>
	
	
	<br>
</body>
</html>
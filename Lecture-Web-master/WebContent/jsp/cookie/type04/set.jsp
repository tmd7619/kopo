<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("type01", URLEncoder.encode("/ 루트설정", "utf-8"));
	cookie.setPath("/");
	
	Cookie cookie2 = new Cookie("type02", URLEncoder.encode("/Lecture-Web/jsp/cookie 루트설정", "utf-8"));
	cookie2.setPath("/Lecture-Web/jsp/cookie");
	
	Cookie cookie3 = new Cookie("type03", URLEncoder.encode("/Lecture-Web/jsp/cookie/type03 루트설정", "utf-8"));
	cookie3.setPath("/Lecture-Web/jsp/cookie/type03");
	      
	Cookie cookie4 = new Cookie("type04", URLEncoder.encode("/Lecture-Web/jsp/cookie/type04 루트설정", "utf-8"));
	cookie4.setPath("/Lecture-Web/jsp/cookie/type04");
	
	Cookie c = new Cookie("cookieName", "cookieValue");
	
	response.addCookie(cookie);
	response.addCookie(cookie2);
	response.addCookie(cookie3);
	response.addCookie(cookie4);
	response.addCookie(c);
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키설정 완료</h2>
	<a href="get.jsp">설정된 쿠키조회</a>
	
</body>
</html>
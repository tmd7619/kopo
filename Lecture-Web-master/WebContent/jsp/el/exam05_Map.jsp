<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Map<String, String> board = new HashMap<String, String>();
	board.put("no","1");
	board.put("title","test");
	
	pageContext.setAttribute("boardVO", board);
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	no : <%= board.get("no") %><br>
	title : <%= board.get("title") %><br>
	
	el no : ${boardVO.no }<br> <%-- Map객체.이름  // 이름: key값 --%>
	el title : ${boardVO.title }<br>
	el title : ${boardVO['title'] }<br>
	
	el aaa : ${boardVO.aaa }


</body>
</html>
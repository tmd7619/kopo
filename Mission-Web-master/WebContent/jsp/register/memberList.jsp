<%@page import="kr.ac.kopo.member.dao.MemberDAO"%>
<%@page import="kr.ac.kopo.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<%
	MemberDAO dao = new MemberDAO();
	List<MemberVO> list = dao.selectAll();
	
	
	pageContext.setAttribute("list", list);
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 회원 목록 조회</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"/>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"/>
<script src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('#registerBtn').click(function(){
			location.href = "registerForm.jsp"
		})
		
		$('#gotoIndexBtn').click(function(){
			location.href = "/Mission-Web/index.jsp"
		})
	})

</script>
</head>
<body>
	<div align="center">
	<hr width=80%">
	<h2>전체 회원 목록 조회</h2>
	<hr width="80%">
	<br>
		<table border="1" style="width: 80%;">
			<tr>
				<th width="20%">아이디</th>
				<th width="15%">이름</th>
				<th width="10%">타입</th>
				<th width="20%">등록일</th>
				<th width="10%">상세보기</th>
			</tr>
				<c:forEach items="${list }" var="member" varStatus="loop">
			<tr>
					<td><c:out value="${member.id }"/></td>
					<td><c:out value="${member.name }"/></td>
					<td><c:out value="${member.type }"/></td>
					<td><c:out value="${member.regDate }"/></td>
					<td><a href="memberDetail.jsp?id=${member.id }">상세보기</a></td>
			</tr>
				</c:forEach>
		</table>
		<br>
		<button id="registerBtn">회원가입</button>
		<button id="gotoIndexBtn">뒤로가기</button>
	</div>

</body>
</html>


<%@page import="kr.ac.kopo.member.dao.MemberDAO"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="kr.ac.kopo.member.vo.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"/>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"/>
</head>
<body>
	<div align="center">
		<hr width="80%">
		<h2>${userVO.name}님의 회원정보 상세보기</h2>
		<hr width="80%">
		<br>
		<table border="1" style="width: 80%">
			<tr>
				<th width="25%">아이디</th>
				<td>${userVO.id}</td>
			</tr>
			<tr>
				<th width="25%">비밀번호</th>
				<td>${userVO.password}</td>
			</tr>
			<tr>
				<th width="25%">이름</th>
				<td>${userVO.name}</td>
			</tr>
			<tr>
				<th width="25%">이메일</th>
				<td>${userVO.emailId }@${userVO.emailDomain }</td>
			</tr>
			<tr>
				<th width="25%">주소</th>
				<td>${userVO.post }번지 
					${userVO.basicAddr }
					${userVO.detailAddr }
				</td>
			</tr>
				<tr>
				<th width="25%">등록유형</th>
				<td>${userVO.type }
			</tr>
			<tr>
				<th width="25%">가입날짜</th>
				<td>${userVO.regDate }</td>
			</tr>
		</table>
	</div>


</body>
</html>
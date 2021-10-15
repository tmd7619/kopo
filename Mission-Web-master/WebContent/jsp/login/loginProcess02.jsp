<%@page import="kr.ac.kopo.member.dao.MemberDAO"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	작업순서
	1. login.jsp에서 날라오는 파라미터 추출(id, password)
	2. 추출된 id, password에 맞는 회원의 존재여부 판단(DB,t_member)
	3. 로그인 성공 시 , 세션에 회원정보를 등록 
	4. 존재여부에 따른 페이지를 이동(로그인 성공 : index.jsp, 로그인 실패 : login.jsp)
--%>

<%
response.setCharacterEncoding("utf-8");
	
	//파라미터 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	System.out.println("id : "+ id + "password : " + password); // sysout으로 값들을 찍어보는 것이 좋다.
	
	//객체 생성 및 초기화
	MemberVO memberVO = new MemberVO();
	memberVO.setId(id);
	memberVO.setPassword(password);
	
	// DB에서 로그인 수행
	MemberDAO dao = new MemberDAO();
	MemberVO userVO = dao.login(memberVO);
	
	/*
		userVO null이면 로그인 실패
		userVO not null이면 로그인 성공
	*/
	String msg = null;
	String url = null;
	if(userVO == null){
		msg = "아이디 또는 패스워드를 잘못 입력하셨습니다.";
		url = "/Mission-Web/jsp/login/login.jsp";
	}else{
		msg = userVO.getName() + "님 환영합니다.";
		url = "/Mission-Web/index.jsp";
	}
	
	// 세션 등록
	session.setAttribute("userVO", userVO);
	
//	response.sendRedirect(url); // 공유객체 접근 불가 // msg를 넘기기 위해서는 param을 써야하는 단점이 존재
	
	pageContext.setAttribute("msg", msg);
	pageContext.setAttribute("url", url);
%>
<script>
	alert('${msg}'); // 해석순서상 script가 가장 마지막애 해석됨 -> ${msg}을 단순 문자열로 해석하기 위해서는 ' '붙여야함
	location.href = '${url}'
</script>
<%-- <jsp:forward page="${url}"/> --%> <%-- 페이지 이동의 목적으로 포워드를 쓰면 안됨 // url이 바뀌지 않음 //seneRedirect 써야함 --%>


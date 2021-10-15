<%@page import="kr.ac.kopo.member.dao.MemberDAO"%>
<%@page import="kr.ac.kopo.member.vo.MemberVO"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	request.setCharacterEncoding("utf-8");
	
	MemberVO member = new MemberVO();	
	
	member.setBasicAddr(request.getParameter("basicAddr"));
	member.setDetailAddr(request.getParameter("detailAddr"));
	member.setEmailDomain(request.getParameter("emailDomain"));
	member.setEmailId(request.getParameter("emailId"));
	member.setId(request.getParameter("id"));
	member.setName(request.getParameter("name"));
	member.setPassword(request.getParameter("password"));
	member.setPost(request.getParameter("post"));
	member.setTel1(request.getParameter("tel1"));
	member.setTel2(request.getParameter("tel2"));
	member.setTel3(request.getParameter("tel3"));
	
	MemberDAO dao = new MemberDAO();
	
	dao.register(member);
	
%>    
    
<script>
   alert('회원가입이 완료되었습니다.')
   location.href="/Mission-Web/login/loign.jsp"
</script>
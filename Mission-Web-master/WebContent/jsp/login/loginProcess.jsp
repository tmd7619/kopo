<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	작업순서
	1. login.jsp에서 날라오는 파라미터 추출(id, password)
	2. 추출된 id, password에 맞는 회원의 존재여부 판단(DB,t_member)
	3. 로그인 성공 시 , 세션에 회원정보를 등록 
	4. 존재여부에 따른 페이지를 이동(로그인 성공 : index.jsp, 로그인 실패 : login.jsp)
--%>

<%
	request.setCharacterEncoding("utf-8");

	MemberVO member = new MemberVO();
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	Connection conn = new ConnectionFactory().getConnection();
    StringBuilder sql = new StringBuilder();
	
    sql.append("select id,password,name,email_id,email_domain ");
    sql.append(" , tel1,tel2,tel3,post,basic_addr, detail_addr ");
    sql.append(" from t_member where id = ? and password = ? ");
    
    PreparedStatement pstmt = conn.prepareStatement(sql.toString());
    pstmt.setString(1, id);
    pstmt.setString(2,password);
    
    ResultSet rs = pstmt.executeQuery();

    
    if(rs.next()){
    	String name = rs.getString("name");
    	
    	member.setId(id);
    	member.setPassword(password);
    	member.setName(name);
    	
    	session.setAttribute("member", member);
    }
    
    JDBCClose.close(conn, pstmt);
    
%>
	<c:choose>
		<c:when test="${not empty sessionScope.member }">
			<c:import url="/index.jsp"></c:import>
		</c:when>
		<c:otherwise>
			<c:import url="/jsp/login/login.jsp"></c:import>
		</c:otherwise>
	</c:choose>



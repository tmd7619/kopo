<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

	request.setCharacterEncoding("utf-8");

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	int no =  Integer.parseInt(request.getParameter("no"));

	 BoardVO board = new BoardVO();
     board.setTitle(title);
     board.setNo(no);
     board.setContent(content);
	
     BoardDAO dao = new BoardDAO();
	 dao.update(board);

%>
<script>
   alert('수정이 완료되었습니다.')
   location.href="detail.jsp?no=${param.no}"
</script>


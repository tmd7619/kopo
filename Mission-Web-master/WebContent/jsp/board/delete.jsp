<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String no = request.getParameter("no");
	
	BoardVO boardVO = new BoardVO();
	boardVO.setNo(Integer.parseInt(no));
	
	BoardDAO dao = new BoardDAO();
	dao.delete(boardVO);
	
%>
<script>
	alert('게시글이 삭제되었습니다.')
	location.href = "list.jsp"
</script>

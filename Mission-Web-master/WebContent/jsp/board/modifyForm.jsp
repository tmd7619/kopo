<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

/*
	1.  파라미터 추출(no)
	2.	해당 게시물을 조회(DB, T_BOARD)
	3.	form에 해당 조회된 게시글을 화면에 출력 
*/

	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDAO dao = new BoardDAO();
	BoardVO board = dao.selectByNo(no);
	
	pageContext.setAttribute("board", board);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"/>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"/>
<script src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>
	
	$(document).ready(function() {
		$('#goListBtn').click(function() {
			location.href = "list.jsp"
	
		})
		
	})

	function doWrite() {
	
		let f = document.writeForm
		if (f.title.value == '') {
			alert('제목을 입력하세요')
			f.title.focus()
			return false
		}
		if (f.writer.value == '') {
			alert('작성자를 입력하세요')
			f.writer.focus()
			return false
		}
		if (f.content.value == '') {
			alert('내용을 입력하세요')
			f.content.focus()
			return false
		}
	
		return true
	
	}

</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/tobMenu.jsp" />
	</header>
	<section>
		<div align="center">
		<hr width="80%">
		<h2>게시판 상세</h2>
		<hr width="80%">
		<br>
		<form action="modify.jsp" method="post" onsubmit="return doWrite()"
			name="writeForm">
		<%-- <input type="hidden" name="no" value="${param.no }"> --%> 
		<input type="hidden" name="no" value="${board.no }"> <%-- board no 값을 파라미터로만 넘기려고 할 때 --%>
		<table border="1" style="width: 80%">
			<tr>
				<th width="25%">번호</th>
				<td><c:out value="${ board.no }" /></td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td><input type="text" name="title" value="${board.title }"></td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td><c:out value="${ board.writer }" /></td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td><textarea rows="8" cols="60" name="content">${board.content }</textarea></td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td><c:out value="${ board.viewCnt }" /></td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td><c:out value="${ board.regDate }" /></td>
			</tr>
		</table>
		
			<input type="submit" value="수정하기">
			<input type="button" id="goListBtn" value = "취소~">
		</form>
		<br>
	</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %> <%-- include는 경로가 프로젝트명(Mission-Web) 다음으로 정의됨 !!! --%>
	</footer>
</body>
</html>


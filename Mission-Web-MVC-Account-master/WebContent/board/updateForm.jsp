<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<!-- <link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"/> -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/board.css"/>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script>
	
	$(document).ready(function() {
		$('#goListBtn').click(function() {
			location.href = "<%=request.getContextPath() %>/board/list.do"
	
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
		<jsp:include page="/include/topMenu.jsp" ></jsp:include>
	</header>
	<section>
		<div align="center">
		<hr width="50%">
		<h2>게시판 상세</h2>
		<hr width="50%">
		<br>
		<form action="<%=request.getContextPath() %>/board/updateProcess.do" method="post" onsubmit="return doWrite()"
			name="writeForm">
		<%-- <input type="hidden" name="no" value="${param.no }"> --%> 
		<input type="hidden" name="no" value="${board.no }"> <%-- board no 값을 파라미터로만 넘기려고 할 때 --%>
		<table border="1" style="width: 50%">
			<tr>
				<th width="25%">번호</th>
				<td><c:out value="${board.no }" /></td>
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
		<jsp:include page="/include/bottom.jsp" ></jsp:include>
	</footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글등록</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/board.css"/>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script>	

	if('${ userVO }' == '') {
		location.href = "<%=request.getContextPath() %>/login.do"
	}

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
		<jsp:include page="/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<hr width="50">
			<h2>답글 작성</h2>
			<hr width="50">
			<br>
			 <form method="post" action="/board/replyProcess.do?page=${page}" name="boardForm">
				<input type="hidden" name="writer" value="${userVO.id }">
				<input type="hidden" name="no" value="${board.no}"/>
   				<input type="hidden" name="board_re_ref" value="${board.board_re_ref}"/>
				<table border="1" style="width: 50%">
					<tr>
						<th width="25%">제목</th>
						<td><input type="text" size="60" name="title"></td>
					</tr>
					<tr>
						<th width="25%">작성자</th>
						<td><c:out value="${userVO.id }"></c:out></td> <%-- input태그가 아니기 때문에 파라미터가 날라가지 않는다.//hidden사용 --%>
						<%-- <td><input type="text" size="60" name="writer" value="${userVO.id }" readonly></td> --%>
					</tr>
					<tr>
						<th width="25%">내용</th>
						<td><textarea rows="8" cols="60" name="content"></textarea></td>
					</tr>
				</table>
				<br> <input type="submit" value="등록하기"> <input
					type="button" value="목록으로" id="goListBtn">
			</form>
		</div>
	</section>
	<footer>
		<jsp:include page="/include/bottom.jsp" />
	</footer>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/board.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/layout.css"/>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>	

/* 	if('${ userVO }' == '') {
		location.href = "/Mission-Web/jsp/login/login.jsp"
	} */

	$(document).ready(function() {
		$('#goListBtn').click(function() {
			location.href = "${pageContext.request.contextPath}/board"

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
		<%-- <jsp:include page="/jsp/include/tobMenu.jsp" /> --%>
	</header>
	<section>
		<div align="center">
			<hr width="80%">
			<h2>게시글 등록폼</h2>
			<hr width="80%">
			<br>
			<form method="post" onsubmit="return doWrite()" name="writeForm"> <!-- 요청받은 get방식의 url와 똑같다면, action url 생략 가능 -->
				<table border="1" style="width: 80%">
					<tr>
						<th width="25%">제목</th>
						<td><input type="text" size="60" name="title"></td>
					</tr>
					<tr>
						<th width="25%">작성자</th>
						<td><input type="text" size="60" name="writer"></td>
						
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
		<%-- <%@ include file="/jsp/include/bottom.jsp"%> --%><%-- include는 경로가 프로젝트명(Mission-Web) 다음으로 정의됨 !!! --%>
	</footer>
</body>
</html>


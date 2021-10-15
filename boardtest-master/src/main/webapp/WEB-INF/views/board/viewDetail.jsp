<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>
</head>
<style>
	h2 { text-align: center;}
  table { width: 100%;}
  textarea { width: 100%;}
 	#outter {
		display: block;
		width: 30%;
		margin: auto;
	}
</style>
<body>

<h2>게시판</h2>
<br><br><br>
<div id="outter">
	<table border="1">
		<tr>
			<td>제목: ${board.title }</td>
		</tr>
		<tr>
			<td>
				작성자: ${board.writer }
				<span style="float: right;"><fmt:formatDate value="${board.regdate }" pattern="yyyy.MM.dd"/></span>
			</td>
		</tr>
		<tr>
			<td><div style="height: 300px; margin: 10px; display: inline-block">${board.content }</div></td>
		</tr>
	</table>
	<div style="float: right;">
		<input type="button" value="글 목록" onclick="location.href='board';">
		<input type="button" value="수정" onclick="location.href='modify?seq=${board.seq}'">
		<input type="button" value="삭제" onclick="del(${board.seq})">
	</div>
</div>
</body>
	<script>
		function del(seq) {
			var chk = confirm("정말 삭제하시겠습니까?");
			if (chk) {
				location.href='delete?seq='+seq;
			}
		}	
	</script>
</html>
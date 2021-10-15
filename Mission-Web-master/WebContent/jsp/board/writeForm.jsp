<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"/>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"/>
<script src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>	

	if('${ userVO }' == '') {
		location.href = "/Mission-Web/jsp/login/login.jsp"
	}

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
		// 파일 확장자 체크
		if(checkExt(f.attachfile1))
			return false
		if(checkExt(f.attachfile1))
			return false
			
		
		return true
	}
	
	// 첨부 가능 확장자인지 확인
	function checkExt(obj){
		let forbidName = ['exe','java','jsp','js','class']
		let fileName = obj.value
		let ext = fileName.substring(fileName.lastIndexOf('.')+1)
		
		for(let i = 0 ; i < forbidName.length; i ++){
			if(forbidName[i] == ext){
				alert(ext + '확장자는 파일업로드 검색에 위배됩니다')
				return true
			}
		}
		return false
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
			<h2>게시글 등록폼</h2>
			<hr width="80%">
			<br>
			<form action="write.jsp" method="post" onsubmit="return doWrite()"
				name="writeForm" enctype="multipart/form-data"> <%-- enctype를 지정하지 않으면 파일업로드x, request객체 접근 불가 --%>
				<input type="hidden" name="writer" value="${userVO.id }">
				<table border="1" style="width: 80%">
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
					<tr>
						<th>첨부파일</th>
						<td>
							<input type="file" name="attachfile1">
							<input type="file" name="attachfile2">
						</td>
					</tr>
				</table>
				<br> <input type="submit" value="등록하기"> <input
					type="button" value="목록으로" id="goListBtn">
			</form>
		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp"%><%-- include는 경로가 프로젝트명(Mission-Web) 다음으로 정의됨 !!! --%>
	</footer>
</body>
</html>


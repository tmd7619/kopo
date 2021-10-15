<%@page import="java.util.List"%>
<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/board.css"/>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script>
	
	$(document).ready(function(){
		
		$('#goListBtn').click(function(){
			
			location.href = "<%=request.getContextPath()%>/board/list.do"
		})
		
	})
	
	function modifyBoard(boardNo){
			location.href = "<%= request.getContextPath()%>/board/updateForm.do?no=${board.no }"
	}
	
 	function deleteBoard(boardNo){
		if(confirm('정말 삭제하시겠습니까?'))
			location.href = "<%= request.getContextPath()%>/board/delete.do?no=${board.no }"
	} 
 	
    function changeView(value) // 답글버튼을 누를 경우 실행 // 현재 게시글 번호와 페이지 번호를 같ㅇ ㅣ전송
    {
        if(value == 0)    location.href="BoardListAction.bo?page=${pageNum}";
        else if(value == 1){
            location.href='<%=request.getContextPath()%>/board/replyForm.do?num=${board.no}&page=${pageNum}';
        }
            
    }
</script>
</head>


<body>
	<header>
		<jsp:include page="/include/topMenu.jsp" ></jsp:include>
	</header>
	<section>
		<div align="center">
		<hr width="50">
		<h2>게시판 상세</h2>
		<hr width="50%">
		<br>
		
		<table border="1" style="width: 50%">
			<tr>
				<th width="10%">번호</th>
				<td><c:out value="${ board.no }" /></td>
			</tr>
			<tr>
				<th width="10%">제목</th>
				<td><c:out value="${ board.title }" /></td>
			</tr>
			<tr>
				<th width="10%">작성자</th>
				<td><c:out value="${ board.writer }" /></td>
			</tr>
			<tr>
				<th width="10%">내용</th>
				<td><c:out value="${ board.content }" /></td>
			</tr>
			<tr>
				<th width="10%">조회수</th>
				<td><c:out value="${ board.board_count }" /></td>
			</tr>
			<tr>
				<th width="10%">등록일</th>
				<td><c:out value="${ board.regDate }" /></td>
			</tr>
			
		</table>
		<br>
		<c:choose>
		<c:when test="${ userVO.id eq board.writer }">
		<button onclick="modifyBoard('${board.no}')">수정</button>
		<button  onclick="deleteBoard('${board.no}')">삭제</button>
		</c:when>
		</c:choose>
		<button type="button"  onclick="changeView(1)" >답글</button>
		<button id="goListBtn">목록</button>
	</div>
	</section>
	<footer>
		<jsp:include page="/include/bottom.jsp" ></jsp:include>
	</footer>
</body>
</html>


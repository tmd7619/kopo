<%@page import="kr.ac.kopo.board.vo.BoardFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	// 1. 게시물번호 추출
	int boardNo = Integer.parseInt(request.getParameter("no"));
	String type = request.getParameter("type"); 
	
	BoardDAO dao = new BoardDAO();
	
	// 2 -1 t_board  해당 게시물 조회수 증가 // 수정하고 다시 detail로 갈때는 cnt 올려주면 x
	if(type != null && type.equals("list")){ // type이 list일때만(list에서 호출될때만) view cnt 올려줌
		dao.updateViewCnt(boardNo);
	}
	// 2- 2  데이터베이스 t_board 테이블에서 해당 게시물 조회
	BoardVO board = dao.selectByNo(boardNo);
	
	// 2 -3 t_board_file테이블에서 게시물의 첨부파일 조회
	List<BoardFileVO> fileList =  dao.selectFileByNo(boardNo);
	
	pageContext.setAttribute("fileList", fileList);
	pageContext.setAttribute("board", board);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"/>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"/>
<script src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>
	
	$(document).ready(function(){
		
		$('#goListBtn').click(function(){
			
			location.href = "list.jsp"
		})
		
	})
	
	function modifyBoard(boardNo){
			location.href = 'modifyForm.jsp?no=' +boardNo ;
	}
	
	function deleteBoard(boardNo){
		if(confirm('정말 삭제하시겠습니까?'))
			location.href = 'delete.jsp?no=' +boardNo ;
	}
	
	/*
	function clickBtn(type){ // 교수님방법
		switch(type){
		case 'U' :
			location.href = "modify.jsp?no=${param.no}" // detail에서 no? 로 파라미터값 넘어오기 때문에 param.no 사용가능 
			break;
		case 'D' :
			if(confirm('[${param.no}]번 게시글을 삭제할까여?'))	
				location.href = 'delete.jsp?no=${param.no}'
			break;
		case 'L' :
			break;
		}
	}
	*/
	
	
	
	
	
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
		
		<table border="1" style="width: 80%">
			<tr>
				<th width="25%">번호</th>
				<td><c:out value="${ board.no }" /></td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td><c:out value="${ board.title }" /></td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td><c:out value="${ board.writer }" /></td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td><c:out value="${ board.content }" /></td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td><c:out value="${ board.viewCnt }" /></td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td><c:out value="${ board.regDate }" /></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:forEach items="${ fileList }" var="file">  <%-- 업로드 후, upload디렉토리 새로고침 해줘야함 --%>
						<a href="/Mission-Web/upload/${ file.fileSaveName }" download>
							<c:out value="${ file.fileOriName }" />
						</a>
						(${ file.fileSize } bytes)
						<br>
					</c:forEach>
				</td>
			</tr>
			
		</table>
		<br>
		<button onclick="modifyBoard('${board.no}')">수정</button>
		<button  onclick="deleteBoard('${board.no}')">삭제</button>
		<button id="goListBtn">목록</button>
		<%--button onclick="clickBtn('U')">수정</button> 교수님방법  --%> 
	</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %> <%-- include는 경로가 프로젝트명(Mission-Web) 다음으로 정의됨 !!! --%>
	</footer>
</body>
</html>


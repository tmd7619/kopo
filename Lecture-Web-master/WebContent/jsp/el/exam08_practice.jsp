<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	// 1. 자바빈즈클래스 + 콜렉션 // 가장 일반적인 경우로, 많이 쓰임
	BoardVO board = new BoardVO();
	board.setTitle("성공");
	
	List<BoardVO> boardList = new ArrayList<BoardVO>();
	boardList.add(board);
	
	pageContext.setAttribute("boardList", boardList); // 객체 등록
	
	// 2. 자바빈즈클래스 + 배열
	BoardVO board02 = new BoardVO();
	board.setTitle("성공");
	BoardVO[] boardList02 = new BoardVO[]{board};
	
	pageContext.setAttribute("boardList02", boardList02);
	
	// 3. 맵객체 + 배열
	Map<String,String> board03 = new HashMap<>();
	board03.put("title","성공");
	Map[] boardList03 = {board03}; 
	
	pageContext.setAttribute("boardList03", boardList02);
	
	// 4. 맵객체 + 콜렉션
	Map<String,String> board04 = new HashMap<>();
	board04.put("title","성공");
	List<Map<String,String>> boardList04 = new ArrayList<>();
	boardList04.add(board04);
	
	pageContext.setAttribute("boardList03", boardList02);
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 성공 / 실패 / 성공이라 나오는 코드 작성  --%>
	성공/실패 ? ${boardList[0].title}<br>
	성공/실패 ? ${boardList02[0].title}<br>
	성공/실패 ? ${boardList03[0].title}<br>
	성공/실패 ? ${boardList04[0].title}<br>
	
	성공/실패 ? ${boardList[0].title ne '' ? "성공" : "실패" }
</body>
</html>
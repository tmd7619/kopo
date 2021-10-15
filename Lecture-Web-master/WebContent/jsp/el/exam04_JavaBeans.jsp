<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    BoardVO board = new BoardVO();
    
    board.setNo(1);
    board.setTitle("test");
    
    //pageContext영역 이름 : boardVO, 값 : 생성된 boardVO 객체
    pageContext.setAttribute("boardVO", board);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   no : <%= board.getNo() %><br>
   no : <%= ((BoardVO)pageContext.getAttribute("boardVO")).getNo() %><br> <%-- getAttribute로 출력하는 것 보다, 자바빈즈클래스.getter함수로 출력하는 것이 간편 --%>
   title : <%= board.getTitle() %><br>
   title : <%= ((BoardVO)pageContext.getAttribute("boardVO")).getTitle() %><br>

   el no : ${boardVO.no}<br /> <%-- .no을 하면, 내부적으로 getter메소드를 호출하게 된다. 명명규칙 :get 뒤에 오는 글자 소문자로 출력 --%>
   el title : ${boardVO.title}<br />
<%--    el aaa : ${boardVO.aaa }<br> 500error --%> 
 
 </body>
</html>
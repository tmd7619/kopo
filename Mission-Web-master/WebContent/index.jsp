<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"/>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"/>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/tobMenu.jsp" />
	</header>
	<section>
		section부분
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %> <%-- include는 경로가 프로젝트명(Mission-Web) 다음으로 정의됨 !!! --%>
	</footer>
</body>
</html>
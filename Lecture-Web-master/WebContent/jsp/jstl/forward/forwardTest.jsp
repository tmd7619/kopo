<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<%--<form action="includeSet.jsp">  // include는 '결과화면'까지 같이 출력됨--%>  
	<form action="forwardSet.jsp">
		id : <input type="text" name="id">
		<input type="submit" value="전송">
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="set.jsp" method="post"> <%-- cookie이름과 값을 보여줄 필요는 없기 때문에 post방식 사용 --%>
		쿠키이름 : <input type="text" name="cName"><br>
		쿠키값 : <input type="text" name="cValue"><br>
		유효시간(분) : <input type="text" name="cAge"><br>
		<input type="submit" value="쿠키설정">
	</form>
	
</body>
</html>
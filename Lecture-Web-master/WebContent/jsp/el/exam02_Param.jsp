<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		http://localhost:9999/Lecture-Web/jsp/el/exam02_Param.jsp?id=aaa&name=bbb
		요청했을 때의 name, id값을 추출
	 --%>
	 
	 <%--
	 	http://localhost:9999/Lecture-Web/jsp/el/exam02_Param.jsp를 호출하면? -> 500 error 
	 	why? -> hobbies의 배열의 값이 null이기 때문에, null 값을 가리키는 error가 발생 -> 34~35행으로 널값 처리 해줘야함
	 	but param은 null값이면, empty로 인식하기 때문에 error로 인식이 안된다 -> 자바코드에 비해 훨씬 유연하다.
	 	
	  --%>
	 <%
	 	String id = request.getParameter("id");
	 %>
	id : <%= id  %> <br>	 
	id : <%= request.getParameter("id") %> <br>
	el id : ${	param.id }<br>
	
	name : <%= request.getParameter("name") %> <br>
	el name : ${param.name }<br>
	
	<%--
		http://l  ocalhost:9999/Lecture-Web/jsp/el/exam02_Param.jsp?id=aaa&name=bbb&hobby=music&hobby=movie
		요청했을 때 hobby의 music 추출
	 --%>
	<% String[] hobbies = request.getParameterValues("hobby");
	   if(hobbies == null){
		   hobbies = new String[]{"파라미터 없음"};
		   }
	%><br>
	hobby : <%= hobbies[0] %> <br>
	
	el hobby : ${paramValues.hobby[0]} <%-- music값만 출력 paramValues는 return값이 배열 형태// 복수의 값 출력 --%>
	
	
</body>
</html>
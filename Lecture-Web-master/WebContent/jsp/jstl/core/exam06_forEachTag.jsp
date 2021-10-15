<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	// 각 이름이 끝날때마다 콤마를 찍기 (단, 맨 마지막 이름 뒤에는 찍지 않는다)

	String[] names = {"홍길동","강길동","운길동","박길동"};
	pageContext.setAttribute("names", names	);
	pageContext.setAttribute("namesLength", names.length);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- fn 함수 --%>
	"hello world" 문자열 길이 : ${fn:length("hello world") } <hr>
	배열의 요소개수 : ${fn:length(names) }<hr>
	<c:forEach begin="0" end="${fn:length(names)-1 }"  var="i">
		<c:if test="${i ne 0 }">
			,
		</c:if>
		${names[i] }
	</c:forEach>
	
	<%--------------------------------------------------------------------------------- --%>
	
	
	<%-- forEach --%>
	
	<c:forEach items="${names }" var="name" varStatus="loop">		 
		${loop.first} : ${loop.index} : ${loop.count } : ${loop.last }<br>
	</c:forEach>
	<hr>
	
	<c:forEach items="${names}" var="name" varStatus="loop">
		<%-- <c:if test="${loop.index ne 0  }"> --%>
		<%-- <c:if test="${loop.count ne 1  }"> --%>
		<c:if test="${not loop.first   }">
			,
		</c:if>
		${name }
	</c:forEach>
	
	
	
	<hr>
	<c:set var="cnt" value="0"/>
	<c:forEach items="${names}" var="name">
		<c:if test="${cnt != 0  }">
		,
		</c:if>
		${name }
		<c:set var="cnt" value="${ cnt+1}"/>
	</c:forEach>
	<c:remove var="cnt" scope="page" />	
	
	<hr>
	<c:forEach begin="0" end="${namesLength-1 }"  var="i">
		<c:if test="${i ne 0 }">
			,
		</c:if>
		${names[i] }
	</c:forEach>
	
	

	<hr>
	<h2>기존 자바 구문으로 1 ~ 10 사이의 정수 출력</h2>
	<%
		for(int i = 1 ; i <= 10 ; i ++){
			out.write(i+ "<br>");
		}
	%>
	
	<h2> forEach문으로 1 ~ 10 사이의 정수 출력</h2>
	<c:forEach begin="1" end="10" var="i"> <%-- i는 forEach에서만 적용되는 변수  --%>
		${i }<br>
	</c:forEach>
		
	년도 선책 : 
	<select>
		<c:forEach begin="1940" end="2021" var="year" step="5">
			<option>${year }</option>
		</c:forEach>
	</select>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#msgView {
	border: 1px solid red;
	height: 200px;
	width: 500px;
}
</style>
<script>
   let httpRequest = null

   function requestMsg() {
      // 1단계 : XMLHttpRequest 객체 생성
      if(window.XMLHttpRequest)
            httpRequest = new XMLHttpRequest()
      else if(window.ActiveXObject) // 익스플로어 5와 6버전에서는 ActiveXObject로 생성해야함
            httpRequest = new ActiveXObject("Microsoft.XMLHTTP")  
      else
            httpRequest = null;
   
      // 2단계 : callback 함수 설정
      httpRequest.onreadystatechange = responseMsg // onreadystatechange는 XMLHttpRequest 객체의 readyState값이 
      											   // 변할 때마다 자동으로 호출되는 함수를 설정함 
      
      // 3단계 : 서버에 비동기 요청  // open('get/post방식','응답url','true=비동기/false=비동기')
      httpRequest.open('GET', '/Lecture-Web/ajax/hello', true) // HelloServlet 클래스가 요청/응답 수행
      httpRequest.send(null) // get방식일 경우, null
      
   }
   
   function responseMsg() {
   		if(httpRequest.readyState == 4){ // 서버 응답 완료 시,
   			if(httpRequest.status == 200){ // 서버 응답이 올바를 시,
				/* alert(httpRequest.responseText) */ // 서버에 응답결과를 문자열로 받기
				let msgView = document.getElementById("msgView")
				msgView.innerHTML = httpRequest.responseText // innerHTML은 HTML태그가 적용된 채로 값이 가져와짐 
				/* msgView.innerHTML += httpRequest.responseText */ // 이어서 계속 붙이기
   			}
   		}
   }
</script>
</head>
<body>
	<h2>서버에서 받은 메시지</h2>
	<div id="msgView"></div>
	<input type="button" value="서버에서 자료요청" onclick="requestMsg()">
</body>
</html>
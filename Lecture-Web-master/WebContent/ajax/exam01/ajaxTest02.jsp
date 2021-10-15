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
      
      if(window.XMLHttpRequest)
            httpRequest = new XMLHttpRequest()
      else if(window.ActiveXObject)
            httpRequest = new ActiveXObject("Microsoft.XMLHTTP")
      else
            httpRequest = null;
      
      // 2단계 : callback 함수 설정
      httpRequest.onreadystatechange = responseMsg
      
      // 3단계 : 서버에 비동기 요청
      httpRequest.open('GET', 'hello.jsp', true)
      httpRequest.send(null)
   }
   
   
   function responseMsg() {
   		if(httpRequest.readyState == 4){ // 서버 응답 완료 시,
   			if(httpRequest.status == 200){ // 서버 응답이 올바를 시,
				/* alert(httpRequest.responseText) */ // 서버에 응답결과를 문자열로 받기
				let msgView = document.getElementById("msgView")
				msgView.innerHTML = httpRequest.responseText
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
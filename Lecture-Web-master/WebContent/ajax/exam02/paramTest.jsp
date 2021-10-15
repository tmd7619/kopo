<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	let httpRequest = null
	
	
	function getXMLHttpRequest(){
		 let httpRequest = null
		 if(window.XMLHttpRequest)
	            httpRequest = new XMLHttpRequest()
	      else if(window.ActiveXObject)
	            httpRequest = new ActiveXObject("Microsoft.XMLHTTP")
	      else
	            httpRequest = null;
		 return httpRequest
	}
	
	
	function sendProcess(param){
		
		httpRequest = getXMLHttpRequest()
		/* alert(httpRequest) */
		
		httpRequest.onreadystatechange = callbackFunction  // 콜백함수? 어떤 이벤트가 발생했거나 특정 시점에 도달했을 때 시스템에서 호출하는 함수를 말한다. 
														   // httpRequest 객체의 readystate가 변경될 때 마다 콜백함수가 호출됨
		let msg ="========================================================================\n";
		msg += "/Lecture-Web/exam02/param.jsp?name="+param+"\n";
		debugTrace(msg)
		
		 param = encodeURIComponent(param) // 익스플로어의 경우, 파라미터가 바이트 형태로 보이게 됨 올바른 파라미터 값이 전달이 안돼, 400 error 발생 => encodeURIComponent 함수로 인코딩 설정 
		 let url = "param.jsp?name=" + param // name=value 형태로 값을 넘겨줌(요청) -> param.jsp에서 ${param.name}으로 접근이 가능하다
	     httpRequest.open('GET',url,true) // initalize request //  get 방식으로, 해당 url로 ,  비동기방식
	     httpRequest.send(null)	// request

	}
	
	function callbackFunction(){
		
		let msg =''
		switch(httpRequest.readyState){
		// httpRequest.readyState == 0 , uninitialzed
		case 1 : // 서버와의 연결이 성사됨
			msg += 'Loading...\n' 
			break;
		case 2 : // 서버가 request를 받음
			msg += 'Loaded.... \n'
			break;
		case 3 : // request를 처리하는 중
			msg += 'Interactive...\n'
			break;
		case 4 : // request에 대한 처리 완료 => 응답할 준비 완료
			msg += 'Completed...\n'
			if(httpRequest.status == 200){
				
				msg += '웹서버에서 정상적으로 수행...\n'
				msg += '실행 결과 : '+ httpRequest.responseText + '\n' // 서버의 응답결과를 문자열로 받기
			} else {
				
				msg += '웹서버에서 오류 발생 ....\n'
				msg += '오류코드 : '+ httpRequest.status+'\n'
			}
			msg +="========================================================================\n";
			break;
		}
		debugTrace(msg)
	}
	
	function debugTrace(msg){
		
		let debug = document.getElementById("debug") // getElementById : 주어진 문자열과 일치하는 id 속성을 가진 요소를 찾고, 이를 나타내는 Element 객체를 반환
		debug.value += msg 
		
	}
	
</script>
</head>
<body>
	<textarea rows="8" cols="80" id="debug"></textarea><br>
	<button onclick="sendProcess('hong gil-dong')">영문인자호출</button>
	<button onclick="sendProcess('홍길동')">한글인자호출</button>

</body>
</html>
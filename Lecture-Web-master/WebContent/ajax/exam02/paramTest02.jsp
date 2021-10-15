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
	
	
	function sendProcess(method, param){
		
		httpRequest = getXMLHttpRequest()
		/* alert(httpRequest) */
		
		httpRequest.onreadystatechange = callbackFunction 
		
		let msg ="========================================================================\n";
		msg += method + "/Lecture-Web/exam02/param2.jsp?name="+param+"\n";
		debugTrace(msg)
		
		let url = 'param2.jsp'
		param = encodeURIComponent(param) 
		let args = 'name=' + param
		
		if(method == 'GET'){
			httpRequest.open(method,url + '?' + args, true)
			httpRequest.send(null)
		} else if(method == 'POST') {
			httpRequest.open(method,url ,true)
			httpRequest.setRequestHeader('Content-type', 'application/x-www-form-urlencoded') // key value 형태로 요청값 전달
			httpRequest.send(args) // 파라미터 설정 
		}
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
				msg += '실행 결과 : '+ httpRequest.responseText + '\n'
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
		
		let debug = document.getElementById("debug")
		debug.value += msg
		
	}
	
</script>
</head>
<body>
	<form method="get" action="" enctype="application/x-www-form-urlencoded"></form>
	<textarea rows="8" cols="80" id="debug"></textarea><br>
	<button onclick="sendProcess('GET', 'hong gil-dong')">GET방식영문인자호출</button>
	<button onclick="sendProcess('GET', '홍길동')">GET방식한글인자호출</button>
	<button onclick="sendProcess('POST', 'hong gil-dong')">POST방식영문인자호출</button>
	<button onclick="sendProcess('POST', '홍길동')">POST방식한글인자호출</button>

</body>
</html>
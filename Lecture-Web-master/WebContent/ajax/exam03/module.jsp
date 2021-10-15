<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="httpRequest.js"></script>
<script>
	function clickBtn(){
		
		//httpRequest = getXMLHttpRequest()  httpRequest 객체가 잘 넘어오는지 확인
		//alert(httpRequest)
		let name = document.inputForm.name.value
		let age = document.inputForm.age.value
		let addr = document.inputForm.addr.value
		
		//console.log(name, age, addr)
		
        // 비동기 통신
	      
	    // 1단계
//	      sendProcess('POST', 'sample.jsp', "name=홍길동&age=30&addr=서울시서초구", callback)
	      
	    //2단계
//	      let params = 'name=' + name + '&age=' + age + '&addr=' + addr
//	      sendProcess('POST', 'sample.jsp', params, callback)

	    //3단계
//   	let params = {name : '홍순이', age: 30, addr: '경기도 광명시'}
        let params = {name:name ,age:age, addr:addr}
        sendProcess('GET', 'sample.jsp', params, callback)
	      
	   }

	
	function callback(){
		
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
	<h2>XMLHttpRequest 모듈을 사용한 예재</h2>
	<form name="inputForm">		
		<textarea rows="10" cols="80" id="debug"></textarea><br>
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		주소 : <input type="text" name="addr"><br>
		<button type="button" onclick="clickBtn()">서버에 자료요청</button> <%--버튼에 타입을 지정하지 않으면 form에 submit 역할을 할 수 있음 --%>
	</form>
</body>
</html>
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
		
		sendProcess('GET', 'sample.jsp', null , callback)
	      
	   }

	
	function callback(){
		
		let msg =''
		if(httpRequest.readyState == 4){
			if(httpRequest.status == 200){
				
				let data = httpRequest.responseText
				console.log(data)
			//	let memberList = JSON.parse(data) // String to JSON
				let memberList = eval(data) // eval : 문자열을 코드로 인식하여 실행시켜주는 함수
				console.log(memberList)
				
				msg += '회원수 : ' + memberList.length + '명\n'
				for(let i = 0 ; i < memberList.length; i ++){
					let mem = memberList[i] // mem은 key : value 형태의 객체 타입 
					console.log(mem)
					let id = mem.id // 객체명.key 으로 value 값 접근 가능 
					let name = mem.name
					msg += id + '(' + name + ')\n'
					
				}
			}
		}
			debugTrace(msg)
	}
	
	function debugTrace(msg){
		
		let debug = document.getElementById("debug")
		debug.value += msg // textarea에 msg값 출력
		
	}

</script>
</head>
<body>
	<h2>JSON DATA 예재</h2>
		<textarea rows="10" cols="80" id="debug"></textarea><br>
		<button type="button" onclick="clickBtn()">서버에 자료요청</button> 
</body>
</html>
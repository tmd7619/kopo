<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/Lecture-Web/jquery/js/jquery-3.6.0.min.js"></script>
<script src="httpRequest.js"></script>
<script>
	function clickBtn(){
		
		sendProcess('GET', 'sample.xml', null , callback)
	      
	   }

	
	function callback(){
		
		let msg =''
		if(httpRequest.readyState == 4){
			if(httpRequest.status == 200){
				
				/*
					개발자도구 체크해볼 것!!
					httpRequest.responseXML.getElementsByTagName('member')[0].getElementsByTagName("id")
				*/
				
				let xmlDoc = httpRequest.responseXML // 서버의 응답결과를 XML Document로 받기
				console.log(xmlDoc)
				let memberList = $(xmlDoc).find('member') // find : xmlDoc에서 member라는 태그를 찾겠다
				console.log(memberList)
				msg += '회원수 : ' + memberList.length + '명\n'
				
				memberList.each(function(){
					
					console.log(this) // this는 해당 선택자(memberList) 
					let id = $(this).find('id').text() // .text() : 셀랙터 태그에 포함된 자식태그 중, 태그를 제외한 텍스트만 읽어옴
					let name = $(this).find('name').text() // .html() : 셀렉터 태그에 포함된 자식태그를 통째로 읽어옴
					msg += id + "(" + name + ")\n"
				})
					
				debugTrace(msg)
			}
		}
	}
	
	function debugTrace(msg){
		
		let debug = document.getElementById("debug")
		debug.value += msg
		
	}

</script>
</head>
<body>
	<h2>XML DATA 예재 (jquery)</h2>
		<textarea rows="10" cols="80" id="debug"></textarea><br>
		<button type="button" onclick="clickBtn()">서버에 자료요청</button> 
</body>
</html>
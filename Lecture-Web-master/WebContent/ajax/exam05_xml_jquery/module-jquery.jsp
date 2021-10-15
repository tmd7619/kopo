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
				
				let xmlDoc = httpRequest.responseXML
				let memberList = xmlDoc.getElementsByTagName("member")
				msg += '회원수 : ' + memberList.length + '명\n'
				for(let i = 0 ; i < memberList.length; i ++){
					let mem = memberList[i]
					let id = mem.getElementsByTagName('id')[0].innerHTML
					let name = mem.getElementsByTagName('name')[0].firstChild.nodeValue
					
					msg += id + '(' + name + ')\n'
					//console.log(id.innerHTML)
					//console.log(id.firstChild.nodeValue)
					
					
					
				}
				
					
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
	<h2>XML DATA 예재</h2>
		<textarea rows="10" cols="80" id="debug"></textarea><br>
		<button type="button" onclick="clickBtn()">서버에 자료요청</button> 
</body>
</html>
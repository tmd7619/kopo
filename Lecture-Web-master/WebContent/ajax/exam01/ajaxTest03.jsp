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
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>


/* 
 	type	: 요청방식(text)
 	url		: 요청주소(text)
 	data	: 요청파라미터(문자열 or 객체)
 	success : 수신성공(함수)
 	error	: 수신실패(함수) // status != 200 || readyState != 4
 
 */

   $(document).ready(function(){
	   
	   $(':button').click(function(){
		   $.ajax({
			   'type' : 'get',
			   'url' : 'hello.jsp' , 
			   'success' : function(data){
				//	 console.log(data)
				//   $('#msgView').html(data)
					 $('#msgView').append(data)
			   } , 
			   'error' : function(){
				   alert('실패')
			   }
			   
			   
		   })
	   })	
	   
   })
</script>
</head>
<body>
	<h2>서버에서 받은 메시지</h2>
	<div id="msgView"></div>
	<input type="button" value="서버에서 자료요청" >
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/Mission-Web/resources/css/layout.css"/>
<link rel="stylesheet" href="/Mission-Web/resources/css/board.css"/>
<script src="/Mission-Web/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('#goListBtn').click(function(){
			location.href = "memberList.jsp"
	})
	})
</script>
</head>
<body>
	<div align="center">
		<hr width="60%">
		<h2>회원가입</h2>
		<hr width="60%">
		<br>
		<form action="register.jsp" method="post" >
			<table border="1" style="width : 60%">
			<tr>
				<th width="20%">아이디</th>
				<td>
					<input type="text" size="10" name="id" required>
					<button>아이디 확인</button>
				</td>
			</tr>
			<tr>
				<th width="20%">비밀번호</th>
				<td>
					<input type="password" size="10" name="password" required>
				</td>
			</tr>
			<tr>
				<th width="20%">비밀번호 확인</th>
				<td>
					<input type="password" size="10" name="pwdCheck" required>
				</td>
			</tr>			
			<tr>
				<th width="20%">이름</th>
				<td>
					<input type="text" size="10" name="name" required>
				</td>
			</tr>	
			<tr>
				<th width="10%">이메일</th>
				<td>
					<input type="text" size="10" name="emailId">
					<select name="emailDomain">
					   <option >이메일선택</option>
					   <option value="naver.com">naver.com</option>
					   <option value="daum.net">daum.net</option>
					   <option value="nate.com">nate.com</option>
				   </select>
				</td>
			</tr>	
			<tr>
				<th width="10%">전화번호</th>
				<td>
					<select name="tel1">
					   <option value="010">010</option>
					   <option value="011">011</option>
					   <option value="032">032</option>
					   <option value="070">070</option>
				   </select>
					<input type="text" size="5" name="tel2">
					<input type="text" size="5" name="tel3">
				</td>
			</tr>
			<tr>
				<th width="10%">우편번호</th>
				<td>
					<input type="text" size="10" name="post">
				</td>
			</tr>
			<tr>
				<th width="10%">시군구/동읍면</th>
				<td>
					<input type="text" size="20" name="basicAddr">
				</td>
			</tr>
			<tr>
				<th width="10%">상세주소</th>
				<td>
					<input type="text" size="60" name="detailAddr">
				</td>
			</tr>
							
			</table>
			<br>
			<input type="submit" value="회원가입">
			<input type="button" value="목록으로" id="goListBtn">
		</form>
	</div>


</body>
</html>
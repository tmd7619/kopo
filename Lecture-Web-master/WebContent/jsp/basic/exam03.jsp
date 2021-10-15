<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!private int sum = 0; //클래스에 선언이 되는것이기 때문에, 접근제한자를 붙여줘야 한다.%>
	sum :
	<%= sum %> <br>
	<%! 
	
		public int getSum(int val1, int val2){
		int sum = 0 ;
		for(int i = val1 ; i <= val2; i++) {
			sum += val1;
			
		}
		return sum;
	}
	%>
	1 ~ 10 사이의 총합 : <%= getSum(1,10) %> <br>
</body>
</html>
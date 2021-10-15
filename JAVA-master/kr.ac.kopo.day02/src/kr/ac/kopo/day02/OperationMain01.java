package kr.ac.kopo.day02;

public class OperationMain01 {
	
	public static void main(String[] args) {
		
		int num = 10 ;
		
		num = num + 1 ;

		num = num += 1 ; //  
		
		++num ; // 전위증감 연산자 ,선행처리  속도는 선행처리 > 후행처리
		num ++ ; // 후위증감 연산자,  후행처리
		
		
		System.out.println(num);
	}

}
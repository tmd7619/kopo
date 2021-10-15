package kr.ac.kopo.day02;

public class OperationMain02 {
	
	public static void main(String[] args) {
		int a = 1, b = -1, c = 0 ;
		
		boolean bool = ++a > 0 && ++b > 0 && ++c > 0; 
		
		System.out.println("bool : " + bool);
		 
		System.out.println("a  : " + a +  ", b : " + b + ", c : " + c); // c 값이 0인 이유? 
																		// 앞의 &&연산자가 Fasle가 나왔기 때문에, 뒤에 연산은 실행을 하지 않음
																		// 따라서 ++c가 아닌  c 값이 출력	
		
		
		boolean bool2 = a++ > 0 || b++ > 0 || c++ > 0; 
		
		System.out.println("bool2 : " + bool2);
		 
		System.out.println("a  : " + a +  ", b : " + b + ", c : " + c); // bool2 : true , a = 2, b  = -1 , c = 0
		
		
		boolean bool3 = a++ > 0 || b++ > 0 && c++ > 0;   				// 교집함이 합집합보다 우선순위가 높다
		
		System.out.println("bool3 : " + bool3);							// 계산은 왼쪽부터지만, 논리 단위가 a++ > 0 || (b++ > 0 && c++ > 0)로 묶인다.
		 
		System.out.println("a  : " + a +  ", b : " + b + ", c : " + c);	// bool : true , a = 2 , b = -1 c = 0
		
		
		
		
		
		
					
	}

}
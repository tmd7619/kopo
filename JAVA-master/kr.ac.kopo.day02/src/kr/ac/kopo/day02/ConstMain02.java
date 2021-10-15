package kr.ac.kopo.day02;

public class ConstMain02 {

	public static void main(String[] args) {
		
		char ch = 'A';
		
		ch = 65; 			// 문자형 65 = 유니코드 65 = 'A'
		
//		ch = '\u0041' ; 	// A // 유니코드의 문자를 이용하겠다.
//					   		// 유니코드는 16진수 형태로 사용됨 
//		
//		ch = '\uAC00' ; // 가 
		 
		System.out.println(ch);
		System.out.println((int)ch);			// 형변환
		
		
		int code = ch ;
		
		System.out.println(code);
		System.out.println("문자 : " + ch);
		
		System.out.println("" + 'A' + 'b');
		
		
	}
}
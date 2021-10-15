package kr.ac.kopo.day01;

/*
 * 상수 : 5가지
 * 1. 정수형 상수  
 * 2. 실수형 상수
 * 3. 문자형 상수 :  ' ' 으로 구분, 한글자일 경우 문자형이라고 인식 
 * 4. 문자열 상수 : " " 으로 구분 
 * 5. 논리형 상수 
 */

public class ConstMain {

	public static void main(String[] args) {
		
		 System.out.printf("%c%c\n", 'A', 'B'); 
	     System.out.println('A' + 10); // 65 + 10
		 System.out.println('A' + 'B'); 
		
		final boolean  BOOL = true; // final이라고 지정한 변수는 true 값만 가지게 되어있음 
									// 다른 값을 가지게 되면 error
									// 상수의 모든 문자를 대문자로 지정해줌
		System.out.println(BOOL); 
	}
}

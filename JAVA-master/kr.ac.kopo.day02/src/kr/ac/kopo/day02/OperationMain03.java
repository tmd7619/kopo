package kr.ac.kopo.day02;

// 자동 import : ctrl + shift + o 
import java.util.Scanner;

/*
 * 정수를 입력하세요 : 12
 * 12의 짝수유무 : true
 * 
 * 정수를 입력하세요 : 5
 * 5의 짝수유무 : false
 */

public class OperationMain03 {
	

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);     // System.in : 입력장치(키보드를 통해서)
		
		// "정수를 입력하세요 : " 문장을 출력
		System.out.print("정수를 입력하세요 : ");
		
		// 키보드로 정수를 입력
		int num = sc.nextInt();
		
		// 결과를 출력
		boolean result = (num > 0 && num % 2 == 0) ;  // ( ) 생략가능 why? 컴퓨터는 앞에 2개의 항부터 계산을 하기 때문에 순서에 상관이 없다.
													// 0 이하는 false
		System.out.println(num + "의짝수 유무 : " + result);
		
	}	

}

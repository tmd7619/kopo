package kr.ac.kopo.day02.exam;

import java.util.Scanner;

public class Work4 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 정수를 입력 :");
		int num = sc.nextInt();
		System.out.print("두번째 정수를 입력 :");
		int num2 = sc.nextInt();

		// if구문
		
		if (num2 == 0) {

			System.out.printf("%d가 %d의 배수인지 판단결과 : false\n", num, num2);
			
		} else if (num % num2 == 0 && num2 != 0){
			System.out.printf("%d가 %d의 배수인지 판단결과 : true\n", num, num2);
			System.out.printf("%d가 %d의 배수인지 판단결과 : 참\n", num, num2);
		} else {
			System.out.printf("%d가 %d의 배수인지 판단결과 : false\n", num, num2);

		}
		
		// 조건연산자
		
		System.out.println("정수 " + num + "이" + num2 + "의 배수 여부 판단 :" 
				+ (num2 > 0 && num % num2 == 0 ) ); 							// num > 0 : 0보다 크다는 조건이 먼저 나와야 적용됨.
		System.out.println("정수 " + num + "이" + num2 + "의 배수 여부 판단 :"  // 만약에  뒤로 보냈는데 오류가 안나면, 쓸필요가 없는 것
				+ (num2 > 0 && num % num2 == 0 ? "참" : "거짓" ) ); 

		
	}
}
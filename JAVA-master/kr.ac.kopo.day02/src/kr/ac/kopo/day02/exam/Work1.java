package kr.ac.kopo.day02.exam;

import java.util.Scanner;

public class Work1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 정수 :");
		int num = sc.nextInt();
		System.out.print("두번째 정수 :");
		int num2 = sc.nextInt();
		
		int result1 = num + num2;
		System.out.println(num+"와"+num2+ "의 합 : " + result1);
		
		int result2 = num - num2;
		System.out.println(num+"와"+num2+ "의 차 : " + result2);
		
		int result3 = num * num2;
		System.out.println(num+"와"+num2+ "의 곱 : " + result3);
		// 0일때  if 추가하기 
		int result4 = num / num2;
		System.out.printf("%d와%d의 나머지 : %.2f\n" ,num,num2,(double)result4);
		
		int result5 = num % num2;
		System.out.println(num+"와"+num2+ "의 몫 : " + result5);
				
	}

}
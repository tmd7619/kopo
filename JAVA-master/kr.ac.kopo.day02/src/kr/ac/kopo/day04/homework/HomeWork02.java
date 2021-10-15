package kr.ac.kopo.day04.homework;

import java.util.Scanner;

public class HomeWork02 {
/*
	2. 4개의 정수를 입력받아 가장 큰수를 출력
	   4개의 정수를 입력하세요 : 12 6 2 54
	   가장 큰수 54
*/	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 :");
		int num = sc.nextInt();
		System.out.print("두번째 정수 :");
		int num2 = sc.nextInt();
		System.out.print("세번째 정수 :");
		int num3 = sc.nextInt();
		System.out.print("네번째 정수 :");
		int num4 = sc.nextInt();
		
		if(num > num2 && num > num3 && num > num4) {
			System.out.println("가장 큰수 : "+num);
		}else if(num2 > num && num2 > num3 && num2 > num4) {
			System.out.println("가장 큰수 : "+num2);
		}else if(num3 > num && num3 > num2 && num3 > num4) {
			System.out.println("가장 큰수 : "+num3);
		}else {
			System.out.println("가장 큰수 : "+num4);
		}
		
	}

}

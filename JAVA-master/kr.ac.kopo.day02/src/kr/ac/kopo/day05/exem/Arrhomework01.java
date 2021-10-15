package kr.ac.kopo.day05.exem;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 1. 0-99 사이의 정수를 5개 입력받아 다음과 같이 출력하는 코드를 작성하시오
	1's 정수 : 36
	2's 정수 : 1000
	0~99사이의 정수만 입력하세요
	2's 정수 : 92
	3's 정수 : 20
	4's 정수 : 8
	5's 정수 : -2
	5's 정수 : 200
	5's 정수 : 62
	
	<PRINT> 
	36 92 20 8 62
	
	<REVERSE>
	26 80 2 29 63
 * 
 */
public class Arrhomework01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		int i = 0;
		while(i<arr.length) {
			System.out.println(i+1+"번째 정수 입력 : ");
			int num = sc.nextInt();
			
			if(num>=0 && num<100) {
				arr[i] = num;
				i++;
			}else {
				System.out.println("0 ~ 99 사이의 값만 입력 : ");
			}
		}
		
		System.out.println("<PRINT>");
		for(i=0;i<5;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		System.out.println("<REVERSE>");
		for(i=0;i<5;i++) {
			System.out.print(arr[4-i] + " ");
		}
		
	}
	
}

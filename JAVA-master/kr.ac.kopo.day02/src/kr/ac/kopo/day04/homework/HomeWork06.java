package kr.ac.kopo.day04.homework;
import java.util.Scanner;
/*
 * 
 6. 10개의 정수를 입력 받아 다음과 같이 출력하는 코드를 작성

	1's 정수 : 12
	2's 정수 : 3
	3's 정수 : 45
	4's 정수 : 7
	5's 정수 : 23
	6's 정수 : 56
	7's 정수 : 10
	8's 정수 : 8
	9's 정수 : 3
	10's 정수 : 55
	
	<짝수>
	12 56 10 8
	짝수의 총합 : xxxx
	<홀수>
	3 45 7 23 3 55
	홀수의 총합 : xxxx
 */

public class HomeWork06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int[]arr = new int[10];
		
		for(int i = 0 ; i < arr.length; i++) {
			System.out.println(i+1+"번째 정수를 입력 : ");
			int num = sc.nextInt();
			arr[i] = num;
			
		}
		int sum = 0;
		System.out.println("<짝수>");
		for(int i = 0; i < arr.length; i++ ) {
			if(arr[i] % 2 == 0) {
				System.out.print(arr[i] + " ");
				sum += arr[i];
			}
		}
		System.out.println("짝수의 총합 : "+sum);
		
		sum = 0;
		System.out.println("<홀수>");
		for(int i = 0; i < arr.length; i++ ) {
			if(arr[i] % 2 != 0) {
				System.out.print(arr[i] + " ");
				sum += arr[i];
			}
		}
		System.out.println("홀수의 총합 : "+sum);
 }
}

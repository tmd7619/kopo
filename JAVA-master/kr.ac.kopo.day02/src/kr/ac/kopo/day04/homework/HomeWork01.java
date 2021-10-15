package kr.ac.kopo.day04.homework;
import java.util.Scanner;
/*
 * 
 * 1.  3개의 정수를 입력받아 큰수에서 작은수순으로 출력
	3개의 정수를 입력하세요 : 12 7 39
	
	39 12 7
 */

public class HomeWork01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner sc = new Scanner(System.in);
		
		System.out.println("3개의 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		if(num1 > num2) {
			if(num1 > num3 ) {
				if(num2>num3) {
					System.out.printf("%d %d %d",num1,num2,num3);
				}else {
					System.out.printf("%d %d %d",num1,num3,num2);
				}
			} else {
				System.out.printf("%d %d %d",num3,num1,num2);
			}
		} else { // num2>num1
			if(num2>num3) {
				if(num1>num3) {
					System.out.printf("%d %d %d",num2,num1,num3);
				} else {
					System.out.printf("%d %d %d",num2,num3,num1);
				}
			} else {
				System.out.printf("%d %d %d",num3,num2,num1);
			}
		}
		
		
		

	}
}


package kr.ac.kopo.day07;

import java.util.Scanner;

/**
 * 구구단과 관련된 여러가지 기능을 가지는 기능 클래스
 * @author HP
 *
 */


public class Gugudan {
	
	Scanner sc = new Scanner(System.in); 	// 스캐너 멤버변수 생성
	
	void print(int dan) {
		
		System.out.println("*** " + dan + "단 ***");
		for(int i = 1; i <=9; i++) {
			System.out.println(dan + " * "+i+" = "+(dan*i));
		}
	}
	
//	void printAll() {
//		for(int dan = 2 ;dan<= 9 ; dan++) {
//			System.out.println("***"+dan+"단 ***");
//			for(int i = 1 ; i <= 9; i++) {
//				System.out.println(dan+" * "+i+" = "+ (dan*i));
//			}
//		}
//	}
//	void print() {						//메소드 오버라이딩 메개변수가 다르기 때문에 가능
//		
//	for(int dan = 2 ;dan<= 9 ; dan++) {
//		System.out.println("***"+dan+"단 ***");
//		for(int i = 1 ; i <= 9; i++) {
//			System.out.println(dan+" * "+i+" = "+ (dan*i));		
//		}
//	}
	
//	void print() {
//		for(int dan = 2; dan <= 9; dan++) {
//			this.print(dan);			// this. ~ : 자기참조객체, this. 생략가능  
//		}
//	}
	
	void print() {
		print(2, 9);
	}
	
	/**
	 * 시작단에서 종료단까지 구구단을 출력
	 * @param sDan	시작단
	 * @param eDan	종료단
	 */
	void print(int sDan, int eDan) {
		  for(int dan = sDan; dan <= eDan;dan++) {
			  print(dan);
		  }	
	}
	
	int getDan() {
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		sc.nextLine();
		return dan	;
	}
	int getDan(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
//		int dan = sc.nextInt();
//		sc.nextLine();
//		return dan	;
		
		int dan = getDan();
		return dan;
		
	}
	
	
}


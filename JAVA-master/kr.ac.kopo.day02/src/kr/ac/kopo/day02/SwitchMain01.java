package kr.ac.kopo.day02;

import java.util.Scanner;

/*
 * 1 - 3 사이 정수 입력 : 1
 * ONE
 * 
 * 1 - 3 사이 정수 입력 : 2
 * TWO
 * 
 * 1 - 3 사이 정수 입력 : 3
 * THREE
 * 
 * 1 - 3 사이 정수 입력 : 6
 * ERROR
 * 
 */

public class SwitchMain01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("1 - 3 사이의 정수 :");
		int num = sc.nextInt();

		switch (num) {
		case 1:
			System.out.println("ONE");
			System.out.println("1선택");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		default: // default는 순서의 상관없이 항상 마지막에 수행이 됨
			System.out.println("ERROR");
			break;
		}

//		if(num==1) {
//			System.out.println("ONE");
//		}else if (num==2){
//			System.out.println("TWO");
//		}else if (num==3){
//			System.out.println("THREE");
//		}else {
//			System.out.println("ERROR");
//		}

	}

}
package kr.ac.kopo.day07;

import java.util.Scanner;

public class KeyboardTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stu

		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 : ");
		int num = sc.nextInt();
		
		System.out.print("두번째 정수 : ");
		int num2= sc.nextInt();
		
		
		//  첫번째 입력때, 10 234 를 입력하면 두번째 정수 물음에 입력을 받지 않고 
		// 	버퍼에 있는 숫자를 가져옴 
		
		
		System.out.print("정수입력 : ");
		int num3 = sc.nextInt();			//  1. 정수형은 버퍼에 ln을 남기기 때문에,
		sc.nextLine();						// 3. nextLine은 엔터(ln)를 소비하기하기 때문에 버퍼를 제거함
		int num5 = Integer.parseInt(sc.nextLine()); // 문자열로 입력받아서, 정수형으로 변환하는 방법도 있음
		
		
		
		System.out.print("문자열을 입력 : ");	// 2. 문자열을 입력받을 수 없게 됨 
		String num4= sc.nextLine();
		

		
	}

}

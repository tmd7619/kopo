package kr.ac.kopo.day07.homework;

import java.util.Scanner;

public class Calculator {
	
	Scanner sc = new Scanner(System.in);
	int firstNum;
	int secondNum;
	
	void cal() {
		getCal();
		print();
		check();
	}
	
	void check() {
		boolean a = true;
		for(int i = 2 ; i < firstNum ; i++ ) {
			if(firstNum % i ==0) {
				a = false;
				break;
			}
		}
		for(int i = 2 ; i < secondNum ; i++ ) {
			if(secondNum % i ==0) {
				a = false;
				break;
			}
		}
		System.out.println(firstNum+ " 소수체크 : "+a);
		System.out.println(secondNum+ " 소수체크 : "+a);
	}

	void getCal() {					
		System.out.print("첫번째 정수 입력");
		this.firstNum = sc.nextInt();
		sc.nextLine();
		System.out.print("두번째 정수 입력");
		this.secondNum = sc.nextInt();
		sc.nextLine();
	}
	
	void print() {
		System.out.println(firstNum + " + " + secondNum + " = "+(firstNum+secondNum));
		System.out.println(firstNum + " - " + secondNum + " = "+(firstNum-secondNum));
		System.out.println(firstNum + " * " + secondNum + " = "+(firstNum*secondNum));
		System.out.println(firstNum + " + " + secondNum + " = "+(firstNum+secondNum));
		if(secondNum!=0)
			{System.out.println(firstNum + " / " + secondNum + " = "+(double)(firstNum/secondNum));
			}
	}
	

	
}

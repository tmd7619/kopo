package kr.ac.kopo.day07;

import java.util.Scanner;

public class GugudanMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Gugudan gu = new Gugudan();	// 인스턴스 객체 생성 -> 메소드 호출하여 참조변수 gu에 넣기
		
		System.out.print("2 - 9 사이의 단 입력 : ");
		int dan = sc.nextInt(); 
		sc.nextLine();				// 버퍼 비우기
		
		gu.print(dan);				// 입력 단 출력
		
//		gu.printAll();
		gu.print();					// 모든 단 출력
		
		System.out.print("시작단을 입력 : ");
		int startDan = sc.nextInt();
		sc.nextLine();
		
		System.out.println("종료단을 입력 : ");
		int endDan = sc.nextInt();
		sc.nextLine();
		
		gu.print(startDan,endDan);
		
	}

}

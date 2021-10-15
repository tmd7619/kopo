package kr.ac.kopo.day11.homework;

import java.util.Random;
import java.util.Scanner;

public class Shape {

	public static int getRandom() {				// 2 ~ 10 랜덤 값 불러오기
		Random r = new Random();				// static 메소드로 만들어, 각 클래스에 Shape 인스턴스 생성 없이 접근하게 해줌
		int ranNum = r.nextInt(10) + 1;		
		return ranNum;
	}
	
	
	public static void print() {
		Scanner sc = new Scanner(System.in);
		System.out.print("도형을 선택하세요(1.직사각형, 2.정사각형, 3.삼각형, 4.원 => ");
		int num = sc.nextInt();
		sc.nextLine();
		
		AbstractShape s = null;
		
		switch(num) {
		case 1:
			s = new Rectangle();		// 묵시적 형변환
			break;
		case 2:
			s = new Square();
			break;
		case 3:
			s = new Triangle();
			break;
		case 4:
			s = new Circle();
			break;
		}if(s != null) {
			s.printShape();
		} else {
			System.out.println("번호를 잘못선택 하셨습니다.");
		}

		}

}

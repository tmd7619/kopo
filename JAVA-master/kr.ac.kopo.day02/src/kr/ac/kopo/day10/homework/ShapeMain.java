package kr.ac.kopo.day10.homework;
/*
2. 다음의 결과를 보이는 프로그램을 작성

도형을 선택하세요(1. 직사각형, 2. 정사각형, 3.삼각형, 4.원) => 1
직사각형 선택시
   Random하게 2 ~ 10사이의 정수 2개를 추출
   가로 3, 세로 2의 직사각형 면적은 6입니다
   
도형을 선택하세요(1. 직사각형, 2. 정사각형, 3.삼각형, 4.원) => 2
정사각형 선택시
   Random하게 2 ~ 10사이의 정수 1개를 추출
   가로 5의 정사각형 면적은 25입니다

 * 
 * 
 */

import java.util.Scanner;

public class ShapeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("도형을 선택하세요(1.직사각형, 2.정사각형, 3.삼각형, 4.원 => ");
		int num = sc.nextInt();
		
		if(num == 1 ) {
			Rectangle r = new Rectangle();
			r.print(num);
		} else if(num == 2) {
			Square s = new Square();
			s.print(num);
		} else if(num == 3) {
			Triangle t = new Triangle();
			t.print(num);
		} else {
			Circle c = new Circle();
			c.print(num);
		}
		
		
	}

}

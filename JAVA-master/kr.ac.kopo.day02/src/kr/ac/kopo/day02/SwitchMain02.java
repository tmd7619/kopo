package kr.ac.kopo.day02;

import java.util.Scanner;

/*
 * 좋아하는 게절을 입력 : spring
 * 봄은 3월 ~ 5월까지입니다
 */


public class SwitchMain02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("좋아하는 게절을 입력 : ");
		String season = sc.nextLine();
		
		System.out.println(season);
		
		if(season.equals("spring")) {					// 객체 참조형은 동등비교가 안됨. == x
			System.out.println("봄은 3월에서 5월까지입니다.");
		}else if(season.equals("summer")) {
			System.out.println("여름은 6월에서 8월까지입니다.");
		}else {
			System.out.println("error");				// if 구문으로 만들기에는 복잡하기 때문에 switch 구문으로 만드는게 좋다.
		}
		
		switch(season) {
		case "spring" :					// 케이스 여러개 사용 가능
		case "SPRING" :
		case "봄" :
			System.out.println("봄은 3월에서 5월");
			break;
		case "summer" :
			System.out.println("여름은 6월 ~ 8월");
			break;
		default :
			System.out.println("Error");
			
		}
	

	}

}
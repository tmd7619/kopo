package kr.ac.kopo.day13.homework;

import java.util.Scanner;

public class DateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Date da = new SpecificDate();
		Loop1: while (true) {
			System.out.println("선택하세요(1. 특정년도 2. 특정월 3. 종료) = > ");
			int input = sc.nextInt();
			sc.nextLine();
			Loop2: while (true) {

				if (input == 1) { // 특정년도 선택시,
					System.out.print("년도를 입력하세요 : ");
					int year = sc.nextInt();
					sc.nextLine();
					da.printyear(year);
					break;

				} else if (input == 2) { // 특정월 선택시
					System.out.print("년도를 입력하세요 : ");
					int year = sc.nextInt();
					sc.nextLine();
					System.out.print("월을 입력하세요 : ");
					int month = sc.nextInt();
					sc.nextLine();
					da.printmonth(year, month);
					break;
				} else {
					System.out.println("종료되었습니다");
					break Loop1;
				}

			}

		}
	}

}

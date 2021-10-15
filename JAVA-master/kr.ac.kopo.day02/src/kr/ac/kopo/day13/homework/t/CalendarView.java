package kr.ac.kopo.day13.homework.t;

import java.util.Scanner;

public class CalendarView {

	private Scanner sc;

	public CalendarView() {
		sc = new Scanner(System.in); // 생성자에서 sc변수 만들기

	}

	public int getInt(String msg) {
		System.out.println(msg);
		int no = sc.nextInt();
		sc.nextLine();

		return no;
	}

	public void process() {

		CalendarUtil util = new CalendarUtil();	// while 문에 넣으면, 메모리 소모가 계속 되기 때문에 비효율적임
		
		/* loop */ while (true) {
			int command = getInt("항목을 선택하세요 (1. 특정연도 2. 특정월 3. 종료 ) : ");
			int year, month;
			switch (command) {
			case 1:
				System.out.println("1번선택");
				year = getInt("년도를 입력하세요 : ");
				util.showDayByYear(year);
				break;

			case 2:
				System.out.println("2번선택");
				year = getInt("년도를 입력하세요 : ");
				month = getInt("월을 입력하세요 : ");
				util.showDayByMonth(year,month);
				break;

			case 3:
				System.out.println("프로그램을 종료합니다");
				System.exit(0); // 시스템을 종료시키는 메소드 exit : System 클래스에 정의된 public static method
//				break loop;

			}
		}
	}

}

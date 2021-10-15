package kr.ac.kopo.day13.homework;

import java.util.Calendar;

public class SpecificDate implements Date {

	Calendar c = Calendar.getInstance(); // Calendar는 추상클래스로서, 객체를 얻기위해 Calendar.getInstance() 이용
	int lastday = c.getActualMaximum(Calendar.DATE); // 해당 월 마지막 날짜
	int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // 해당 날짜의 요일 // 1(일) ~ 7(토)

	@Override
	public void printyear(int year) {
		for(int i = 1 ; i <= 12 ; i ++) {
			c.set(year,i-1,1);			// month ++
			dayOfWeek = c.get(Calendar.DAY_OF_WEEK);	// 1로 다시 초기화 (dayOFWeek값이 계속 ++하기 때문)
			System.out.println("<< " + year + "년 " + i + "월 >>");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			for (int j = 1; j < dayOfWeek; j++) { 
				System.out.print("\t");
			}
			for(int j = 1 ; j <= lastday; j ++) {
				System.out.print(j+"\t");
				if(dayOfWeek % 7 == 0 ) {
					System.out.println();
				}
				dayOfWeek++;
			}
			System.out.println();
		}
		System.out.println();
	}
	

	@Override
	public void printmonth(int year, int month) {

		c.set(year, month - 1, 1); // set함수로 매개변수로 날짜 초기화 // month는 0~ 11까지로, 1을 넣으면 2월로 인식되기때문에 -1을 해줌
									// day는 1로 초기화
		System.out.println("<< " + year + "년 " + month + "월 >>");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i = 1; i < dayOfWeek; i++) { // 시작일이 매 달마다 다르기 때문에, dayOfWeek(1일이 시작되는 요일)까지 공백을 넣어줘야함
			System.out.print("\t");

		}
		for (int i = 1; i <= lastday; i++) {
			System.out.print(i + "\t"); // 첫일부터 끝일까지 탭 간격으로 출력하기
			if (dayOfWeek % 7 == 0) { // dayOfWeek는 1씩 계속 증가하기때문에,
				System.out.println();
			}
//			System.out.println("dayOfWeek : "+dayOfWeek); // debug
			dayOfWeek++; // (이미 c.get(Calendar.DAY_OF_WEEK)로 1값을 받았기 떄문에, 1,2,3,4,5 int값이 증가함)
		}

		System.out.println();
		System.out.println("-------------------------------------------------------");
	}

}

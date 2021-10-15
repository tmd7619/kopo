package kr.ac.kopo.day13.homework.t;

import java.util.Calendar;

public class CalendarUtil {
	
	private Calendar c ;
	
	CalendarUtil(){				//  Calendar 객체를 생성자로 만들어, 실행할때마다 객체생성을 하는 불필요함을 없애줌	
		c = Calendar.getInstance();
	}

	public void showDayByYear(int year) {
		for (int month = 1; month <= 12; month++) {
			showDayByMonth(year, month);
		}
	}

	public void showDayByMonth(int year, int month) {
		c.set(year, month-1, 1);;
		
		// month/1의 요일??
		int week = c.get(Calendar.DAY_OF_WEEK);
		// montt의 마지막 날수 ??
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		System.out.println("<< " + year + "년 " + month + "월 >>");
		showDay(week, lastDay);
		
	}
	
	private void showDay(int week, int lastDay) { // showDay는 View에서 호출될 일이 없고 내부에서만 실행되기 때문에, private으로 지정해줌
		
		System.out.println("--------------------------------------------------");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("--------------------------------------------------");
		int cnt = 0;
		for(int i = 1; i < week; i++) {
			System.out.print("\t");
			cnt++;
		}
		for(int day = 1; day <= lastDay; day++) {
			System.out.print(day + "\t");
			if(++cnt % 7 == 0)
				System.out.println();
		}
		if(cnt % 7 != 0)
			System.out.println();
		System.out.println("--------------------------------------------------");
	}
}

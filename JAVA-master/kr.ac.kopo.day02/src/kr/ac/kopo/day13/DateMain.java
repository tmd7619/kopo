package kr.ac.kopo.day13;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
abstract class Calendar{
	static Calendar getInstance() {
		return new GregorianCalendar();
	}
}
*/

public class DateMain {

	public static void main(String[] args) {
		
		// 오늘은 2021년 3월 24일입니다
		
		Calendar c = Calendar.getInstance();
		System.out.println("c : " + c);
		
		int year02 = c.get(Calendar.YEAR); 	// 매개변수를 숫자로 쓰면 헷갈리기때문에, 클래스.변수명으로 접근한다
		int month02 = c.get(Calendar.MONTH)+1; // 0 ~ 11
//		int date02 = c.get(Calendar.DATE);
		int date02 = c.get(Calendar.DAY_OF_MONTH);
		int day = c.get(Calendar.DAY_OF_WEEK);		// 일(1) ~ 토(7)
		
		String[] dayArr = {"","일","월","화","수","목","금","토"};
		
		System.out.println(year02+"년 "+month02+"월 "+date02+"일 "+  dayArr[day]+"요일");	
		System.out.println("-----------------------------");
		
		// 2021년 5월 5일 무슨요일??
		c.set(2021, 5-1, 5);		// month는 0~11 까지밖에 없기 때문에 5을 입력하면, 6월로 인식한다 따라서 -1을 해준다.
		day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("2021년 5월 5일은 "+dayArr[day]+"요일입니다");
		System.out.println("-----------------------------");
		// 5월의 마지막 날이 몇일 ????
		int lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("5월은 "+lastday+"일로 구성되어있습니다.");
		System.out.println("-----------------------------");
		// 2월의 마지막 날은 몇일?
		c.set(c.MONTH, 2-1); // 달을 2로 변경하겠다
		lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("2월은 "+lastday+"일로 구성되어있습니다.");
		System.out.println("-----------------------------");
		
		
		Date d02 = c.getTime();	// Cal => date형으로 변환(묵시적형변환)
		
//		String pattern = "yyyy-MM-dd HH:mm:ss(E)"; // HH: 24시간으로 표시
		String pattern = "yyyy년 MM월 dd일 hh시:mm분:ss초 (E)요일";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String data = sdf.format(new Date());	// format에는 date형만 가능하다 new Date() => 오늘날짜
		System.out.println(data);
		
		data = sdf.format(d02); // 2월 5일로 출력 => 위 코드에 월을 2로, 일을 5로 변경했기 때문
		System.out.println(data);
		
		
		/*
		객체명으로 출력을하면 자동으로 객체값과 해시코드를 찍게 되는데(.toString 형식으로) 
		Date()클래스는 . toString메소드(super:Object)가 자동으로 오버라이딩 되어있음
		객체값과 해시코드로 나오기 때문에, info메소드를 생성해야했지만, toString을 오버라이드 하면 객체명으로 출력만해도 정보를 알 수 있음
		*/
		Date d = new Date();
		System.out.println("d : "+d);		
		System.out.println("d : "+d.toString()); 	
		int year = d.getYear() +1900; // 이 메소드는 deprecated되어있다.
		int month = d.getMonth() +1;		// 0 ~ 11까지 의 값을 갖기 때문에 +1
		int date = d.getDate();
		System.out.println("오늘은 "+ year+"년 "+ month+"월 "+date+"일입니다" );
		

	}										

}

package kr.ac.kopo.day12;

import java.util.Random;

public class ExceptionMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("main start...");
		
		Random r = new Random();
		int num  = r.nextInt(3); // 0 ~ 2 사이의 난수 발생
		System.out.println("num : "+ num);
		
		String str = null;
		
		try {

			System.out.println(10/num); // 
			System.out.println("첫번째 문자 :" + str.charAt(0))	;
		} catch(Exception e) {			// 묵시적형변환에 의해 어떤 예외가 발생해도 예외처리가 가능함 모든 예외사항은 Exception을 상속받음
			e.printStackTrace();	// 예외가 발생해도 프로그램을 계속 실행하게 만들어줌
		}
		System.out.println("main end...");	
		/*
		try {

			System.out.println(10/num); // 여기서 예외가 발생하면, 첫번째 catch로, 발생안하면 밑에줄 실행으로 두번째 catch
			System.out.println("첫번째 문자 :" + str.charAt(0))	;
		} catch(ArithmeticException ae) {	// ae: 17줄에 발생한 예외를 ae변수가 알고있음	
//		} catch(NullPointExcetion ae) {		// 다른예외는 잡을 수 없음
//			System.out.println("이유 : "ae.getMessage()); // 예외 메세지 내용 출력
			ae.printStackTrace();  	        // 예외가 발생해도 프로그램을 계속 실행하게 만들어줌
		} catch(NullPointerException ne) {	// 멀티 catch 
			System.out.println("NullPointerExcepiton 진입....");
		}
		
		System.out.println("main end...");	
		
		*/
	}

}


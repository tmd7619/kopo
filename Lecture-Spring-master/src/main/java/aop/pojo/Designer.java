package aop.pojo;

public class Designer implements Employee {

	public void work() {
		
		// 보완 1 -> 공통의 코드들을 Action클래스로 분리시킴
		Action.gotoOffice();
		
//		System.out.println("출근한다"); // 공통의 코드 // 
		System.out.println("제품 디자인을 한다"); // 핵심코드 // 
//		System.out.println("퇴근 한다"); // 공통의 코드 // 
		
		Action.getoffOffice();
		
		
		
	}

}

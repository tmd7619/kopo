package aop.pojo;

public class Action { // 공통의 코드를 가지고 있는 클래스
	
	public static void gotoOffice() {
		
		System.out.println("출근을 합니다");
		
	}

	
	public static void getoffOffice() {
		
		System.out.println("퇴근을 합니다.");
	}
}

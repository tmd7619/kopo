package aop.xml;

public class MyAspect { // 공통의 코드를 가지고 있는 클래스 

	
	public void gotoOffice() {
		
		System.out.println("출근을 합니다.");
	}
	
	public void getoffOffice() {
		
		System.out.println("퇴근을 합니다.");
	}
}

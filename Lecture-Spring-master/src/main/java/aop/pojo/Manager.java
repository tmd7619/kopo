package aop.pojo;

public class Manager  implements Employee{

	public void work() {
		Action.gotoOffice(); // 단점 -> 개발자가 직접 공통의 코드를 실행하는 메서드를 넣어줘야 하는 번거로움
		System.out.println("팀원들과 회의를 합니다.");
		
	}

	
}

package aop.anno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect { // 공통의 코드를 가지고 있는 클래스 

	@Before("execution(void aop.*.*.work())")
	//@Before("execution(void aop.anno.*.work())")
	public void gotoOffice() {
		
		System.out.println("출근을 합니다.");
	}
	
	@After("execution(void aop.anno.*.work())")
	public void getoffOffice() {
		
		System.out.println("퇴근을 합니다.");
	}
}

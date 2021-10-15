package aop.java;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service // @Component가 아니라 @Service로 객체를 생성함
@Aspect
public class MyAspect { // 공통의 코드를 가지고 있는 클래스 

	@Before("execution(void aop.*.*.work())") // 리턴타입은 void, aop.* 모든 패키지 내의 모든 클래스.work()에 적용 
	//@Before("execution(void aop.anno.*.work())")
	public void gotoOffice(JoinPoint joinPoint) {
		
		System.out.println("출근을 합니다.");
	}
	
	@After("execution(void aop.java.*.work())")
	public void getoffOffice() {
		
		System.out.println("퇴근을 합니다.");
	}
}

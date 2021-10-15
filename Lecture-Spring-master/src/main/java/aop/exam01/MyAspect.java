package aop.exam01;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAspect {

	@AfterReturning("execution(* aop.*.*.setAge(..))") // error 없이 정상적으로 동작하는 aspect // try구문이라 생각
	public void checkAdult(JoinPoint joinPoint) {
		
		System.out.println("checkAdult 메서드 실행 ..");
		//System.out.println(Arrays.toString(joinPoint.getArgs()));
		
		Object[] args = joinPoint.getArgs(); // setAge()의 매개변수를 받아옴
		int age = Integer.parseInt(args[0].toString()); // Object to int 형변환
		if(age < 20) {
			System.out.println("미성년입니다");
			
		} else {
			System.out.println("성년입니다.");
		}
		
		/* 방법 2 블로그 방법
		for(Object tmp: args) {
			if(tmp instanceof Integer) {
				int age = (Integer)tmp;
				if(age < 20) {
					System.out.println("미성년입니다");
					
				} else {
					System.out.println("성년입니다.");
				}
			}
		}
		*/
		
	}
	
//	@Around("execution(* aop.exam01.*.setAge(..))")
	public void checkAdult2(ProceedingJoinPoint joinPoint ) throws Throwable {
		
		System.out.println("checkAdult2....");
		System.out.println(Arrays.toString(joinPoint.getArgs()));
		
		// proceed를 기준으로 위에는 before
		joinPoint.proceed() ; // 실제 setAge 메소드가 실행이 됨 // proceed를 언제 실행하느냐에 따라 4가지의 시점을 선택할 수 있다.
	}
	
	// error 시, 실행하는 aspect // catch문이라고 생각하기
	@AfterThrowing(pointcut="execution(* aop.exam01.*.setAge(..))", throwing="ex") // name=value 형태
	public void error(JoinPoint joinPoint, Throwable ex) {
		
		System.out.println("예외처리 : "  + ex.toString());
	}
}

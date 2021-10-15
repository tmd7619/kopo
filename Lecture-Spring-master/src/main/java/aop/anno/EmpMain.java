package aop.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 
 spring aop 특징
 1. Runtime 기반
 2. Proxy 기반
 3. 인터페이스 기반 -> 변수를 받을 때, 반드시 인터페이스 type으로 받아야함
 
 
 */




public class EmpMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("aop-anno.xml");
		
		Employee e = context.getBean("programmer" , Employee.class); // aop 공통 코드 주입
		e.work();
		
		Employee e2 = context.getBean("designer" , Employee.class);  // aop 공통 코드 주입
		//e2.work();
		
		
		
		aop.xml.Employee e3 = context.getBean("programmer2" , aop.xml.Employee.class);
		e3.work();
		
	}
}

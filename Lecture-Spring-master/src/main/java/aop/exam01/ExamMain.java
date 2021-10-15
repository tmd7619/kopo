package aop.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ExamMain {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		
		Person p = context.getBean("man", Person.class);
		
		try {
			p.setAge(20);
			p.setAge(-14);
		}catch(Exception e ) {
		}
		
	}
}

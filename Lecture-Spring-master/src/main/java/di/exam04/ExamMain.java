package di.exam04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ExamMain {
	
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		MyCalculator myCal = context.getBean("myCalculator" , MyCalculator.class);
		
		
		myCal.add(); // firstNum = 10 , secondNum = 20
		myCal.minus();
		myCal.multiply();
		myCal.devide();
		
	}

}

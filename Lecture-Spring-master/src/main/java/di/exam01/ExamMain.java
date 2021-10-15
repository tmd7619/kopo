package di.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ExamMain {

	public static void main(String[] args) {
		
		
		
		ApplicationContext context = new GenericXmlApplicationContext("di-exam01.xml");
		
		MyCalculator myCal = context.getBean("myCal" , MyCalculator.class);
		
		
		/* 1. 생성자 주입
		myCal.add(5, 5);
		myCal.minus(5, 5);
		myCal.multiply(5, 5);
		myCal.devide(5, 5);
		*/
		
		myCal.add(); // firstNum = 10 , secondNum = 20
		myCal.minus();
		myCal.multiply();
		myCal.devide();
		
		
		
		
		
	}
}

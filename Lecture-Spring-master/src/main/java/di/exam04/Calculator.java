package di.exam04;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	
	public Calculator() {
		
		System.out.println("Calculator().....");
	}
	
	
	public void add(int firstNum , int secondNum) {
		
		System.out.println("add ..." +  (firstNum + secondNum));
	}
	
	public void minus(int firstNum , int secondNum) {
		
		System.out.println("minus..." + (firstNum - secondNum));
	}
	
	public void multiply(int firstNum , int secondNum) {
		
		System.out.println("multiply..." + (firstNum * secondNum));
	}
	
	public void devide(int firstNum , int secondNum) {
		
		System.out.println("devide...." + (firstNum / secondNum));
	}


}

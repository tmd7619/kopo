package di.basic;

import di.xml02.HankookTire;
import di.xml02.KumhoTire;

public class DriverMain {
	
	public static void main(String[] args) {
		
		
		HankookTire han = new HankookTire(); // 외부에서 tire 객체 생성 
		KumhoTire kum = new KumhoTire();
		
		
		
		// setter 주입방식
		Car car = new Car();
		car.setTire(han); 
		
		
		
		/*
		// 생성자 주입방식
		Car car = new Car(han); // 생성자 주입 -> 의존성을 가진 객체를 생성자 패턴을 통해 받아옴
		car.prnTireBrand();
		*/
		
		
		/*
		Car car = new Car();
		car.prnTireBrand();
		*/
	}

}

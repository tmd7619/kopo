package di.basic;

import di.xml02.Tire;

public class Car {

	// 의존관계 설정
	private Tire tire;
	
	
	// DI(의존주입) : 1. 생성자 주입
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public Car() { // 타이어객체를 주입 x  -> setter 주입으로 객체를 주입한다.
		
	}
	
	// DI(의존주입) : 2. settter 주입
	public void setTire(Tire tire) {
		
		this.tire = tire;
		System.out.println( " set tire....");
	}
	
	
	
	/*
	public Car() {
		
		tire = new HankookTire();
	}
	*/
	
	
	
	public void prnTireBrand()	{
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}

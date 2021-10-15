package di.anno02.resource;

import javax.annotation.Resource;

public class Car {


	private Tire tire;
	
	public Car() {  // 기본생성자 // setter 주입 시 반드시 필요 
		
		System.out.println("Car().....");
		
	}
	
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire).......");
	}
	
	@Resource
	public void setTire(Tire tire) {
		
		this.tire = tire;
		System.out.println( " set tire....");
	}
	
	
	
	public void prnTireBrand()	{
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}

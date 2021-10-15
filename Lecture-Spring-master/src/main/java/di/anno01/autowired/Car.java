package di.anno01.autowired;

import org.springframework.beans.factory.annotation.Autowired;


public class Car {

	@Autowired // 멤버변수에 자동주입을 해줌으로써, 더 편리하게 사용이 가능하다.
	private Tire tire;
	
	public Car() {  // 기본생성자 // setter 주입 시 반드시 필요 
		
		System.out.println("Car().....");
		
	}
	
//	@Autowired // 자등으로 Tire형의 객체가 주입된다. // 어떻게? xml파일에 있는 Tire형의 객체를 알아서 찾아서 주입 // di.anno01.xml에는 Tire형의 한국타이어가 있음
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire).......");
	}
	
//	@Autowired // 기본 생성자를 호출하고 set 주입이 이루어지기 때문에, 기본생성자가 없으면 error
	public void setTire(Tire tire) {
		
		this.tire = tire;
		System.out.println( " set tire....");
	}
	
	
	
	public void prnTireBrand()	{
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}

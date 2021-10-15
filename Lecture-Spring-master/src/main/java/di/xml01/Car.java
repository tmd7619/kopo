package di.xml01;


public class Car {
	
	
	private Tire tire;
	private Tire frontL;
	private Tire frontR;
	private Tire backL;
	private Tire backR;
	
	
	// setter 주입
	public void setTire(Tire tire) {
		
		this.tire = tire;
		System.out.println("setTire(tire) 호출.....");
	}
	
	
	public void prnTireBrand() {
		
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}


	public void setFrontL(Tire frontL) {
		this.frontL = frontL;
		System.out.println("setFrontL 호출....");
	}


	public void setFrontR(Tire frontR) {
		this.frontR = frontR;
	}


	public void setBackL(Tire backL) {
		this.backL = backL;
	}


	public void setBackR(Tire backR) {
		this.backR = backR;
	}
	
	

}

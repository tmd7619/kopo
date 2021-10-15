package di.exam01;

public class MyCalculator {
	
	private int firstNum;
	private int secondNum;
	
	Calculator cal;
	
	
	public MyCalculator() {
		
		System.out.println("MyCalculator().....");
	}
	
	/*
	public MyCalculator(Calculator cal) { //  1. 생성자 주입
		 
		this.cal = cal;
	}
	 */
	
	public void setCal(Calculator cal) { // 2. setter 주입
		
		this.cal = cal;
		
	}
	
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
		
	}
	
	public void setSecondNum(int secondNum) {
		
		this.secondNum = secondNum;
	}
	
	
	
	// setter 주입시 사용하는 메서드  // property의 value로 firstNum과 secondNum 값을 지정해주었음
	public void add() {
	
		
		cal.add(this.firstNum, this.secondNum);
		
	}
	
	public void minus() {

		
		cal.minus(this.firstNum, this.secondNum);
		
	}
	
	public void multiply() {

		
		cal.multiply(this.firstNum, this.secondNum);
	}
	
	public void devide() {
		
		cal.devide(this.firstNum, this.secondNum);
		
	}
	
	
	
	/* 1. 생성자 주입 시 사용하는 메서드
	public void add(int firstNum , int secondNum) {
	
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		
		cal.add(this.firstNum, this.secondNum);
		
	}
	
	public void minus(int firstNum , int secondNum) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		
		cal.minus(this.firstNum, this.secondNum);
		
	}
	
	public void multiply(int firstNum , int secondNum) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		
		cal.multiply(this.firstNum, this.secondNum);
	}
	
	public void devide(int firstNum , int secondNum) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		
		cal.devide(this.firstNum, this.secondNum);
		
	}
	
	*/
	
	
	
	
	

}

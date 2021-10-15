package kr.ac.kopo.day08;

/*
 *  Car.java를 만들지 않고 여기다 클래스를 정의해도 가능함.
 *  하지만 같은 패키지 안에 동일한 클래스명이 있으면 안되므로, 변경시켜야함
 */
public class ConstructorMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		Car c = new Car();			// 생성자를 이용하면 인스턴스 생성과 동시에 제어할 수 있음
									// 생성자는 반드시 new 를 통해서 접근
		
		Car c2 = new Car("소나타");
		
		Car c3 = new Car(5,"모닝");
		
		c.Car();					
	}

}

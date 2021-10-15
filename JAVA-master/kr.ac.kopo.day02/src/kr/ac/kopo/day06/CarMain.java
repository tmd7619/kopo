package kr.ac.kopo.day06;

// 실행클래스 

// 자동초기화 int는 0, String은 NULL;

public class CarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car c  = new Car();			// c와 c2는 참조변수일뿐, 객체를 가지고 있는것이 아닌 가리키는 것
		
		c.name = "소나타";
		c.price = 3200;
		c.company = "현대";
		
		Car c2 = new Car();
		c2.name = "K5";
		c2.price = 3000;
		c2.company = "기아";
		
//		c = c2;  : c의 참조변수가 c2되기 때문에, shallow copy가 이루어짐.
		
		System.out.println("모델명 : " + c.name+ " 가격 : " + c.price + " 제조사 : " + c.company);
		System.out.println("모델명 : " + c2.name+ " 가격 : " + c2.price + " 제조사 : " + c2.company);
		
	}

}

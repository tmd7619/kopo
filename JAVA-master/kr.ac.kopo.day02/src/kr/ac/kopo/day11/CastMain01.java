package kr.ac.kopo.day11;

public class CastMain01 {
	
	/*
	public static void print(Child01 c) {	// main이 static이라, static 함수로 만듬
		c.info();					
	}

	public static void print(Child02 c) {	
		c.info();					
	}
	*/
	
	public static void print(Parent p) {  // 	Parent p = c01 or c02 or p 묵시적형변환 발생 (매개변수를 활용한 변환)
		p.info();						  //  묵시적 변환이 된 자식클래스의 info()가 실행된다. Parent p = p 일경우, 그대로 Parent.info()
										  // 이렇듯, Parent p가 c01인지 c02인지 뭐가 묵시적 형변환 됐는지 모르기 때문에, 판별을 해주어야함.
		if(p instanceof Child01) {			// 따라서 instanceof로 Parent p가 가르키고 있는 클래스를 판별한다.
			Child01 c = (Child01)p;			// 자식클래스부터 판별해야함 (부모클래스부터 판별하게 되면, 모두 true값이 나오기 때문)
			c.sleep();
			c.study();
		} else if (p instanceof Child02) {
			Child02 c = (Child02)p;
			c.sing();
			c.play();
		}
		
		/*
		System.out.println("p instanceof Child01 : "+ (p instanceof Child01));		  // instanceof는 좌변 우변이 상속관계거나, 같은 타입일때만 사용 가능
		System.out.println("p instanceof Child02 : "+ (p instanceof Child02));		  
		System.out.println("p instanceof Parent : "+ (p instanceof Parent));		  								  
		*/
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Child01 c01 = new Child01();	// 묵시적형변환에 의해 override 함수 실행
		print(c01);						// 매개변수를 c01(Child01)을 받았지만, Parent p가 받게 됨(묵시적 형변환 발생으로)
//		
//		Child02 c02 = new Child02();	// 묵시적형변환에 의해 override 함수 실행
//		print(c02);						// 실제 가르키고 있는 객체는 Child01이기 때문에 false
//		
//		Parent p = new Parent();
//		print(p);
//		
		
		/*
		Parent p = new Child01(); 	// 묵시적형변환 
		System.out.println(p.name+", "+p.age);   	// 형변환이된 부모클래스의 사용할 수 있는 범위는 자신의 메소드와 변수만!
													// 따라서 p.name이 "자식01"이 아닌 "부모"이며, p.age = 50이 된다.
		p.info();					// info()가 Override 되었기 때문에, Parent의 info()가 아닌 child01의 info()가 실행된다.
		*/
		
			
		/*
		Child01 c01 = new Child01();
		System.out.println(c01.name + "," + c01.age);
		c01.info();
		
		Parent p = new Parent();
		System.out.println(p.name + ", " + p.age);
		p.info();
		*/
	}
}

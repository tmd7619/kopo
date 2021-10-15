package kr.ac.kopo.day11;

public class CastMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Child01 c = new Parent();	// 컴파일 시점의 에러 발생 => 대입 연산자를 기준으로 좌변과 우변의 타입이 서로 다른데, 
									// Child01의 범위가 더 넓기 때문에, 메모리 부족으로 에러가 발생함

//		Child01 c = (Child01) new Parent(); // 컴파일 시점에서 에러 발생x 하지만, 실행시 예외 발생(메모리가 안잡힌곳에 참조를 하려고 하기 때문)
//											// 따라서 묵시적 변환이 먼저 이루어져야함
		
		Parent p = new Child02();		// 묵시적 형변환
		p.info();
		
		Child02 c = (Child02)p;			// 명시적 형변환
		c.info();
		c.sing();
		c.play();
	}
}
package kr.ac.kopo.day12;

import java.util.Random;

/*final*/ class Super{		
	
	private /* final */ int MAX = 100;
	
	public /* final */ void info() {
		System.out.println("Super클래스에서 정의된 메소드....");
		MAX = 50;				// final 로인해 변경 x
	}
}

class Sub extends Super{			// Super에 final 정의로 인해 상속을 할 수 없다.
	
	@Override
	public void info() {		// final 정의로 인해 오버라이드를 할 수 없단
		System.out.println("Sub클래스에서 재정의된 메소드...");
	}
}

class MyRandom extends Random{			//  Rabdom 클래스는 String과 달리 일반 클래스이기 때문에, 상속 가능
	
	/**
	 * bound가 10일때 1~ 10사이의 난수 추출
	 * @param bound 추출정수 범위
	 * @return 1 ~ bound 사이의 난수
	 */
	@Override
	public int nextInt(int bound) {
		// TODO Auto-generated method stub
		return super.nextInt(bound)+1;
	}
	
}

/*
class MyString extends String{		// error : String클래스는 final 클래스이기 때문에, 상속을 받을 수 없다
	
}
*/

public class FinalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1 ~ 100 사이의 난수를 발생시켜 출력하는 코드를 작성
		 * 
		 */
		Random r = new MyRandom();
		int random = r.nextInt(100);
		System.out.println("추출된 정수 : "+random);
	}

}

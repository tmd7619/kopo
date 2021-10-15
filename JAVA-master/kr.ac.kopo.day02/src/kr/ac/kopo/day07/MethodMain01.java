package kr.ac.kopo.day07;

/*
 * 
 *  *********
 *  hello
 *  *********
 * 	hi
 *  *********
 *  
 */


public class MethodMain01 {
	
	/**
	 * 임의의 문자를 반복하여 출력하는 기능
	 * @param c				// 출력할 문자   // 파라미터 c에 대한 설명을 하겠다
	 * @param cnt			// 출력횟수
	 */
		
	static void printStar(char c , int cnt) {		// printStar라는 메소드 정의 int cnt: 매개변수
		for(int i = 0; i < cnt ; i++) {
			System.out.print("*");
		}
		System.out.println();
		
//		return 20 ; //  피호출자가 main 에게 20을 보낸다. //  return을 하려면 void를 제거하고 리턴 타입에 맞춰야함
	}				//  return 값은 main에서 대입연산자 '=' 등으로 받아온다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printStar('*',10);								   // 메소드 호출
		System.out.println("hello");
		printStar('!',20);
		System.out.println("hi");
		printStar('@',30);
		
//		int data = printStar('*', 10);    				  // return 값 가져오기
//		System.out.println(data);						  // *을 10개 나타내고, return 값 20을 출력하는 것을 알 수 있다.
		
		
		
		
		
	}

}

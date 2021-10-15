package kr.ac.kopo.day02;


/*
 *
 자료형 크기 비교
 byte < short < int < long < float < double 
 char < int < long < float < double
 */

public class CastMain {
	
	public static void main(String[] args) {
		
		System.out.println(10 + 20);   
									   // 묵시적 형변환	
									   // 범위가 넒은 데이터 형에 좁은 데이터 형을 대입하늑넛 
		System.out.println('A' + 20);  // 서로 type이 다르기 때문에 type을 통일해야 하는데,
									   // 그냥 실행할 경우, 더 큰 타입으로 따라가게 되어있음.
									   // int가 char보다 크기 때문에 결괏값은 65+20 = 85
		
		System.out.println(12.3 + /* (double) */45);
		System.out.println((int)12.3 + 45);  // 명시적 형변환
											// 범위가 좁은 데이터 형에 넒은 데이터 형을 대입하는 것

		
		double num = (double)12;
//		int num = 12.34 ;  error : int < double이기 때문에 명시적 형변환을 해주어야함.
		int num2 = (int)12.34 ;

		
		System.out.println(" \"이스케이프문자테스트\" ");
		
		System.out.println(" \\이스케이프문자테스트\\ ");
		
		
		
	}
	
}
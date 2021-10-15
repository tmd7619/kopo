package kr.ac.kopo.day03;

/*
 * break는 가장 가까운 연산에서 빠져나온다.  <> return는 현재 사용하고 있는 method에서 빠져나온다. 
 * 
 * 	
 * 	Hello World
 * 	Hello World
 * 	Hello World
 * 	Hello World
 * 	Hello World
 * 
 * 	반복을 위한 기본요소
 * 	1. 반복할 문장
 * 	2. 시작값 ( 초기값은 대부분 0으로 시작함)
 * 	3. 증가/감소
 * 	4. 종료조건
 */

public class LoopMain01 {

	public static void main(String[] args) {
		
		System.out.println("-----------------------------");
		
		
		// while 문
		int cnt = 1;
		while(cnt <= 3){
			System.out.println("Hello World");
			++cnt;
		}
		System.out.println("-----------------------------");
		
		// for 문
		for(int cnt2 = 1; cnt2 <=3 ; ++cnt2) {
			System.out.println("Hello World");
		}
		
		System.out.println("-----------------------------");
		
		
//		for(int cnt3 = 3; cnt3 >=1; --cnt3)
//		for(int cnt3 = 3; cnt3 <= 5; ++cnt3)
		for(int cnt3 = 0; cnt3 <= 2; ++cnt3) {
			
			System.out.println("Hello World");
		}
		
		
	}
}

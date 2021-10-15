package kr.ac.kopo.day07;

/*
 * 	메소드 오버로딩(Overloading) :
 * 	같은 클래스내에 동명의 메소드이면서 
 * 	매개변수의 개수 또는 타입이 다른 것
 */

public class Method {
	
	void call() {
		System.out.println("call() 메소드 호출....");
	}
	
	void call(int i ) {		// 메소드 오버로딩 (매개변수 추가)
		System.out.println("call(int) 메소드 호출...");
//	int  call(int i ) {		// 메소드 오버로딩 (매개변수 추가)		// error // 리턴타입(void)으로는 구분하지 못함
//		System.out.println("call(int) 메소드 호출...");	
		
	}
	void call(double d ) {		// 메소드 오버로딩 (매개변수 추가)
		System.out.println("call(double) 메소드 호출...");	
	}	
	void call(String s ) {		// 참조형 변수도 오버로딩 가능
		System.out.println("call(Sting) 메소드 호출...");	
	}	
//	void call(char c ) {		// 참조형 변수도 오버로딩 가능
//		System.out.println("call(char) 메소드 호출...");				
//	}
	
	void call(String s, boolean b) {
		System.out.println("call(String, boolean) 메소드 호출");	
	}
	void call( boolean b, String s) {	// 매개변수 순서가 다르면 다르게 인식함
		System.out.println("call(String, boolean) 메소드 호출");	
	}
}

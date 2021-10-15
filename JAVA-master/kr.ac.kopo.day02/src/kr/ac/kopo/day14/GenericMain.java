package kr.ac.kopo.day14;

import java.util.Random;


class B <T>{
	private T obj;
	
	public B(T obj) {
		this.obj = obj;
	}
	
	public void setObject(T obj) {
		this.obj = obj;
	}
	
	public T getObj() {
		return this.obj;
	}
	
	public void info() {
		System.out.println("obj : "+obj);
	}
	
	
}
/*
class A {
	private Object obj;
	
	public A(Object obj) {
		this.obj = obj;
	}
	
	public void setObject(Object obj) {
		this.obj = obj;
	}
	
	public Object getObj() {
		return this.obj;
	}
	
	public void info() {
		System.out.println("obj : "+obj);
	}
}
*/



public class GenericMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		B<String> b01 = new B<String>(new String("Hello"));
		B<Random> b02 = new B<Random>(new Random());
//		B<int> b03 = new B<int>(3); 		// error => 제네릭은 참조자료형만 올 수 있다.
		
		b01.info();
		b02.info();
		
		System.out.println("길이 : "+b01.getObj().length());
		System.out.println("난수 : "+b02.getObj().nextInt());

//		b01 = new B<Random>(new Random()); error => b01은 오직 String 타입만 가질 수 있기 때문에 (묵시적형변환처럼 타입을 변경할 수 없다)
		
/*
		A a01 = new A(new String("Hello")); // 묵시적 형변환
		A a02 = new A(new Random());
		
		a01.info();
		a02.info();
		
//		System.out.println("길이 : "+ a01.getObj().length); // error => a01.getObj()의 type이 object형이라 .length사용 x
		System.out.println("길이 : "+ ((String)a01.getObj()).length()); // a01.getObj()를 String 형으로 변환해야함(명시적 형변환)
		System.out.println("난수 : "+ ((Random)a02.getObj()).nextInt()); // 이렇게 일일히 명시적 형변환을 해야되는 번거로움이 발생 => 제네릭의 필요성
		
		A[] arr = new A[2];
*/
	}

}

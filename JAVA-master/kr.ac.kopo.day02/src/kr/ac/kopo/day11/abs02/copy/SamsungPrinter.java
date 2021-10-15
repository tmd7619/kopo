package kr.ac.kopo.day11.abs02.copy;

public class SamsungPrinter extends Printer {

//	public void samPrint() {
//		System.out.println("삼성프린트에서 출력중..");
//	}
//	
	@Override // 추상클래스를 상속받으면, 추상메소드를 반드시 override 해야함 
	public void print() {
		System.out.println("삼성프린트에서 출력중..");
	}
}

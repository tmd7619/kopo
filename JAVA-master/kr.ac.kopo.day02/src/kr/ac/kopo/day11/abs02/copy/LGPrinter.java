package kr.ac.kopo.day11.abs02.copy;

public class LGPrinter extends Printer {	
	
	
//	public void lgPrint() {
//		System.out.println("LG프린터에서 출력중.....");
//	}
	
	@Override  // 추상클래스를 상속받으면, 추상메소드를 반드시 override 해야함 
	public void print() {
		System.out.println("LG프린터에서 출력중.....");
	}
}

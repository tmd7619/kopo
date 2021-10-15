package kr.ac.kopo.day17;


class AAA extends Thread {// AAA를 Thread 클래스로 인식

	@Override
	public void run() {
		while(true){
		System.out.println("go!!!!!!!");
		}
	} 
	
}

class BBB extends Thread {

	@Override
	public void run() {
		while(true) {
			System.out.println("\t\tstop!!!!!!");
		}
	}
}

public class ThreadMain01 {
	
	public static void main(String[] args) {
		
		AAA ta = new AAA()	;
		BBB tb = new BBB()  ; 
		
		ta.start(); // 실제로 컴퓨터는 하나의 작업만 수행하기 때문에, 빠른 시간내에 여러 작업을 번갈아 수행해야 한다.
					// 따라서 run을 실행하면 sysout("go")이 계속 실행되기에, start 메서드를 사용한다 .
		tb.start();
	
	}
}

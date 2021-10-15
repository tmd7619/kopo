package kr.ac.kopo.day17;

/*
 * 
 * Thread 구성 방식 2가지
 * 1. Thread 클래스를 상속해서 구현 
 * 2. Runnable 인터페이스를 상속해서 구현
 * 
 */

class ExtendThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 100; i++) {
			System.out.println(i + 1 + "번째 인형 눈 붙이기 ...");

		}
	}
}

class ImplementThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + 1 + "번째 인형 코 만들기 ...");

		}
	}
}

public class ThreadMain02 {

	public static void main(String[] args) {

		ExtendThread et = new ExtendThread();
		ImplementThread it = new ImplementThread();
		Thread t = new Thread(it);

		System.out.println("감독을 시작합니다.");

		et.start();
		t.start();
		
		try {
			et.join(100); // join에 인자를 넣게 되면, 인자 시간 만큼 시간이 경과하면 자동으로 블럭에서 빠져나간다
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			 t.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("감독을 종료합니다. "); // et와 t 쓰레드가 완전히 종료 되야지, 블럭에서 빠져나와 수행

		System.out.println(Thread.activeCount()); // 현재 실행되고 있는 Thread 개수 알려줌 // 3개 (Main쓰레드 + et + t)

	}
}

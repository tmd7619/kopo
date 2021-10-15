package kr.ac.kopo.day17;

import java.util.Date;

class TimeThread extends Thread {

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(1000);
			}catch(Exception e ) {
				e.printStackTrace();
			}
			
			System.out.println("현재시간 : " + new Date().toLocaleString());
		}
	}

}

public class SleepMain {

	public static void main(String[] args) {
		
		// 1초마다 go를 찍고싶을때
		TimeThread tt = new TimeThread();
		tt.start();
		
		while(true) {
			System.out.println("go!!!!!!!");
			try {
				Thread.sleep(100);
			}catch(Exception e ) {
				e.printStackTrace();
			}
			
			}

		
//		
//		System.out.println("Thread가 2초동안 잠이 들겠습니다");
//				
//		try {
//		Thread.sleep(2000); 
//		}catch(Exception e ) {
//			e.printStackTrace();
//		}
//		System.out.println("Thread가 깨어났습니다");
	
	}
}

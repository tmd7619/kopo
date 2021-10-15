package kr.ac.kopo.day17.homework;

import java.util.Random;

/*
	 2. 홍수로 인해 이재민이 발생되었습니다
	방송국에서 이재민을 위한 성금을 모집합니다
	방송중 콜센터 1 ~ 4번까지 전화를 걸어 성금을 해주시길 바랍니다
	방송이 종료되면 모금된 성금 총액을 알려드리겠습니다
	
	제약조건>
	1 ~ 4번 콜센터는 각각 열통의 전화를 받을 수 있습니다
	성금은 1000원 ~ 10000원사이로 1000원단위로 랜덤하게 추출된다고 가정한다.
	각 콜센터에서는 열통의 전화를 받은 후 각 콜센터의 총성금을 출력하고 마지막으로 4개의 콜센터 성금 총액 출력한다.
	
	콜센터 1 ~ 4번까지 1000 ~ 10000원 단위로 성금을 적립됩니다
	3번 콜센터 : 7000원을 받았습니다
	4번 콜센터 : 2000원을 받았습니다
	1번 콜센터 : 4000원을 받았습니다
	4번 콜센터 : 9000원을 받았습니다
	2번 콜센터 : 2000원을 받았습니다
	....
	1번 콜센터 총성금액 : xxxxx원
	3번 콜센터 : 5000원을 받았습니다
	3번 콜센터 총성금액 : xxxxx원
	....
	국민들이 보내주신 총 성금액 : xxxxxx원
 */

class CallThread extends Thread {

	private int ccm ;  //callCenterNumber
	private int sum;
	Random r = new Random();
 
	int getSum() { // 각 콜센터 더한 값 호출하는 getter 생성 
		return sum;
	}
	
	void setCallCenterNumber(int callCenterNumber) { // 
		this.ccm = callCenterNumber;
	}
	@Override
	public void run() {
		for(int i = 0 ; i < 10; i ++) {
			int inputNum = (r.nextInt(10)+1)*1000;
			System.out.println(this.ccm+"번 콜센터 : "+inputNum + "원을 받았습니다." );
			sum += inputNum;
		}
		System.out.println(this.ccm + "번 콜센터 총 성금액 : " + sum +"원"); // 10통 전화 후 각 콜센터 별로 총 성금액 출력
	}
}

public class CallCenterMain {

	
	public static void main(String[] args) {
		
		CallThread t1 = new CallThread();
		CallThread t2 = new CallThread();
		CallThread t3 = new CallThread();		
		CallThread t4 = new CallThread();
		
		// 각 객체별로 콜센터 번호 변경
		t1.setCallCenterNumber(1);	
		t2.setCallCenterNumber(2);
		t3.setCallCenterNumber(3);
		t4.setCallCenterNumber(4);
		
		// Thread 시작
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		try {
			t3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			t4.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int total = t1.getSum()+t2.getSum()+t3.getSum()+t4.getSum();
		
		// 모든 Thread 종료 후 실행
		System.out.println("국민들이 보내주신 총 성금액 : " + total +"원") ;
		
	}
}

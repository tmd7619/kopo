package kr.ac.kopo.day12.inter02;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
//		TV tv = new SamsungTV();		// 묵시적형변환
		TV tv = new SamsungTV();
		tv.powerOn();
		tv.channelDown();		// info() 접근 불가
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.soundDown();
		tv.soundUp();
		tv.soundUp();
		tv.soundUp();
		tv.soundUp();
		tv.mute();
		tv.mute();
		tv.soundUp();
		tv.powerOff();
		tv.copyright();
	}

}

package kr.ac.kopo.day12.inter02;

public class SamsungTV implements TV{
	
	private String modelName;
	private boolean power;
	private int volumeSize;
	private int channelNo;
	private boolean muteToggle; // t > f f > t
	private int currentVolumeSize;
	
	public SamsungTV() {
		// TODO Auto-generated constructor stub
		System.out.println("삼성티비 구매 완료..");
		modelName = "삼성TV";
		power = false;
		volumeSize = 10;
		channelNo= 3;
		muteToggle = false;					// 자동으로 초기화가 되지만, 직관성을 위해 써줌
	}

	@Override
	public void powerOn(){
		System.out.println("전원을 켭니다");
		info();
	}
		
	@Override
	public void powerOff() {
		power = false;
	System.out.println("전원을 끕니다.");
	}

	@Override
	public void channelUp() {
		System.out.println("채널을 올립니다.");
		channelNo = ++channelNo % 100;
	
		info();
		
	}

	@Override
	public void channelDown() {
		System.out.println("채널을 내립니다.");
		channelNo--;
		if(channelNo == 0 ) {
			channelNo = 100;
		}
		info();
	}

	@Override
	public void soundUp() {
		System.out.println("볼륨을 내립니다.");
		
		if(muteToggle) {
			volumeSize = currentVolumeSize;
			muteToggle = false;	// 뮤트 해제
		}
			
		if(volumeSize < TV.MAX_VOLUME_SIZE) {
			volumeSize++;
		}
		info();
	}

	@Override
	public void soundDown() {
		System.out.println("볼륨을 내립니다.");
		if(volumeSize > TV.MIN_VOLUME_SIZE) {
			volumeSize--;
		}
		info();
	}

	@Override
	public void mute() {
		if(muteToggle) {
			System.out.println("음소거 해제");
			volumeSize = currentVolumeSize;
		} else {
			System.out.println("음소거 중....");
			currentVolumeSize = volumeSize;
			volumeSize = TV.MIN_VOLUME_SIZE;
		}
		muteToggle = !muteToggle;

//		volumeSize = TV.MIN_VOLUME_SIZE;
		info();
		
		
	}

	
	private void info() {		// 메소드를 private로 쓰는이유? : info()함수는 이 클래스의 내부에서만 돌고,
								// 이로 인해 document에 보여줄 필요가 없기 때문에, private 함수로 지정해주면 좋다.
								// main에서 sam. 으로 접근을 할 수가 없음
		System.out.println("채널번호 : " + channelNo + ", 음량크기 : " + volumeSize);
	}


	
}

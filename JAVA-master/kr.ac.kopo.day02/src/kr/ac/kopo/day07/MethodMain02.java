package kr.ac.kopo.day07;

public class MethodMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Method m = new Method();
		m.call();		 	// void call()
		m.call(10);			// void call(int i)
		m.call(12.34);
		m.call("hello");
		m.call('a');		// void call(char c) 를 주석처리 했는데도, 오류가 나지 않는 이유는
							// 묵시적 형변환에 의해 가장 작은 int형으로 출력 ( int형 없으면 double로~)
		m.call("hello",true);
		
	}

}

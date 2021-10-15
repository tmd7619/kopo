package kr.ac.kopo.day13;

public class ExceptionMain03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("main start......");

		for (int i = -2; i < 3; i++) {
			System.out.println(i + "번째 반복문 수행중...");
			try {
				System.out.println(10 / i);
			} catch (ArithmeticException ae) {
				System.out.println("예외가 발생...");
				break; // break로 나가게 되면서 break 뒤에 있음에도, finally 문을 무조건 실행하게 된다.
			} finally {
				System.out.println("반복문 수행중....");
			}
		}
		System.out.println("main end ......");
	}

}

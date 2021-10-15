package kr.ac.kopo.day02;

public class IFMain01 {

	public static void main(String[] args) {

		int a = 10, b = 5;

		System.out.println("MAX : " + (a > b ? a : b)); // 삼항연산자

		if (a > b) { // ctrl + Shift + f : 자동정렬
			System.out.println("Max : " + a);
		} else {
			System.out.println("Max : " + b);

		}

		/*
		 * a가 b보다 크다면 a 출력 a가 b보다 작다면 b 출력 a와 b가 같다면 0을 출력 System.out.println( a > b / a
		 * : (a < b ? b : 0) ) ;
		 */

		if (a > b) {
			System.out.println("a > b : " + a);
		} else if (a < b) {
			System.out.println("b > a ; " + b);
		} else {
			System.out.println("a = b" + 0);
		}

	}

}
package kr.ac.kopo.day12;

import java.util.Random;

public class ExceptionMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("main start...");
		
		Random r = new Random();
		int num  = r.nextInt(3); // 0 ~ 2 사이의 난수 발생
		System.out.println("num : "+ num);
		
		System.out.println(10/num); 	// num 이 0 일때, exception발생
		
		System.out.println("main end...");	 // 앞에서 소프트웨어가 강제 종료되기 때문에, 실행 x
	}

}

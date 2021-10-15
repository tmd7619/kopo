package kr.ac.kopo.day04.homework.t;

import java.util.Random;
public class HomeworkMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Random r = new Random();
		
		//  1 ~ 100 사이의 정수를 4개 추출
		int num1 = r.nextInt(100) + 1;  // (0~99) + 1 => (1 ~ 100)
		int num2 = r.nextInt(100) + 1;  // (0~99) + 1 => (1 ~ 100)
		int num3 = r.nextInt(100) + 1;  // (0~99) + 1 => (1 ~ 100)
		int num4 = r.nextInt(100) + 1;  // (0~99) + 1 => (1 ~ 100)
		System.out.println(num1 + "," + num2 + "," + num3 + ","+ num4 );
		
		// <방법1>
		int max = num1 > num2 ? num1 : num2 ;
		if(max < num3) {
			max = num3;
		}
		if(max < num4) {
			max = num4 ;
		}
		System.out.println("가장 큰수 : " + max);
		
		/* <방법2>
		int max1 = num1 > num2 ? num1 : num2;
		int max2 =  num3;
		if(num4 > num3) {
			max2 = num4;
		}
		System.out.println("가장 큰수 : " + (max1 > max2 ? max1 : max2));
		*/
		
	}

}

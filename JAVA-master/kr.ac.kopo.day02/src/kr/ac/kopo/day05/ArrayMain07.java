package kr.ac.kopo.day05;

import java.util.Arrays;

public class ArrayMain07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {10,20,30,40,50} ;
		
		// a배열의 모든 원소에 100을 더하자
		
		for(int num : a) {				
			num = num + 100;
			System.out.println(num);
		}
		
//		for(int i = 0 ; i < a.length; i++) {
//			a[i] = a[i] + 100;
//		}
	
		System.out.println("----------------------------"); 
		for(int num : a) {				// 1.5 포문은 값을 수정할때는 다시 값이 초기화되기 때문에, 
			System.out.println(num);	// 인덱스 방식으로 해야함.  => 1.5v for문은 읽기 전용방식으로만 !
		}
		

	}

}

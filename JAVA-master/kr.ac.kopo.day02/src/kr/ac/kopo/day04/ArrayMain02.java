package kr.ac.kopo.day04;

import java.util.Arrays;

public class ArrayMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1,2,3,4,5를 가지는 배열 arr를 생성
		
		//arr배열의 원소 출력
		
		
		int[] arr = new int[5];
		
		for(int i=0; i < arr.length; i++) {
			
			arr[i] = i+1;
//			System.out.println(arr[i]);
 		}

		
		int[] arr01= {1,2,3,4,5};	// 초기화 하는 동시에 배열에 원소 생성하기 
									// 이방식을 사용하면, 반드시 원소 재생성을 위해new를 통해 초기화
		
		int[] arr02 = new int[] {1,2,3,4,5}; // 초기화 하는 동시에 배열에 원소 생성하기 // 
		
		arr = new int[] {10,20,30,40,50,60,70};
		
		// arr 배열의 원소 출력
		/*
		 * 배열의 전체 요소를 출력하는 방식 3가지
		 * 
		 * 1. 인덱스를 이용한 출력
		 * 
		 * 2. 1.5버전의 for문을 이용한 출력 
		 * 
		 * 3. java.util.Arrays.toString() 메소드를 이용한 출력 
		 *  
		 */
		
		System.out.println("< 방식 1 >");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		
		System.out.println("< 방식 2 >");
		for(int num : arr) {							// int num = arr[0]; int num = arr[1] ;....
			System.out.print(num + "\t");
			
		}
		System.out.println();
		
		System.out.println("< 방식 3 >");
		System.out.println(Arrays
				.toString(arr));
	}

}

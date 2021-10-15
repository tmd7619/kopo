package kr.ac.kopo.day05.exem;

import java.util.Arrays;
import java.util.Scanner;

public class Arrhomework04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[99]; // 2~100까지 배열 생성
		for(int i = 0 ; i < arr.length; i++) {
			arr[i] = i+2;
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 2; j< arr.length/2; j++) { // 소수판별
				if(arr[i] != j && arr[i] % j == 0) { // 배수인 것을 0으로 변환
					arr[i] = 0;
				}
			}
			
		}
		for(int num : arr) {
			if(num != 0) {
				System.out.print(num+" ");
			}
		}
		
		
		
		
	}

}

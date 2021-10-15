package kr.ac.kopo.day05.exem;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2. 다음과 같은 결과를 보이는 프로그램 작성
	짝수 몇개 입력: 5
	홀수 몇개 입력 :4
	
	num1 : 12
	num2 : 9
	num3 : 67
	num4 : 20
	num5 : 9
	num6 : 31
	num7 : 24
	num8 : 5
	num8 : 11
	num8 : 10
	num9 : 6
	
	<PRINT> 
	12 20 24 10 6 31 9 67 9
 * 
 */

public class Arrhomework02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("짝수 몇개 입력 :");
		int num = sc.nextInt(); // arr 짝수 개수
		System.out.println("홀수 몇개 입력 :");
		int num2 = sc.nextInt(); // arr 홀수 개수

		int[] a = new int[num]; // 짝수배열
		int[] b = new int[num2]; // 홀수배열
		int[] arr = new int[a.length + b.length];

		int idx = 0;
		int idx2 = 0;
		int i = 1;

		while (i <= num + num2) {
			System.out.println("num" + i + " : ");
			int num3 = sc.nextInt(); // 정수 입력받기

			if (num3 % 2 == 0) { // 짝수
				if (idx + 1 > num) {
					continue;
				}
				a[idx] = num3;
				idx++;

			} else { // 홀수
				if (idx2 + 1 > num2) {
					continue;
				}
				b[idx2] = num3;
				idx2++;
			}
			i++;
		}
		System.arraycopy(a, 0, arr, 0, a.length);
		System.arraycopy(b, 0, arr, a.length, b.length);
		System.out.println("<PRINT>");
		System.out.println(Arrays.toString(arr));
	}
}

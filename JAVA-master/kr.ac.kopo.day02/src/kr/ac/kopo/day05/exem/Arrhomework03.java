package kr.ac.kopo.day05.exem;

import java.util.Arrays;
import java.util.Scanner;

/*3. 소수는 1 ~ (판단정수) 사이의 소수로만 나누어 약수가 존재하지 않는다라는 규칙성을 이용함
2 ~ 100사이의 소수를 구분 및 출력하는 코드를 작성 ( 배열 사용)
*/

public class Arrhomework03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("판단정수 입력 : ");
		int num = sc.nextInt();

		int cnt = 0;
		int[] arr = new int[num]; // num으로 배열 개수 임시 지정
		
		for (int i = 2; i < num; i++) {
			for (int j = 2; j <= i; j++) { // 1~num 사이의 소수 구하기
				if (j == i ) {
					arr[cnt] = j;
					cnt++; // 소수의 개수 저장
				}	
				if (i % j == 0) { // 자기자신 외 약수가 존재하는지 판단
					break; // 약수 존재하면 소수가 아니기에, 판단 종료
				}
			}
		}
		int[] arr2 = new int[cnt]; // cnt : 소수의 개수
		System.arraycopy(arr, 0, arr2, 0, cnt); // arr에 있는 0 제거
		System.out.println(Arrays.toString(arr2));

		for (int j = 0; j < arr2.length; j++) {	// input값을 소수배열 원소로 나눠보기
			if (num % arr2[j] == 0) {
				System.out.println("소수가 아닙니다");
				break;
			} else {
				System.out.println("소수입니다.");
				break;
			}
		}

	}

}

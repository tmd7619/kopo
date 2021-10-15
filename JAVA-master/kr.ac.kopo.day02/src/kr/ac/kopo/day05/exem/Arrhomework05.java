package kr.ac.kopo.day05.exem;

import java.util.Scanner;

/*
 * 5. 별그리기 관련 문제를 라인수를 입력받아 출력하는 코드를 작성

20라인을 입력받으면 19줄의 모양으로 구성

----*
---**
--***
-****
*****


3 - 20 사이의 라인수를 입력받고, 짝수 입력시 하나 작은 홀수로 작성

	*****			    *********
	****				 *******
	***					  *****
	**					   ***	
	*						*
	**					   ***
	***					  *****
	****   				 *******
	*****				*********
 */

public class Arrhomework05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("3 ~ 20 사이의 라인수를 입력하세요 : ");
		int line = sc.nextInt();

		if (line % 2 == 0)
			line = line - 1;

		for (int i = 0; i < line; i++) { // 1번그림
			for (int j = 0; j < line - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();

		int star = line / 2+1 ;		// 별의 개수가 변하는 지점(중간)
		for (int i = 0; i < line; i++) {		// 2번그림
			for (int j = 0; j < star; j++) {
				System.out.print("*");
			}
			if (i < line / 2)
				star--;
			else
				star++;
			System.out.println();
		}

		System.out.println();
		System.out.println();
		System.out.println();
		for(int i = 0,z=0; i < line; i++) {		// 3번그림
			for(int j = 0 ; j < (line-z); j++) {
				System.out.print((j<z)?" ": "*");
			}
			if(i<star-2) {
				z++;
			}else {
				z--;
			}
			
			System.out.println();
		}
		
		
	}
}

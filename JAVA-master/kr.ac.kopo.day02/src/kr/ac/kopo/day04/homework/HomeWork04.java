package kr.ac.kopo.day04.homework;

/*
 * 
 * 4. 소수 : 1과 자기자신 외에는 약수가 존재하지 않는 양의 정수
	정수를 입력 : 23
	23은 소수입니다.
	
	정수를 입력 : 12
	12는 소수가 아닙니다
 * 
 */


import java.util.Scanner;

public class HomeWork04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 입력 :");
		int num = sc.nextInt();
		
		int check = 0 ;
		for(int i=2 ; i<num; i++ ) {
			if(num % i == 0) {
				check++;
			}
			}
		if(check == 1 ) {
			System.out.println(num+"은 소수가 아닙니다.");
		}else {
			System.out.println(num+"은 소수입니다.");
		}
		
	}

}

package kr.ac.kopo.day04.homework;

import java.util.Scanner;

public class HomeWork05 {
/*
	5. 2 ~ 100사이의 소수를 출력

	2 3 5 7 11 13 17 .... 97
	--------------------------
	2 3 5 7 11
	13 17 ........
*/	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int check = 0 ;
		int line = 0 ;
		for(int i=2 ; i<=100; i++ ) {
			for(int j = 2; j<=i; j++) {
			if(i % j == 0) {
				check++;
			}
			}
			if(check==1) {
				System.out.print(i+ " ");	
				line += 1;
				if(line == 5) {
					System.out.println();
					line = 0;
				}
			}
			check = 0;
	
		}

	}
}
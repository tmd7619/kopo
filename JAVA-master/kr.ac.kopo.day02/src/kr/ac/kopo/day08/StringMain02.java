package kr.ac.kopo.day08;

import java.util.Arrays;
import java.util.Scanner;

public class StringMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str = "hello world";
		char[] chars = new char[str.length()];
		
		/*
		for(int i = 0 ; i< str.length(); i++) {
			chars[i] = str.charAt(i);
			
		}
		 */
		

		str.getChars(0,str.length(), chars, 0); // 0부터 str의  length  -1 만큼 chars의 0부터 넣겠다.
		System.out.println(Arrays.toString(chars));
		
		System.out.println(str+"의 길이"+str.length()); // 공백포함
		System.out.println("0번째에 위치한 문자 : "+str.charAt(0)); // 인덱스 순서
		System.out.println("7번째에 위치한 문자 : "+str.charAt(7));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력 : ");
		char c = sc.nextLine().charAt(0);
		System.out.println(c);
	}
}

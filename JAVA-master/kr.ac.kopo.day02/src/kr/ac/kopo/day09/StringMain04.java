package kr.ac.kopo.day09;

import java.util.Arrays;

public class StringMain04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "hello world";
		
		String subStr = str.substring(1,5);		// 1번째 idx부터, 4번째 idx까지 부분반환
		
		System.out.println("substring(1,5) : ["+subStr+"]");
		
		subStr = str.substring(6);		// 6번째 idx부터 끝까지~
		System.out.println("substring(6) : ["+subStr+"]");
		
		System.out.println("-------------------------------------");
		String str1 = "hello";
		String str2 = "!!!!";
//		str = str1 + str2;
		str = str1.concat(str2);
		System.out.println("concat(str1,str2) 결과 : "+str);
		
		System.out.println("-------------------------------------");
		str = "hello world";
		System.out.println("replace() 전 : "+str);
		str = str.replace('l', 'r'); 				// 문자 치환
//		str = str.replace("ll","rrrrrrrr");			// 문자열 치환
		System.out.println("replace() 후 : "+str);
		
		System.out.println("-------------------------------------");
		str = "           hello  world    ";
		System.out.println(str+"의 trim()전 길이 : "+str.length());
		str = str.trim();  							// 공백제거 ( 좌우의 공백만 제거가능)
		System.out.println(str+"의 trim()후 길이 : "+str.length());
		str = str.replace(" ","");					// 중간 공백제거
		System.out.println("중간 공백 제거 후 : "+str);
		
		
		System.out.println("-------------------------------------");
		str = "Hello World";
		str = str.toUpperCase();		// 모든 문자 대문자 변환
		System.out.println(str);
		str = str.toLowerCase(); 		// 소문자 변환
		System.out.println(str);
		
		System.out.println("-------------------------------------");
		str = "홍길동전:허균:조선시대";
		String[] strArr = str.split(":");
		System.out.println(Arrays.toString(strArr));
		
		String ip = "192.168.5.203";
		String[] ipArr = ip.split("\\.");				//  .(도트)를 출력할때는 < \\. >로 써야함. (단순출력은 .만써도 가능)
		System.out.println(Arrays.toString(ipArr));
		
		System.out.println("-------------------------------------");
		int num = 123;
//		String strNum = num + "";
		String strNum = String.valueOf(num);   // 정수를 포함하여 다양한 타입들을 문자열로 바꿔줌
		System.out.println(strNum+10);		   // strNum이 문자열이라 123+10 = 133이 아닌 12310이 출력
		System.out.println(String.valueOf(true)+false);
		
		
		
	}

}

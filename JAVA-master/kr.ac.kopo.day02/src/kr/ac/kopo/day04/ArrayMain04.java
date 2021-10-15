package kr.ac.kopo.day04;

import java.util.Arrays;

public class ArrayMain04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 참조자료형 배열 구조는 기본자료열 배열구조의 2차원 구조같이 생겼음
//		String[] strArr = {"폴리텍", "데이터분석", "자바"};
		String[] strArr = {new String("폴리텍"),new String("데이터분석"),new String("자바")};
		
		
		
		System.out.println("strArr : " + strArr);
		
		System.out.println("배열의 크기 : "+ strArr.length );
		
		System.out.println("첫번째 문자열 : " + strArr[0] );
		System.out.println("두번째 문자열 : " + strArr[1] );
		System.out.println("세번째 문자열 : " + strArr[2] );
		
		
		System.out.println("<1 방식>");
		for(int i = 0 ; i <3 ; i++) {
			System.out.println(i+ "번째 문자열 : "+strArr[i]); // index를 이용한 출력
		}
		
		System.out.println("<2 방식>");
		for(String str : strArr) {		//index를 이용하지 않았음
			System.out.println(str);
			
			System.out.println("<3 방식>");	
			System.out.println(Arrays.toString(strArr));
		}
	
	}

}

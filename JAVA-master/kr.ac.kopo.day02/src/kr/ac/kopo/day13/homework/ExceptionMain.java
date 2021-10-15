package kr.ac.kopo.day13.homework;

import java.util.Scanner;

/*
 * 
 * 과제1>
   좋아하는 로또 번호를 입력하세요 : 34
   34를 포함해서 로또번호들을 추출하겠습니다

   좋아하는 로또 번호를 입력하세요 : 77
   LottoNumberException : 1 - 45사이만 가능합니다. 77은 올바르지 않습니다 

 * 
 */

public class ExceptionMain {
	
	static void loto() throws LottoNumberException{ // LottoNumberException 오류를 자신을 호출한 쪽으로 넘기겠다
		Scanner sc = new Scanner(System.in);
		System.out.print("좋아하는 로또 번호를 입력하세요 : ");
		int lotoNum = sc.nextInt();
		if(lotoNum > 45 || lotoNum < 1) {
			throw new LottoNumberException("LottoNumberException : 1 - 45사이에만 가능합니다 "+lotoNum+"은 올바르지 않습니다");	// 예외 발생시키기
		}
		System.out.println(lotoNum+" 숫자를 포함해서 로또번호들을 추출하겠습니다.");
		
		
	}
	public static void main(String[] args) {
		try {
			loto();								// loto() throws로 인해 예외처리를 반드시 해주어야함.
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

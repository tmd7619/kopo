package kr.ac.kopo.day13;

import java.util.Scanner;

/*
 * 등록할 ID를 입력하세요 : hello1234
 * ID는 최대 8글자만 가능합니다
 * 
 * 등록할 ID를 입력하세요 : hello123
 * ID를 등록하였습니다
 */

public class ExceptionMain06 {
	
	static void register() throws CheckIDException {
		Scanner sc = new Scanner(System.in);
		System.out.println("등록할 ID를 입력하세요 :");
		String id = sc.nextLine();
		
		if(id.length() > 8) {
			throw new CheckIDException("ID는 최대 8글자만 가능합니다"); // 예외를 임의로 발생시킴 (사용자정의)	Exception는 다양한 생성자를 가지고 있음=> 예외메세지 입력가능
		}
		
		System.out.println("ID를 등록하였습니다.");
	}

	public static void main(String[] args) {
		
		try {
			register();

		} catch(Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage()); // 예외 메세지만 출력하고 싶을때
		}
	}

}

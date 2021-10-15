package kr.ac.kopo.day09.homework.t;

public class StringUtil {

	public String reverseString(String str) {

		// 5 번 - (1)방법
		/*
		 * char[] chars = new char[str.length()]; for(int i = str.length()-1 , j = 0; i
		 * >= 0 ; i --) { chars[j++] = str.charAt(i) ; }
		 * 
		 * return new String(chars); // String 생성자를 만들어, chars배열을 String으로 변환하기 }
		 */

		// 5번 - (2)방법
		int length = str.length(); // 메소드를 계속 호출하는 것이 좋은것이 아니다
		char[] chars = new char[length]; // 따라서 str.length()함수를 변수화 하자
		str.getChars(0, str.length(), chars, 0);
		for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}

	// 6번
	public String toUppeString(String str) {
		byte[] bytes = new byte[str.length()];
		for (int i = 0; i < str.length(); i++) {
			byte b = (byte) str.charAt(i);
			// 소문자인경우 대문자로 변경해서 대입
			if (b >= 'a' && b <= 'z')
				b = (byte) (b - ('a' - 'A'));
			bytes[i] = b;
		}
		return new String(bytes);

	}
}

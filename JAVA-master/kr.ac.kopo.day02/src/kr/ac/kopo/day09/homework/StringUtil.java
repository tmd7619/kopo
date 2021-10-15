package kr.ac.kopo.day09.homework;

/*
 * 알파벳 아스키 코드 A-65  Z-90  a-97  z-122
 *	65<= char <=90 이면 대문자, 97<= char <= 122 이면 소문자이다. 			
 * 소문자 -> 대문자로 변환하려면, char에 32를 빼주고, 반대일 경우, 32를 더해준다.
 */

public class StringUtil {

	public static boolean isUpperChar(char inputChar) { // 대문자면 true 반환하는 메소드
		if (inputChar >= 65 && inputChar <= 90) { // 65<= char <=90 //대문자
			return true;
		} else {
			return false;
		}
	}

	public static boolean isLowerChar(char inputChar) { // 소문자면 true 반환하는 메소드
		if (inputChar >= 97 && inputChar <= 122) { // 97<= char <= 122 //소문자
			return true;
		} else {
			return false;
		}
	}

	public static int max(int inputNum, int inputNum02) {
		if (inputNum > inputNum02) {
			return inputNum;
		} else {
			return inputNum02;
		}
	}

	public static int min(int inputNum, int inputNum02) {
		if (inputNum < inputNum02) {
			return inputNum;
		} else {
			return inputNum02;
		}
	}

	public static StringBuilder reverseString(String str) {
		StringBuilder reverseStr = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			reverseStr.append(str.charAt(i));
		}
		return reverseStr;
	}

	public static StringBuilder toUpperString(String str) {
		StringBuilder UpperStr = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int a = str.charAt(i) - 32; // char에서 32를 뺸 값이 대문자
			UpperStr.append((char) a);
		}
		return UpperStr;
	}

	public static StringBuilder toLowerString(String str) {
		StringBuilder loweStr = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int a = str.charAt(i) + 32; // char에서 32를 더한 값이 소문자
			loweStr.append((char) a);
		}
		return loweStr;
	}

	public static int checkChar(String strData, char ch) {
		int cnt = 0;
		for (int i = 0; i < strData.length(); i++) {
			if (strData.charAt(i) == ch) {
				cnt++;
			}
		}

		return cnt;
	}

	public static StringBuilder removeChar(String oriStr, char delChar) {
		StringBuilder removeStr = new StringBuilder();
		for (int i = 0; i < oriStr.length(); i++) {
			if (oriStr.charAt(i) != delChar) {
				removeStr.append(oriStr.charAt(i));
			}
		}
		return removeStr;
	}

}

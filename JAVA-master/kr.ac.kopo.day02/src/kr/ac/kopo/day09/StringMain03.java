package kr.ac.kopo.day09;

import javax.swing.text.Utilities;

public class StringMain03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = new String("hello");
		String str2 = new String("hello");
		String str3= new String("HELLO");
	
//		String str = "hello"
//		String str2 = "hello"
	
		// "hello"로 만든 문자열은 같은 "hello"를 가리키기 때문에 true
		
		// new String으로 만든 문자열은 주소비교를 통해 이루어짐
		// 다른 주소 값에 "hello"가 있기 때문에, 결과는 false
		// 따라서 동등비교를 하려면 equals를 이용해야함
		if(str == str2) {
			System.out.println("str == str2");
		} else {
			System.out.println("str != str2");
		}
		
		
		System.out.println("str : ["+str+"]");
		System.out.println("str2 : ["+str2+"]");
		
		// equals 비교
		boolean bool = str.equals(str2);
		if(bool) {
			System.out.println("equals() : str == str2");
		} else {
			System.out.println("equals() : str != str2");
		}
		
		System.out.println("-------------------------------------");
		System.out.println("str : ["+str+"]");
		System.out.println("str2 : ["+str3+"]");
		boolean bool2 = str.equalsIgnoreCase(str3); // 대문자 소문자 구문 x
		if(bool2) {
			System.out.println("equals() : str == str3");
		} else {
			System.out.println("equals() : str != str3");
		}
		
		System.out.println("-------------------------------------");
		// startsWith()				// 대소문자 구분함!
		str = "hello !!!!";
		str2 = "hello world";
		
		String sub = "hello";
		
		boolean bool3 = str.startsWith(sub);
		
		if(bool3) {
			System.out.println(str+"은 "+sub+"문자열로 시작합니다");
		} else {
			System.out.println(str+"은 "+sub+"문자열로 시작하지 않습니다.");
		}
		System.out.println("-------------------------------------");
		// endsWith()
		str = "hello.txt";
		bool = str.endsWith(".txt");
		if(bool) {
			System.out.println(str+"은 텍스트 파일입니다");
		} else {
			System.out.println(str+"은 텍스트 파일이 아닙니다.");
		}
		System.out.println("-------------------------------------");
		// compareTo()
		
		str = "boat";
		str2 = "board";
		
		int compare = str.compareTo(str2);
		if(compare==0) {
			System.out.println(str+"과 "+str2+"는 같은문자입니다.");
		} else if(compare < 0){
			System.out.println(str+"가 "+str2+"보다 작습니다."); // 문자열의 길이와는 아무 연관x
		} else{		// compare > 0
			System.out.println(str+"가 "+str2+"보다 큽니다.");	// 알파벳 순서와 연관이 있음.
		}
		System.out.println("-------------------------------------");
		
		String[] names = {"강길동","홍길동","홍길순","김길동","윤길동","박홍철","홍길동"};
		
		System.out.println("< 이름이 홍길동인 사람 검색 >"); // 검색할 시에는, arraysTostring을 사용할 수 없다.
		for(int i = 0 ; i < names.length; i++) {
			if(names[i].equals("홍길동")){
				System.out.println(names[i]);
			}
			
		}
		System.out.println("-------------------------------------");
		System.out.println("< 홍씨성을 가진 사람 검색 >");	// 1.5 포문이 인덱스로 찾는거보다 더 간편함
		for(String name : names) {
			if(name.startsWith("홍")) {
				System.out.println(name);
			}
		}
		System.out.println("-------------------------------------");
		System.out.println("< 이름이 길동이 사람만 검색 >");
		for(String name : names) {
			if(name.endsWith("길동")) {
				System.out.println(name);
			}
		}
		System.out.println("-------------------------------------");
		System.out.println("< 홍이라는 글자가 포함된 사람 검색 >");
		for(String name : names) {
			if(name.contains("홍")) {				// .contains() : 순서와 상관없이 포함된 글자가 있는 문자열을 찾고싶을때
				System.out.println(name);
			}
		}
		System.out.println("-------------------------------------");
		str = "hello world";
		
		str.indexOf("o");				// indexOf() :  문자열 내에서 특정한 문자열의 index 값을 리턴한다.
		int searchIdx = str.indexOf("o");
		System.out.println("\"o\" 시작위치 : " +searchIdx);
		
		searchIdx = str.indexOf("o",5); // o라는 문자의 인덱스를 찾는데, 5번째부터 찾겠다.
		System.out.println("\"o\" 시작위치 : " +searchIdx);
		
		searchIdx = str.lastIndexOf("o");
		System.out.println("\"o\" lastIndexOf() 위치 : " +searchIdx);
		
		System.out.println("-------------------------------------");
		str = "hello world";			// l이 있는 인덱스 구하기
		char ch = 'l';
		searchIdx = str.indexOf(ch);
		while(searchIdx != -1) {
			System.out.println("검색된 위치 : "+searchIdx);
			searchIdx = str.indexOf(ch,searchIdx+1);
		}
		
		
		System.out.println("-------------------------------------");
		searchIdx = -1;			// -1로 초기화 (while문에서 searchIdx +1부터 찾기 때문)
		while( (searchIdx = str.indexOf(ch,searchIdx+1)) != -1) {			// 더 효율적인 방법
			System.out.println("검색된 위치 : "+searchIdx);
		
		}
		
		System.out.println("-------------------------------------");
		searchIdx = str.length();		// 거꾸로 인덱스 찾기
		while( (searchIdx = str.lastIndexOf(ch,searchIdx-1)) != -1) {
			System.out.println("검색된 위치 : "+searchIdx);
		}
	}
}

package kr.ac.kopo.day14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
    Set : 순서 x 중복 x
    장점 : 검색속도 빠름
    구현클래스 : HashSet, TreeSet
  
 */

public class SetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> set = new HashSet<>();
//		Set<String> set = new TreeSet<>();  // TreeSet은 데이터가 문자열일 경우,  출력 순서가 사전순( a~ z 오름차순) 으로 나온다.
		
		
		boolean bool = set.add("one");
		System.out.println("\"one\" 데이터 삽입 여부 : " + (bool ? "성공" : "실패"));
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		bool = set.add("one"); // 삽입 x  => 중복 x 
		System.out.println("\"one\" 데이터 삽입 여부 : " + (bool ? "성공" : "실패"));
		
		/*
		 * 
		 * set의 전체 데이터 출력방식
		 * 1. 1.5버전의 for문방식
		 * 2. iterator() 메소드 이용
		 */
		System.out.println("-------1.5 포문 이용--------");	
		for(String str : set) {
			System.out.println(str);
		}
		
		System.out.println("-------iterator 이용--------");
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
		
		System.out.println("-------toArray 이용--------");
		Object[] arr = set.toArray();
		System.out.println(Arrays.toString(arr));
		
		
	}

}

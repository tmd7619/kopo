package kr.ac.kopo.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
	List : 순서(o), 중복(o)
	구현 클래스 : ArrayList, LinkedList
	
	 주요 메소드 
	 
	 - add() 		: 데이터 입력
	 - get()		: 해당 인덱스에 있는 데이터 추출
	 - remove() 	: 데이터 삭제
	 - size() 		: 리스트의 전체 데이터 개수
	 - clear() 		: 리스트의 전체 데이터 삭제
	 - isEmpty()	: 리스트가 비어있는지 체크 (true/false)
	 - contains()	: 특정데이터의 존재여부 판단(true/false 
	 - Iterator()	: Iterator 객체를 반환
*/

public class ListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		List list = new ArrayList(); // 1.5버전 미만의 방식
		List<String> list = new ArrayList<String>();		// 1.5 버전의 Generic 이용
		List<String> list02 = new ArrayList<>();		// 1.7 버전 이후의 Generic 방식 뒤에 String을 생략해도, 알아서 String이라고 인식한다
		
		list.add("one");
//		list.add(10);	// error알아서 Object가 String으로 바뀌기 때문에, 다른 type은 올 수 없다
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		System.out.println("five 추가전 리스트의 원소 총 개수 : "+list.size());
		list.add("five"); // list는 중복을 허용한다.
		System.out.println("five 추가후 리스트의 원소 총 개수 : "+list.size());
		
		/*
		 * list의 전체 데이터 출력
		 * 1. index를 이용한 get() 메소드 이용
		 * 2. 1.5버전의 for문 이용
		 * 3. toArray() 메소드 이용			// 사용빈도가 낮다 (toArray()를써도, 1.5포문이나 인덱스방식으로 출력을 해야하기 때문)
		 * 4. Iterator()
		 */
		
		System.out.println("get() 메소드를 이용한 출력");
		for(int i = 0 ; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("1.5 for문을 이용한 출력");
		for(String str : list) {
			System.out.println(str);
		}
		
		System.out.println("toArray()를 이용한 출력"); // list의 원소를 고정된 길이의 배열에 넣어주는 방식
		Object[] arr = list.toArray();				
		System.out.println(Arrays.toString(arr));
		
		/*
		 * 
		 * Iterator(순환자) 주요 메소드
		 * -hasNext()	: 추출한 다음데이터의 존재여부 판단
		 * -next() 		: 데이터추출 
		 */
		
		
		System.out.println("Iterator()를 이용한 출력");
		Iterator<String> ite = list.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		
		boolean bool = list.remove("two");
		String searchStr = "two";
		if(list.contains(searchStr)){
			System.out.println(searchStr+"은 존재합니다");
		}else {
			System.out.println(searchStr+"은 존재하지 않습니다.");
		}
		
		
		bool = list.remove("two");
		System.out.println("remove : " + bool);
		
		System.out.println("첫번째 문자열 : " + list.get(0));
		String removeStr = list.remove(0);	// 인덱스를 이용한 삭제
		System.out.println("삭제된 문자열 : "+removeStr);
		System.out.println("remove(0) 후 첫번째 문자열 : "+ list.get(0));
		
		
		System.out.println("원소 총 개수: "+ list.size());
		list.clear();
		System.out.println("clear() 수정 후 list : "+list);
		
		List<String> sub = new LinkedList<>();	// Arraylist는 LinkedList와 호환이 된다.
		sub.add("봄");
		sub.add("여름");
		
		list.addAll(sub);
		System.out.println("addAll() 후 원소의 개수 : " + list.size());
		
		
		
		
	}

}

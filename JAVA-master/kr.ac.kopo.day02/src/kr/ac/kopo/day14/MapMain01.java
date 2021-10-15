package kr.ac.kopo.day14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
 * Map : Key, value의 쌍으로 구성된 데이터의 집합, 키에대한 중복x 순서 x 
 * 구현 클래스 : HashMap, TreeMap
 * 
 */


public class MapMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Key : ID , value : 비밀번호
		Map<String , String > map = new HashMap<>();
		map.put("aaa", "1111");
		map.put("bbb", "2222");
		map.put("ccc", "3333");
		map.put("ddd", "4444");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("패스워드 변경서비스입니다");
		System.out.println("ID를 입력하세요 : ");
		String id = sc.nextLine();
		if(!map.containsKey(id)) {
			System.out.println("입력하신 ID ["+id+"]는 존재하지 않습니다.");
			System.out.println("서비스를 종료합니다.");
			System.exit(0);
		}
		System.out.println("현재 패스워드를 입력하세요 : ");	 //  System.exit(0)로 인해 else 구문 기능과 똑같다.
		String password = sc.nextLine()	;
		if(!map.get(id).equals(password)) { // 키밸류가 같은 주소값이기 때문에, equals로 주소값 T/F 판별
			System.out.println("패스워드가 잘못되었습니다");
			System.out.println("서비스를 종료합니다.");
			System.exit(0);
		}
		
		System.out.println("변경할 패스워드를 입력하세요 : "); // .equals 가 true일때
		String newPassword = sc.nextLine()	;
		map.put(id, newPassword);
		
		System.out.println("패스워드가 변경되었습니다.");
		
		// map 출력은 어떻게? ==> entrySet()   
		// 실제 map이 가지고 있는 key, value값은 Map의 inner class인 Entry가 가지고 있음 // 클래스 앞에 $표시가 있으면 inner클래스 
		// 따라서 map의 데이터 출력은 Entry의 키밸류 값을 set으로 변환하여 출력한다.
		System.out.println("<< 전체 회원 정보 출력 >>");
//		Set<Map.Entry<String, String>> entrySet = map.entrySet(); // import java.util.Map.Entry를 통해 Map 생략 가능
		Set<Entry<String, String>> entrySet = map.entrySet();
		for(Entry<String, String> e : entrySet) {
			System.out.println("ID : "+e.getKey()+", PASSWORD : "+e.getValue());
		}
		
		
		Iterator ite = map.entrySet().iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		Set<String> keys =  map.keySet();
		for(String key : keys) {
			System.out.println("ID : " + key + ", PASSWORD : " + map.get(key));
		}
	}

}
/*
entrySet()은 key와 value 모두가 필요할 경우 사용하며 
keySet()은 key 값만 필요할 경우 사용하는데 key값만 받아서 
set(key)를 활용하여 value도 출력할 수도 있기에 
어떤 메소드를 선택하든지 간에 큰 상관이 없어 대부분 코드가 간단한 keySet을 활용하시던데
key값을 이용해서 value를 찾는 과정에서 시간이 많이 소모되므로 
많은 양의 데이터를 가져와야 한다면 entrySet()이 좋습니다.(약 20%~200% 성능 저하가 있음)
*/



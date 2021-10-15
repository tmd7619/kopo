package kr.ac.kopo.day15;

import java.util.HashMap;
import java.util.Map;

class Member{
	
	/*
	@Override
	public boolean equals(Object obj) {		// Object의 equals는 주소값을 비교하기 때문에 오버라이드를 통해 변경해야 함
		// TODO Auto-generated method stub
		boolean result = false;
		
//		name.equals(obj.name)			// obj.name은 묵시적 형변환에 의해 오버라이딩 메소드만 접근할 수 있는데, ( Object => Member)
										// name은 Member의 멤버변수이기 때문에 접근 x => 명시적형변환 해야함
		
		Member mem = (Member)obj;		// 명시적형변환
		name.equals(mem.name);
		
		if(name.equals(mem.name) && phone.equals(mem.phone)) {
			result = true;
		}
		
		return result;
	}
	*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	private String name;
	private String phone;
	public Member(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

class Car{
	
	private String name;
	private String id;
	public Car(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}


class MemberInfo {
	private Member m ;
	private Car c ;
	
	MemberInfo(Member m ,Car c){
		
	}
}

class Test {
	
	public Map<String, Object> returnTest2() {
		Member m = new Member();
		Car c = new Car();
		
		Map<String, Object> map = new HashMap<>();
		map.put("member", m);
		map.put("car", c );
		
		Object[] arr = new Object[2];
		return map;
	}
	
	public MemberInfo returnTest3() {
		Member m = new Member();
		Car c = new Car();
		
		MemberInfo info = new MemberInfo(m,c);
		
		return info;
	}
	
	
}

public class MapMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 	Map에 저장되어있는 홍길동이 차를 제네시스로 변경한다면? => 
		 */
		
		Map<Member, Car> carList = new HashMap<>();
		
		carList.put(new Member("홍길동", "010-1111-2222"), new Car("소나타", "12소12312"));
		carList.put(new Member("박동", "010-3333-4444"), new Car("카니발", "23가3245"));
		carList.put(new Member("윤길동", "010-4444-5555"), new Car("그랜저", "56하1234"));
		carList.put(new Member("강길동", "010-5555-6666"), new Car("모닝", "23고6345"));
		
		System.out.println("등록대수 : "+ carList.size());
		carList.put(new Member("홍길동", "010-8888-9999"), new Car("SM3", "25다123"));
		System.out.println("등록대수 : "+ carList.size());
		
		carList.put(new Member("홍길동", "010-1111-2222"), new Car("제네시스", "42거12312"));  // Map에서 데이터의 동일함을 판단할때, equals()와 hashcode 두가지 모두 판단해야 한다.
		System.out.println("등록대수 : "+ carList.size());										// Source - Generate hashcode and equals... 로 해결하자 ( 두 오버라이딩을 정의하기 힘듬)
																							    //  하지만 equals() 오버라이딩 개념은 이해하고 있어야함
		
		
		Member m = new Member("홍길동", "010-1111-2222");		
		Member m2 = new Member("홍길동", "010-1111-2222");
		System.out.println(m);		// hashcode
		System.out.println(m2);
		
		/*
		Member m = new Member("홍길동", "010-1111-2222");		
		Member m2 = new Member("홍길동", "010-1111-2222");
			
		if(m.equals(m2)) {							// Object클래스의 equals 메소드를 쓰는데 Object의 equals는 기본적으로 주소값을 비교하게 되어있다.
			System.out.println("똑같다");			// 따라서 주소값이 다르기 때문에 값이 똑같아도, 다르다고 인식을 함 
		}else {										// 그렇기에, Object클래스의 equals 메소드를 override를 해야함 => Member 클래스 내에 equals 메소드 오버라이딩
			System.out.println("다르다");
		}
		*/
		
	}

}

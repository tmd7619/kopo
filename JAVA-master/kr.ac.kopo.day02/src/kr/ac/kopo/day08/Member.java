package kr.ac.kopo.day08;
/*
 * <매개변수가 없는 디폴트 생성자를 먼저 만들고, 매개변수가 있는 생성자를 만들자>
 */

public class Member {

	String name;
	int age;
	String bloodType;
	
	
	Member(){									
		this("알수없음");	// 인자가 없으면 알수없음을 넣기
	}
	
	Member(String name){
		this(name,-1);
	}
	Member(String name, int age){
		this(name,age,"알수없음");
	}
	Member(String name, int age, String bloodType){
		this.name = name;
		this.age = age;
		this.bloodType = bloodType;
	}
	
	
	
	/*
	Member(){					// 아무것도 적지 않았을때 info()를 하면 나오는 값을 초기화
		this("알수없음",-1,"알수없음");
	}
	
	
	Member(String name){			// 생성자 overloading
		this.name = name;			// this키워드를 이용해서 멤버변수와 지역번수를 구분시킨다.
									// 이럴 경우에는 this를 생략하면 안된다	
		
		age = -1;				// age의 경우, 이미 생성자 안에 this를 사용했기 때문에 생략이 가능함
		bloodType = "알수없음";
	}								
	Member(String name,int age){	
		this(name,age,"알수없음");	// this 생성자 가장 먼저 실행되야함.
//		System.out.println("....."); // println이 위로 가게 되면, 에러 발생
	}
	Member(String name, int age, String bloodType){
		this.name = name;
		this.age = age;
		this.bloodType = bloodType;
	}
	*/
	
	
	
	void info() {
		System.out.println("이름 : "+ name + ", 나이 : "+age + ", 혈액헝 : "+bloodType);
		
	}
}


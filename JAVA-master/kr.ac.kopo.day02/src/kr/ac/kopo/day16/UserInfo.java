package kr.ac.kopo.day16;

import java.io.Serializable;

/*
 *  alt + shift + s 누른 후 c 선택 : 기본 생성자 
 * 							o 선택 : 매개변수를 가지는 생성자
 * 							r 선택 : getter / setter 메소드
 * 							v 선택 : override
 * 							s 선택 : toString() 메소드 오버라이드
 */

public class UserInfo implements Serializable { // 어떻게 직렬화를 시켜야 하는지를 설정하기 위해 인터페이스 상속

	private String name;
	private transient int age; // transient ?  객체 직렬화를 할때 age변수를 제외시키겠다. 
	private String addr;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	String getAddr() {
		return addr;
	}

	void setAddr(String addr) {
		this.addr = addr;
	}

	
}

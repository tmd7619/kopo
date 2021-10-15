package kr.ac.kopo.day16;

import java.io.Serializable;

// VO : Value Object  vo와 dto는 거의 같은 이름 

public class UserVO implements Serializable {

	private String name ;
	private int age;
	private String phone;
	private String addr;
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserVO(String name, int age, String phone, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.addr = addr;
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

	String getPhone() {
		return phone;
	}

	void setPhone(String phone) {
		this.phone = phone;
	}

	String getAddr() {
		return addr;
	}

	void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "UserVo [name=" + name + ", age=" + age + ", phone=" + phone + ", addr=" + addr + "]";
	}
	

}

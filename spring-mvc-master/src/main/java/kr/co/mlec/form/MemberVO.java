package kr.co.mlec.form;

public class MemberVO { // 자바빈즈클래스 // 멤버변수 private , 기본생성자o , get/setter 

	private String id;
	private String name;
	private String password;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
	
	
}

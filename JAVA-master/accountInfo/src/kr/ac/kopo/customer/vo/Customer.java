package kr.ac.kopo.customer.vo;

public class Customer {
	
	private String id; // 아이디
	private String pwd; // 비밀번호
	private String name; // 고객이름
	private String birth; // 생년월일(6자)
	private String regdate;  // 가입날짜
	
	
	
	
	
	public Customer() {
		
	}
	public Customer(String id, String pwd, String name, String birth, String regdate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.regdate = regdate;
	}
	public Customer(String id, String pwd, String name, String birth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
	}
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", birth=" + birth + ", createdAt="
				+ regdate + "]";
	}
	
	
	
	
	

}

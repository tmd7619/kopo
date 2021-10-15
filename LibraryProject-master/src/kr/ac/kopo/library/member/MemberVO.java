package kr.ac.kopo.library.member;

public class MemberVO {
	private String userId;
	private String name;
	private String email;
	private String password;
	private String phoneNum;
	private int borrowCnt; // 현재 사용자가 대출중인 도서 개수
	
	public MemberVO() {
		
		borrowCnt = 0;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getBorrowCnt() {
		return borrowCnt;
	}
	public void setBorrowCnt(int cnt) {
		this.borrowCnt = cnt;
	}
	
	public void plusBorrowCnt() {	
		this.borrowCnt++;
	}

	public void minusBorrowCnt() {	
		this.borrowCnt--;
	}
}

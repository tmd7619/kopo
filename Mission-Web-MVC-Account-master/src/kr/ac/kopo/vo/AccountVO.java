package kr.ac.kopo.vo;

public class AccountVO {
	private String userId ; // 현재 user id
	private String no; // 계좌번호
	private int password;  // 패스워드 숫자 4자리
	private String holder; // 예금주
	private int balance; // 잔액
	private String nickName; // 계좌별칭
	private String regDate; // 계좌 생성일
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "AccountVO [userId=" + userId + ", accountNo=" + no + ", password=" + password + ", holder="
				+ holder + ", balance=" + balance + ", nickName=" + nickName + ", regDate=" + regDate + "]";
	}
	
	
	
	
	
	
}

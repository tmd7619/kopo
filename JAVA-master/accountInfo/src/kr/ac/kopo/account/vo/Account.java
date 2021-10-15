package kr.ac.kopo.account.vo;

public class Account {
	
	private String account ; // 계좌번호
	private String bankName; // 은행명
	private String customerName; // 계좌주명
	private String balance; // 잔액
	private String nickname; // 별칭
	private String credate; // 개설날짜
	private String customerID; // 고객 아이디
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCredate() {
		return credate;
	}
	public void setCredate(String credate) {
		this.credate = credate;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	@Override
	public String toString() {
		return "InfoVO [account=" + account + ", bankName=" + bankName + ", customerName=" + customerName + ", balance="
				+ balance + ", nickname=" + nickname + ", credate=" + credate + ", customerID=" + customerID + "]";
	}
	
	

}

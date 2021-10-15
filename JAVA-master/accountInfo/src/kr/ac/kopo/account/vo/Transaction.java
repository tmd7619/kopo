package kr.ac.kopo.account.vo;

public class Transaction { // 거래내역 VO
	
	private String tranId; // 거래일련번호
	private String tranAccount; // 거래 계좌
	private String tranType;	// 거래 타입 // 입금/출금/계좌이체출금/계좌이체입금
	private String tranAmount;  // 거래금액
	private String tranDate;    // 거래일
	private String tranBalance; // 잔액 
	private String tranBankname; // 거래 은행 
	
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	
	public String getTranAccount() {
		return tranAccount;
	}
	public void setTranAccount(String tranAccount) {
		this.tranAccount = tranAccount;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(String tranAmount) {
		this.tranAmount = tranAmount;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getTranBalance() {
		return tranBalance;
	}
	public void setTranBalance(String tranBalance) {
		this.tranBalance = tranBalance;
	}
	public String getTranBankname() {
		return tranBankname;
	}
	public void setTranBankname(String tranBankname) {
		this.tranBankname = tranBankname;
	}
	@Override
	public String toString() {
		return "TransactionVO [tranId=" + tranId + ", tranAccount=" + tranAccount + ", tranType=" + tranType
				+ ", tranAmount=" + tranAmount + ", tranDate=" + tranDate + ", tranBalance=" + tranBalance
				+ ", tranBankname=" + tranBankname + "]";
	}
	

	
	

}

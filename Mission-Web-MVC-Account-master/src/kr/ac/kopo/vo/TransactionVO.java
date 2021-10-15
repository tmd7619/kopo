package kr.ac.kopo.vo;

public class TransactionVO {

	private int tranIdx; // 거래일련번호
	private String tranMyAccount; // 내 계좌 번혼
	private String tranAccount; // 상대 계좌 번호
	private String tranType;	// 거래 타입 // 입금/출금/계좌이체출금/계좌이체입금
	private int tranAmount;  // 거래금액
	private String tranDate;    // 거래일
	private int tranBalance; // 거래 후 잔액 (내꺼)
	private String tranBankname; // 거래 은행 
	private String tranHolder ; // 예금주명 (상대방)
	
	public int getTranIdx() {
		return tranIdx;
	}
	public void setTranIdx(int tranIdx) {
		this.tranIdx = tranIdx;
	}
	public String getTranMyAccount() {
		return tranMyAccount;
	}
	public void setTranMyAccount(String tranMyAccount) {
		this.tranMyAccount = tranMyAccount;
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
	public int getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(int tranAmount) {
		this.tranAmount = tranAmount;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public int getTranBalance() {
		return tranBalance;
	}
	public void setTranBalance(int tranBalance) {
		this.tranBalance = tranBalance;
	}
	public String getTranBankname() {
		return tranBankname;
	}
	public void setTranBankname(String tranBankname) {
		this.tranBankname = tranBankname;
	}
	
	public String getTranHolder() {
		return tranHolder;
	}
	public void setTranHolder(String tranHolder) {
		this.tranHolder = tranHolder;
	}
	
	@Override
	public String toString() {
		return "TransactionVO [tranIdx=" + tranIdx + ", tranMyAccount=" + tranMyAccount + ", tranAccount=" + tranAccount
				+ ", tranType=" + tranType + ", tranAmount=" + tranAmount + ", tranDate=" + tranDate + ", tranBalance="
				+ tranBalance + ", tranBankname=" + tranBankname + ", tranHolder=" + tranHolder + "]";
	}
	
	
	
	
	
}

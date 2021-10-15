package kr.ac.kopo.account.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.account.ui.AccountBaseUI;
import kr.ac.kopo.account.vo.Account;
import kr.ac.kopo.account.vo.Transaction;
import kr.ac.kopo.customer.ui.CustomerBaseUI;

public class AccountService {

	private AccountDAO adao;

	public AccountService() {

		adao = new AccountDAO();

	}

	public List<Account> searchAll() throws Exception { // 전체 계좌 조회

		List<Account> list = adao.searchAll();

		return list;

	}

	public List<Account> searchBank(String bankName) throws Exception { // 은행별 계좌 조회

		List<Account> list = adao.searchBank(bankName);

		return list;

	}

	public Account searchAccount(String accountNum) throws Exception  { // 계좌번호로 게좌 조회
		Account accountInfo = null;
		
		accountInfo = adao.searchAccount(accountNum);
		
		return accountInfo;

	}

	public void updateNickname(String nicknameAccountNum, String nickname) throws Exception { // 별칭 등록 및 수정
		
		while (true) {	
			boolean bool = adao.updateNickname(nicknameAccountNum, nickname);
			if(bool) {
				System.out.println(AccountBaseUI.getCurrentAccount().getAccount()+" 계좌의 별칭을 " + nickname+"으로 설정하였습니다.");
				break;
			}else {
				System.out.println("별칭을 설정하는데 실패하였습니다. 다시 시도해주세요.");
			}
			
			
		}
		
		
	}

	public void deposit(String amount, String accountNum) throws Exception { // 계좌 입금
		while (true) {
			
		int check = adao.deposit(amount, accountNum);
		
		Account accountCheck = adao.searchAccount(accountNum);
		AccountBaseUI.setCurrentAccount(accountCheck); // 입력한 accountNum의 계좌정보 static 변수에 저장
		if (check == 1) {
			System.out.println("\t정상적으로 입금이 완료되었습니다. 현재 잔액은 "+AccountBaseUI.getCurrentAccount().getBalance()+"원입니다 ");
			break;
		} else {
			System.out.println("\t입금이 정상적으로 완료되지 않았습니다. 다시 시도해주세요.");
			break;
		}
		}

	}

	public void withdraw(String amount, String accountNum) throws Exception { // 계좌 출금
		while (true) {

		int check = adao.withdraw(amount, accountNum);
		
		Account accountCheck = adao.searchAccount(accountNum);
		AccountBaseUI.setCurrentAccount(accountCheck); // 입력한 accountNum의 계좌정보 static 변수에 저장
		if (check == 1) {
			System.out.println("\t정상적으로 출금이 완료되었습니다. 현재 잔액은 "+AccountBaseUI.getCurrentAccount().getBalance()+"원입니다");
			break;
		} else {
			System.out.println("\t출금이 정상적으로 완료되지 않았습니다. 다시 시도해주세요.");
			break;
		}
		}
		
	}

	public Account openAccount(Account newAccount) throws Exception { // 계좌 생성

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		Account na = null;
		Random r = new Random();
		String newAccountNum = null; // 난수가 저장될 변수

		while (true) {

			// 계좌번호 중복체크
			newAccountNum = "1"; // 계좌번호는 1부터 시작함

			for (int i = 0; i < 13; i++) {

				if (i == 3 || i == 7) {
					newAccountNum += "-";
					continue;
				}
				newAccountNum += r.nextInt(10);
			}

			String check = adao.overlapCheck(newAccountNum);

			if (check != null)
				continue; // 생성된 난수가, 이미 존재할때 위 과정을 다시 반복

			// 한달안에 계좌를 생성했는지 확인하는 과정
			String latelyDate = adao.compareDate(); // 가장 최근에 계좌 생성한 날짜
			if (latelyDate == null) {
				System.out.println("\t" + CustomerBaseUI.getCustomer().getName() + "님은 신규계좌로 등록가능하십니다.");
				newAccount.setAccount(newAccountNum);
				na = adao.openAccount(newAccount);
				break;
			}

			Date ld = sdf.parse(latelyDate); // Date형으로 변환
			Date currentTime = new Date(); // 현재 날짜

			cal.setTime(ld);
			cal.add(Calendar.DATE, 30); // 최근에 생성한 계좌날짜에 30일을 더해줌

			int compare = ld.compareTo(currentTime); // 현재날짜와 30일 더한 생성날짜와 비교

			if (compare < 0) { // 0보다 작으면, 30일 더한생성날짜 < 현재날짜
				System.out.println("아직 계좌 개설 후, 1달이 경과하지 않았습니다. 다음에 이용해주세요.");
				break;
			} else { // 0보다 크면, 30일 더한 생성날짜 > 현재날짜

				System.out.println(CustomerBaseUI.getCustomer().getName() + "님은 개설한지 한달이 넘었기에, 계좌개설이 가능합니다.");
				newAccount.setAccount(newAccountNum);
				newAccount.setCustomerName(CustomerBaseUI.getCustomer().getName()); // 예금주 정보 저장
				na = adao.openAccount(newAccount);
				break;
			}

		}
		return na;
	}

	public void deleteAccount(String deleteAccountNum) throws Exception { // 계좌 해지

		Account accountCheck = adao.searchAccount(deleteAccountNum);
		AccountBaseUI.setCurrentAccount(accountCheck); // 입력한 accountNum의 계좌정보 static 변수에 저장
		while (true) {
			
			boolean bool = adao.deleteAccount(deleteAccountNum);
			
			if(bool) {
				System.out.println(AccountBaseUI.getCurrentAccount().getAccount()+" 계좌를 정상적으로 해지하였습니다. 그동안 이용해주셔서 감사합니다.");
				break;
			}else {
				System.out.println("계좌를 해지하는데 실패하였습니다. 다시 시도해주세요.");
			}
			
			
		}
	}

	public void transferAccount(String senderAccountNum, String receiverBankName, String receiverAccountNum,
			String transferAmount) throws Exception { // 계좌 이체
		
			adao.transferAccount(senderAccountNum, receiverBankName, receiverAccountNum, transferAmount);
	}

	public List<Transaction> searchTransaction() { // 거래내역 조회

		List<Transaction> list = adao.searchTransaction();

		return list;
	}

	
	public boolean checkBalance(String senderAccountNum, String transferAmount ) throws Exception { // 잔액조회
		
		boolean chb = adao.checkBalance(senderAccountNum, transferAmount);
		
		return chb;
		
	}
	public Account searchOtderAccount(String receiverAccountNum) {
		
		
		Account account = adao.searchOtderAccount(receiverAccountNum);
		
		return account;
		
	}
	
	
}

package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.Account;
import kr.ac.kopo.customer.ui.CustomerBaseUI;

public class SearchAccountUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {
		while (true) {
			System.out.println("================================================");
			System.out.println("\t" + CustomerBaseUI.getCustomer().getName() + "님의 계좌번호로 계좌 조회하기");
			System.out.println("================================================");
			String accountNum = scanStr("\t조회하실 계좌번호를 입력해주세요 : ");

			Account accountInfo = aservice.searchAccount(accountNum);
			if(accountInfo.getAccount() != null ) {
				System.out.println("\t" + accountNum + "의 계좌정보");
				System.out.println("은행명\t계좌번호\t\t별칭\t예금액\t\t예금주\t계좌생성날짜");
				System.out.println(accountInfo.getBankName()+"\t"+accountInfo.getAccount()
							+"\t"+accountInfo.getNickname()+"\t"+accountInfo.getBalance()+"\t"+accountInfo.getCustomerName()
							+"\t"+accountInfo.getCredate());
				break;
			}else {
				System.out.println("\t잘못된 계좌정보입니다. 다시 입력해주세요.");
			}
			
		}

	}
	
}

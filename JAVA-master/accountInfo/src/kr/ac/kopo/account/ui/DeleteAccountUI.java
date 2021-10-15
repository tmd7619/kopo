package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.Account;
import kr.ac.kopo.customer.ui.CustomerBaseUI;

public class DeleteAccountUI extends AccountBaseUI{ // 계좌 해지

	@Override
	public void execute() throws Exception {
		
		
		System.out.println("================================================");
		System.out.println("\t" + CustomerBaseUI.getCustomer().getName() + "님의 계좌 해지하기");
		System.out.println("================================================");
		
		while (true) {
			String deleteAccountNum = scanStr("\t해지하실 계좌번호를 입력해주세요 : ");
			Account accountCheck = aservice.searchAccount(deleteAccountNum);
			if (accountCheck.getAccount()== null) {
				System.out.println("\t잘못된 계좌정보입니다. 다시 입력해주세요.");
				System.out.println();
				continue;
			}
			aservice.deleteAccount(deleteAccountNum);
			break;

		}
		
		

		
		
		
	}

}

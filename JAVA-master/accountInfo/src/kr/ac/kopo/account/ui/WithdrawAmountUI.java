package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.Account;
import kr.ac.kopo.customer.ui.CustomerBaseUI;

public class WithdrawAmountUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("================================================");
		System.out.println("\t" + CustomerBaseUI.getCustomer().getName() + "님의 출금하기");
		System.out.println("================================================");

		while (true) {
			String accountNum = scanStr("\t출금하실 계좌번호를 입력해주세요 : ");

			Account accountCheck = aservice.searchAccount(accountNum);
			if (accountCheck.getAccount()== null) {
				System.out.println("\t잘못된 계좌정보입니다. 다시 입력해주세요.");
				System.out.println();
				continue;
			}
			
			String amount = scanStr("\t출금하실 금액을 입력해주세요. : ");
			aservice.withdraw(amount, accountNum);
			break;

		}

	}

}

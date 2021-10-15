package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.Account;
import kr.ac.kopo.customer.ui.CustomerBaseUI;

public class TransferAmountUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("================================================");
		System.out.println("\t" + CustomerBaseUI.getCustomer().getName() + "님의 계좌 이체하기");
		System.out.println("================================================");
		String senderAccountNum = null;
		String receiverBankName = null;
		String receiverAccountNum = null;
		String transferAmount = null; // 이체 금액
		loop1: while (true) {
			while (true) {
				senderAccountNum = scanStr("\t이체할 본인의 계좌번호를 입력해주세요 : ");
				Account accountCheck = aservice.searchAccount(senderAccountNum);
				if (accountCheck.getAccount() == null) {
					System.out.println("\t잘못된 계좌정보입니다. 다시 입력해주세요.");
					System.out.println();
					continue;
				} else
					break;
			}
			while (true) {
				receiverAccountNum = scanStr("\t이체할 상대방의 계좌번호를 입력해주세요 : ");
				Account accountCheck = aservice.searchOtderAccount(receiverAccountNum);
				if (accountCheck.getAccount() == null) {
					System.out.println("\t잘못된 타인 계좌정보입니다. 다시 입력해주세요.");
					System.out.println();
					continue;
				} else if (receiverAccountNum.equals(senderAccountNum)) {
					System.out.println("\t본인의 계좌번호입니다. 타인의 계좌번호를 입력해주세요.");
					System.out.println();
				} else
					break;
			}

			while (true) {
					receiverBankName = scanStr("\t이체할 상대방의 은행명을 입력해주세요 : ");
					Account account = aservice.searchOtderAccount(receiverAccountNum);
					if (account.getBankName() == null) {
						System.out.println("\t잘못된 은행명입니다. 다시 입력해주세요.");
						System.out.println();
						continue;
					} else
						break;
			}


			while (true) {
				transferAmount = scanStr("\t이체할 금액을 입력해주세요 : ");
				boolean checkBalance = aservice.checkBalance(senderAccountNum, transferAmount);
				if (checkBalance == false) {
					System.out.println("\t잔액이 부족합니다. 다른 계좌를 이용해주세요.");
					System.out.println();
					continue loop1;
				} else
					break;

			}

			aservice.transferAccount(senderAccountNum, receiverBankName, receiverAccountNum, transferAmount);

			System.out.println("\t정상적으로 " + transferAmount + "원이 송금되었습니다.");
			break;
		}
	}

}

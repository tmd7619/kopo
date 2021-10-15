package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.Account;
import kr.ac.kopo.customer.ui.CustomerBaseUI;

public class UpdateNicknameUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {

		System.out.println("================================================");
		System.out.println("\t" + CustomerBaseUI.getCustomer().getName() + "님의 계좌별칭 지정하기");
		System.out.println("================================================");

		while (true) {
			String nicknameAccountNum = scanStr("\t별칭을 설정할 계좌번호를 입력해주세요 : ");

			Account accountCheck = aservice.searchAccount(nicknameAccountNum);
			if (accountCheck.getAccount() == null) {
				System.out.println("\t잘못된 계좌정보입니다. 다시 입력해주세요.");
				System.out.println();
				continue;
			} else {
				AccountBaseUI.setCurrentAccount(accountCheck);
				String nickname = scanStr("\t별칭을 입력해주세요 : ");
				aservice.updateNickname(nicknameAccountNum, nickname);
				break;
			}
		}

	}

}

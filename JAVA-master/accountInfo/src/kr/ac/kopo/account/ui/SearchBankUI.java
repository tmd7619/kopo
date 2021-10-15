package kr.ac.kopo.account.ui;

import java.util.List;

import kr.ac.kopo.account.vo.Account;
import kr.ac.kopo.customer.ui.CustomerBaseUI;

public class SearchBankUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {

		while (true) {
			System.out.println("================================================");
			System.out.println("\t" + CustomerBaseUI.getCustomer().getName() + "님의 은행별 계좌 조회하기");
			System.out.println("================================================");
			String bankName = scanStr("\t조회하실 은행명을 입력해주세요 ex)xx은행 : ");

			List<Account> list = aservice.searchBank(bankName);

			if (list.size() == 0) {
				System.out.println("\t" + bankName + "에는 조회할 수 있는 계좌가 없습니다.");
			} else {
				System.out.println("\t" + bankName + "의 계좌 리스트");
				System.out.println("별칭\t계좌번호\t\t예금액\t\t계좌생성날짜");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getNickname() + "\t" + list.get(i).getAccount() + "\t"
							+ list.get(i).getBalance() + "\t" + list.get(i).getCredate());
				}
				break;
			}
		}
	}

}

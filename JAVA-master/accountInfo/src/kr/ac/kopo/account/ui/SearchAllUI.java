package kr.ac.kopo.account.ui;

import java.util.List;

import kr.ac.kopo.account.vo.Account;
import kr.ac.kopo.customer.ui.CustomerBaseUI;

public class SearchAllUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {

		List<Account> list = aservice.searchAll();

		System.out.println("================================================");
		System.out.println("\t" + CustomerBaseUI.getCustomer().getName() + "님의 전체 계좌 조회하기");
		System.out.println("================================================");
		
		System.out.println("\t하나은행 계좌 정보");
		if (list.size() == 0) {
			System.out.println("\t조회할 계좌가 없습니다.");

		} else {
			System.out.println("별칭\t계좌번호\t\t예금액\t계좌생성날짜");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getBankName().equals("하나은행")) {
					System.out.println(list.get(i).getNickname() + "\t" + list.get(i).getAccount() + "\t"
							+list.get(i).getBalance()+ "\t" + list.get(i).getCredate());
				}
			}
		}
		System.out.println("================================================");
		System.out.println("\t국민은행 계좌 정보");
		if (list.size() == 0) {
			System.out.println("\t조회할 계좌가 없습니다.");

		} else {
			System.out.println("별칭\t계좌번호\t\t예금액\t계좌생성날짜");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getBankName().equals("국민은행")) {
					System.out.println(list.get(i).getNickname() + "\t" + list.get(i).getAccount() + "\t"
							+ list.get(i).getBalance() + "\t" + list.get(i).getCredate());
				}
			}
		}
		
		System.out.println("================================================");
		System.out.println("\t기업은행 계좌 정보");
		if (list.size() == 0) {
			System.out.println("\t조회할 계좌가 없습니다.");

		} else {
			System.out.println("별칭\t계좌번호\t\t예금액\t계좌생성날짜");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getBankName().equals("기업은행")) {
					System.out.println(list.get(i).getNickname() + "\t" + list.get(i).getAccount() + "\t"
							+ list.get(i).getBalance() + "\t" + list.get(i).getCredate());
				}
			}
		}
		
		System.out.println("================================================");
		System.out.println("\t신한은행 계좌 정보");
		if (list.size() == 0) {
			System.out.println("\t조회할 계좌가 없습니다.");

		} else {
			System.out.println("별칭\t계좌번호\t\t예금액\t계좌생성날짜");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getBankName().equals("신한은행")) {
					System.out.println(list.get(i).getNickname() + "\t" + list.get(i).getAccount() + "\t"
							+list.get(i).getBalance() + "\t" + list.get(i).getCredate());
				}
			}
		}
		
		System.out.println("================================================");
		System.out.println("\t우리은행 계좌 정보");
		if (list.size() == 0) {
			System.out.println("\t조회할 계좌가 없습니다.");

		} else {
			System.out.println("별칭\t계좌번호\t\t예금액\t계좌생성날짜");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getBankName().equals("우리은행")) {
					System.out.println(list.get(i).getNickname() + "\t" + list.get(i).getAccount() + "\t"
							+ list.get(i).getBalance() + "\t" + list.get(i).getCredate());
				}
			}
		}
		
	}

}

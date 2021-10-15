package kr.ac.kopo.account.ui;

import java.util.List;

import kr.ac.kopo.account.vo.Transaction;
import kr.ac.kopo.customer.ui.CustomerBaseUI;

public class SearchTransactionUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {
		int i = 1;
		System.out.println("==========================================================================================");
		System.out.println("\t" + CustomerBaseUI.getCustomer().getName() + "님의 거래내역 조회하기");
		System.out.println("==========================================================================================");

		List<Transaction> list = aservice.searchTransaction();
		
		i = list.size() ;
		
		if (list.size() == 0) {
			System.out.println("\t거래내역이 존재하지 않습니다.");
		} else {

			System.out.println("\t거래번호\t은행명\t계좌번호\t\t\t거래유형\t거래금액\t잔액\t\t거래날짜");
			for (Transaction tran : list) {
				System.out.println("\t"+i+"\t"+tran.getTranBankname()+"\t"+tran.getTranAccount()
						+"\t\t"+tran.getTranType()+"\t"+tran.getTranAmount()+"\t"+tran.getTranBalance()+"\t"+tran.getTranDate());
				i--;
			}
		}

	}

}
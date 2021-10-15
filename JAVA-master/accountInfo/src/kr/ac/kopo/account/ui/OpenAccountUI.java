package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.Account;
import kr.ac.kopo.customer.ui.CustomerBaseUI;

public class OpenAccountUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {
		Account na = null;
		
		System.out.println("================================================");
		System.out.println("\t" + CustomerBaseUI.getCustomer().getName() + "님의 계좌 개설하기");
		System.out.println("================================================");
		while(true) {
			
		String bankName = scanStr("\t개설하실 은행명을 입력하세요 : ");
		if( ! (bankName.equals("하나은행")  || bankName.equals("국민은행") || bankName.equals("기업은행")        
				|| bankName.equals("신한은행") || bankName.equals("우리은행")) ){
			System.out.println("\t잘못된 은행명입니다. 다시 입력해주세요");
			System.out.println();
			continue;
		}
		
		
		String nickName = scanStr("\t계좌 별칭을 지정해주세요(생략가능) :");	
		
		Account newAccount = new Account();
		newAccount.setBankName(bankName);
		newAccount.setNickname(nickName);
		
		na = aservice.openAccount(newAccount); // 생성된 계좌정보 객체
		System.out.println("================================================");
		System.out.println("================================================");
		System.out.println("================================================");
		
		System.out.println("\t계좌번호 : "+na.getAccount());
		System.out.println("\t은행명 : "+na.getBankName());
		System.out.println("\t예금주 : "+CustomerBaseUI.getCustomer().getName());
		System.out.println("\t계좌 개설이 정상적으로 완료되었습니다.");
		break;
		
	}
}

}

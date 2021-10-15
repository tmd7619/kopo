package kr.ac.kopo.customer.ui;

import kr.ac.kopo.customer.vo.Customer;

public class LoginUI extends CustomerBaseUI {

	@Override
	public void execute() throws Exception {
	
		Customer customer = null;
		while (true) {
			System.out.println("================================================");
			String id = scanStr("\t아이디를 입력하세요 : ");
			String pwd = scanStr("\t패스워드를 입력하세요 : ");

			customer = cservice.login(id, pwd);

			if (customer == null) {
				System.out.println("\t잘못된 로그인 정보입니다. 다시입력하세요.");

			} else {
				System.out.println("\t"+customer.getId()+"님 환영합니다!");
				CustomerBaseUI.setCustomer(customer); // static 변수에 현재 로그인 정보 저장
				break;
			}

		}
		
		
	}

}

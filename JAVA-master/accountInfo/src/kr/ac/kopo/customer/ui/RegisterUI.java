package kr.ac.kopo.customer.ui;

import kr.ac.kopo.customer.vo.Customer;
import kr.ac.kopo.ui.BaseUI;

public class RegisterUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		String id;
		System.out.println("================================================");
		System.out.println("\t 회원가입을 시작하겠습니다.");
		System.out.println("================================================");
		
		while(true) {
		id = scanStr("\t아이디를 입력하세요 : ");
	
		if(cservice.overlapCheck(id) == null) {
			break;
		
		}else {
			System.out.println("\t중복된 아이디입니다. 다시 입력하세요");
		}
		
		}
		
		while(true) {
			String pwd = scanStr("\t비밀번호를 입력하세요 : ");
			String name = scanStr("\t이름을 입력하세요 : ");
			String birth = scanStr("\t생년월일을 입력하세요 ex)951126 : ");
			
			Customer newCustomer = new Customer(id,pwd,name,birth);
			
			cservice.register(newCustomer);
			break;
		}
		
		
		
	}

}

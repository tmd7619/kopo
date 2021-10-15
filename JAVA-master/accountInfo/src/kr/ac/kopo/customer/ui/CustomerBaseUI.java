package kr.ac.kopo.customer.ui;

import kr.ac.kopo.customer.vo.Customer;
import kr.ac.kopo.ui.BaseUI;


/*
 *	// 현재 로그인된 정보를 저장하는 클래스 
 */

public abstract class CustomerBaseUI extends BaseUI {
	
	private static Customer ccustomer ;

	public static Customer getCustomer() {
		return ccustomer;
	}

	public static void setCustomer(Customer customer) {
		CustomerBaseUI.ccustomer = customer;
	}
	
	
	

}

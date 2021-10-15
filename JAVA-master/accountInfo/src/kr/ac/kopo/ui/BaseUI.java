package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.account.service.AccountServiceFactory;
import kr.ac.kopo.customer.service.CustomerService;
import kr.ac.kopo.customer.service.CustomerServiceFactory;


public abstract class BaseUI implements IAccountUI {
	
	
	private Scanner sc ;
	protected CustomerService cservice;
	protected AccountService aservice;
	
	
	public BaseUI() {
		sc = new Scanner(System.in);
		cservice = CustomerServiceFactory.getInstance();
		aservice = AccountServiceFactory.getInstance() ;
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;	
	}
	
	protected int scanInt(String msg ) {
		int num = Integer.parseInt(scanStr(msg));
		return num;
		
	}


}

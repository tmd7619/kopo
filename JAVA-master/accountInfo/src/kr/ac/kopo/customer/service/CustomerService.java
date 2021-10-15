package kr.ac.kopo.customer.service;

import kr.ac.kopo.customer.dao.CustomerDAO;
import kr.ac.kopo.customer.vo.Customer;

public class CustomerService {

	private CustomerDAO cdao;

	public CustomerService() {

		cdao = new CustomerDAO();

	}

	public Customer login(String id, String pwd) throws Exception { // 로그인

		Customer customer = cdao.login(id, pwd);

		return customer;
	}

	public Customer overlapCheck(String id) throws Exception { // 아이디 중복 체크 메서드

		Customer customer = cdao.overlapCheck(id);
		return customer;

	}

	public void register(Customer newCustomer) throws Exception{ // 회원가입
		
		cdao.register(newCustomer);
		
	}


}

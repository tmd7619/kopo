package kr.ac.kopo.customer.service;

public class CustomerServiceFactory {

	private static final CustomerService service = new CustomerService(); 
	
	public static CustomerService getInstance() {
		
		return service;
	}
	
}

package kr.ac.kopo.ui;

public class AccountMain {
	
	public static void main(String[] args) {
		
		AccountUI ui = new AccountUI() ; 
		try {
			ui.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

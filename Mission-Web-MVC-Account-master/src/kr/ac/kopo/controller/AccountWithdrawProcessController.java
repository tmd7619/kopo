package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.AccountDAO;
import kr.ac.kopo.vo.AccountVO;

public class AccountWithdrawProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");

		
		// 내정보 가져오기
		String accountNo = request.getParameter("myAccountNo"); // 내 계좌번호
		int password = Integer.parseInt(request.getParameter("myPassword")); // 내 계좌 비밀번호
		
		System.out.println(accountNo);
		System.out.println(password);
		
		
		// 출금 금액
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		System.out.println(amount);
		
		// 내정보 저장
		AccountVO Account = new AccountVO();
		Account.setNo(accountNo);
		Account.setPassword(password);
		
		// dao 호출
		AccountDAO dao = new AccountDAO();
		
		boolean check = dao.withdraw(Account, amount);
		
		String url = "";
		
		if(check) { // 정상적으로 출금이 되었을 경우,
			
			url = "redirect:/";
		} else { // 출금 실패
			
			url = "redirect:/account/withdrawProcess.do" ;
		}
				
		return url;
		
	}

}

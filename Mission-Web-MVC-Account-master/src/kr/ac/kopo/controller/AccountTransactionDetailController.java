package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.TransactionDAO;
import kr.ac.kopo.vo.TransactionVO;

public class AccountTransactionDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String accountNo = request.getParameter("accountNo");
		
		System.out.println("거래내역 조회할 계좌번호 :" + accountNo);
		
		TransactionDAO dao = new TransactionDAO();
		
		List<TransactionVO>list =  dao.selectByAccountNo(accountNo);
		
		request.setAttribute("list", list);
		
		
		return "/account/transactionDetail.jsp?accountNo=" + accountNo;
	}

}

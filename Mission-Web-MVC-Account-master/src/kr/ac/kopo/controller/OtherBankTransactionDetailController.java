package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.TransactionDAO;
import kr.ac.kopo.vo.TransactionVO;

public class OtherBankTransactionDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String accountNo = request.getParameter("accountNo");
		
		TransactionDAO dao = new TransactionDAO();
		List<TransactionVO> list = dao.selectByOtherBank(accountNo);
		
		request.setAttribute("list", list);
		
		return "/account/otherBankTransactionDetail.jsp?accountNo=" + accountNo;
	}

}

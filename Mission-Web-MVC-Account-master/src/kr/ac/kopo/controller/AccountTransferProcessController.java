package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.AccountDAO;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.TransactionVO;

public class AccountTransferProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		
		// 내정보 가져오기
		String myAccountNo = request.getParameter("myAccountNo"); // 내 계좌번호
		int myPassword = Integer.parseInt(request.getParameter("myPassword")); // 내 계좌 비밀번호
		
		// 이체 금액
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		// 내정보 저장
		AccountVO myAccount = new AccountVO();
		myAccount.setNo(myAccountNo);
		myAccount.setPassword(myPassword);
		
		System.out.println(myAccountNo);
		System.out.println(myPassword);
		System.out.println(amount);
		
		
		
		// 상대방 정보 가져오기
		String receiverAccountNo = request.getParameter("receiverAccountNo"); // 상대방 계좌번호
		String bankName = request.getParameter("bankName"); // 상대방 은행
		String receiver = request.getParameter("receiver"); // 예금주명
		
		
		System.out.println(receiverAccountNo);
		System.out.println(bankName);
		System.out.println(receiver);
		
		// 상대방 정보 저장
		TransactionVO receiverAccount = new TransactionVO();
		receiverAccount.setTranAccount(receiverAccountNo);
		receiverAccount.setTranBankname(bankName);
		receiverAccount.setTranHolder(receiver); 
		
		// dao 호출
		AccountDAO dao = new AccountDAO();
		
		boolean check = dao.transfer(myAccount, amount, receiverAccount);
		
		String url = "";
		
		if(check) { // 정상적으로 이체가 되었을 경우,
			
			url = "redirect:/kakaoMessageTrasaction.do";
		} else { // 이체 실패
			
			url = "redirect:/";
			/* url = "redirect:/account/transactionProcess.do" ; */
			
		}
		
		return url;
	}

}

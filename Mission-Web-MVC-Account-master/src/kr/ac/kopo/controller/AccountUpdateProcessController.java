package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.AccountDAO;

public class AccountUpdateProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String newNickName = request.getParameter("newNickName");
		String accountNo = request.getParameter("accountNo");
		
		AccountDAO dao = new AccountDAO();
		
		dao.update(newNickName, accountNo);
		
		
		return "redirect:/account/list.do";
	}

}

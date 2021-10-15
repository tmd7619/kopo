package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountUpdateFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String accountNo = request.getParameter("accountNo");
		String nickName = request.getParameter("nickName");
		
		return "/account/updateForm.jsp?accountNo="+accountNo+"&nickname="+nickName; // do가 아닌 jsp로 forward !! 
	}

}

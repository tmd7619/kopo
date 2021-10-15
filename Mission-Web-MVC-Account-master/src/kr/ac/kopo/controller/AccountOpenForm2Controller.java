package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.vo.MemberVO;

public class AccountOpenForm2Controller implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(); // 세션 객체 생성 
		MemberVO userVO = (MemberVO)session.getAttribute("userVO"); // 현재 로그인 정보 불러오기
		
		String id = request.getParameter("id"); // 입력한 아이디
		String password = request.getParameter("password"); // 입력한 비밀번호
		
		String url = "";
		
		if(userVO.getId().equals(id) && userVO.getPassword().equals(password)) { // 입력한 정보가 맞으면,
			
			url = "/account/openAccountForm2.jsp"; // 다음 단계 이동
		} else {
			
			url = "/account/openAccountForm.jsp"; // 틀리면 다시 시도
		}
		
		return url;
	}

}

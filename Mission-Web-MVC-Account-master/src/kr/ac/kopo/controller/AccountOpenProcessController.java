package kr.ac.kopo.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.AccountDAO;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;

public class AccountOpenProcessController implements Controller {

	String newAccountNum = "";
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberVO userVO = (MemberVO)session.getAttribute("userVO");
		
		String nickName = request.getParameter("nickname");
		int password = Integer.parseInt(request.getParameter("password"));
		
		if(nickName == null) { // 계좌 별칭 null값 처리
			
			nickName = "별칭미설정";
		}
		
		
		
		// 계좌번호 생성
		Random r = new Random();
		 newAccountNum = "032"; // 
	
		for (int i = 3; i < 13; i++) { // 032-xxx-xxxxx
			
			if (i == 3 || i == 7) {
				newAccountNum += "-";
				continue;
			}
			newAccountNum += r.nextInt(10);
		}
		
		//System.out.println(newAccountNum);
		
		AccountVO accountVO = new AccountVO();
		
		accountVO.setNo(newAccountNum);
		accountVO.setPassword(password);
		accountVO.setNickName(nickName);
		
		AccountDAO dao = new AccountDAO();
		
		dao.openAccount(userVO, accountVO);
		
		return "redirect:/account/list.do";
	}

}

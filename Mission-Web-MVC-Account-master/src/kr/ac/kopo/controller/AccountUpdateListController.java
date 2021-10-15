package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.AccountDAO;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;

public class AccountUpdateListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(); // 세션 객체 생성 
		MemberVO userVO = (MemberVO)session.getAttribute("userVO"); // userVO 세션객체 불러오기
		
		String url = "" ;
		if(userVO == null) { // 로그인이 x일때 ,
			//로그인 페이지로 이동
			url	= "redirect:/login.do";
		}else { // 로그인중일 경우
			
			String userId = userVO.getId();
			AccountDAO dao = new AccountDAO();
			List<AccountVO> updateList = dao.selectAll(userId);
			url = "/account/updateList.jsp"; // 계좌수정 페이지로 이동
			
			request.setAttribute("updateList", updateList); // forEach를 위해 list 객체 등록 
		}
		
		return url;
	}

}

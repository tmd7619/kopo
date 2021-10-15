package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("ID : " + id);
		System.out.println("PASSWORD : " + password);
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPassword(password);
		
		MemberDAO dao = new MemberDAO();
		MemberVO userVO = dao.login(memberVO);
		
		String msg = "";
		String url = "";
		if(userVO == null) {
			//로그인 실패
			msg = "아이디 또는 패스워드를 잘못 입력하셨습니다.";
			url	= "redirect:/login.do";
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg); // 세션에 등록하게 되면 ,반드시 다시 지워줘야 하는 작업을 해야함 // loginController.java에서 수행
		}else {
			//로그인 성공
			msg = "로그인에 성공하셨습니다";
			url = "redirect:/"; // index.jsp로 가짐
			
			// 세션 정보 가져오기
			HttpSession session = request.getSession(); // jsp가 아니기 때문에, session 객체를 바로 접근할 수 없음
														// getSession 메소드를 통해 세션 정보를 가져온다.
			// 세션 등록
			session.setAttribute("userVO", userVO);
			
		}
		
		return url;
	}

}

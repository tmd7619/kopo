package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class KakaoLoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String kakaoEmail = request.getParameter("kakao_email");
		
		
		String[] split = kakaoEmail.split(("@")); // @을 기준으로 split // email_ID 값을 ID로 인식  
		
		String kakaoId = split[0]; // id값 저장
		
		
		MemberDAO dao = new MemberDAO();
		
		MemberVO userVO = dao.kakaoLogin(kakaoId);
		
		
		String url = "";
		
		
		if(userVO == null) { // 카카오아이디가 DB에 저장되어 있지 않을 경우, 회원가입으로 이동
			
			url = "redirect:/register.do";
		} else { // 카카오아이디가 DB에 있을 경우, userVO 세션 등록
			
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			url = "redirect:/kakaoMessage.do";
		}
		
		
		return url;
	}
}

package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.MemberDAO;

public class IdOverlapCheckController implements Controller {

	@Override
	   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   
	      request.setCharacterEncoding("utf-8"); // post 방식일경우, 설정하는 인코딩코드
	      
	      String id = request.getParameter("id");
	      
	      MemberDAO dao = new MemberDAO();
	      String temp = dao.idOverlapCheck(id);
	      
	      System.out.println(temp);
	      
	      return "ajax:" + temp; // temp값 send // registerForm.jsp의 data로 넘어감
	      
	   }

}

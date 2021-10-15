package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;

public class BoardUpdateFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int no = Integer.parseInt(request.getParameter("no"));  // no 값 추출
		
		BoardVO board = new BoardVO();
		
		BoardDAO dao = new BoardDAO();
		
		board = dao.getDetail(no); // 현재 게시글 정보를 가져오기 위해 dao.selectByNo 함수 호출
		
		request.setAttribute("board", board); // request 공유 영역에 가져온 board 정보 등록 // forward를 통해 접근이 board. 으로 접근이 가능
		
		
		return "/board/updateForm.jsp";
	}

}

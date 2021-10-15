package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;

public class BoardUpdateProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8"); // post방식 인코딩 !!
		
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVO board = new BoardVO();
		
		board.setTitle(title);
		board.setContent(content);
		board.setNo(no);
		BoardDAO dao = new BoardDAO();
		
		dao.updateBoard(board);
		
		
		return "redirect:/board/detail.do?no="+no; // detail로 다시 돌아가기 
	}

}

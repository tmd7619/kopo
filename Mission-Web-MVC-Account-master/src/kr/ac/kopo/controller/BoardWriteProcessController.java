package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;

public class BoardWriteProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		request.setCharacterEncoding("utf-8"); // post방식 인코딩
		
		BoardVO board = new BoardVO();
		
		BoardDAO dao = new BoardDAO();
		
	    int no = dao.getSeq();
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		board.setNo(no);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
//		board.setBoard_parent(no);
		
		System.out.println(board);
		
		
		dao.insert(board);
		
		
		return "redirect:/board/list.do"; // do 패턴으로 redirect
	}

}

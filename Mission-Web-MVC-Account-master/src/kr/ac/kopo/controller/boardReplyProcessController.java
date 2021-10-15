package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;

public class boardReplyProcessController  implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		request.setCharacterEncoding("utf-8");

		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		
		
        String pageNum = request.getParameter("page");
        System.out.println(pageNum);
        
        
        int no = Integer.parseInt(request.getParameter("no"));
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int ref = Integer.parseInt(request.getParameter("board_re_ref"));

        board.setNo(dao.getSeq());
        board.setWriter(writer);
        board.setTitle(title);
        board.setContent(content);
        board.setBoard_re_ref(ref);
        board.setBoard_parent(no);
        
        System.out.println(board);
        
        
        dao.insert(board);
        
        
		
		return "/board/detail.do?page=" + pageNum;
	}

}

package kr.ac.kopo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;


public class BoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 
		int spage = 1;
        String page = request.getParameter("page");

        if(page != null)
            spage = Integer.parseInt(page);

        BoardDAO dao = new BoardDAO();
        
        
        HashMap<String, Object> listOpt = new HashMap<String, Object>();
        listOpt.put("start", spage*10-9);
        int listCount = dao.getBoardListCount(listOpt);

        // 전체 페이지 수
        int maxPage = (int)(listCount/10.0 + 0.9);
        //시작 페이지 번호
        int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
        //마지막 페이지 번호
        int endPage = startPage + 4;
        if(endPage > maxPage)    endPage = maxPage;
        
        // 4개 페이지번호 저장
        request.setAttribute("spage", spage);
        request.setAttribute("maxPage", maxPage);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);

        
        List<BoardVO> list = dao.selectAll(listOpt);
        
        
		request.setAttribute("list", list);
		
		
		return "/board/list.jsp";
	}
	
	

}

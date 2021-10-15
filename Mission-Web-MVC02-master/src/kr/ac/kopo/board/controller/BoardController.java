package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.framework.ModelAndView;
import kr.ac.kopo.framework.annotation.Controller;
import kr.ac.kopo.framework.annotation.RequestMapping;

@Controller
public class BoardController {
	
	private BoardService service;
	
   @RequestMapping(value="/board/list.do")
   public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   
      System.out.println("리스트 메서드 성공적으로 불러옴");
      
       // 개발자가 직접 비즈니스로직을 수행할 수 있는 dao나 service 객체를 만들지 않고, 서블릿에서 관리하게
	   // 해주기 위해 컨테이너를 사용한다.
      ServletContext sc = request.getServletContext(); // servletContext의 영역에 있는 생성된 객체를 받아오기 위해 sc 객체 생성
      service = (BoardService)sc.getAttribute("boardService"); // boardService 라는 이름의 객체 가져옴 
      
      List<BoardVO> boardList = service.listAll();
      
      
      ModelAndView mav = new ModelAndView();
      mav.setView("/board/list.jsp"); // 응답 화면 저장
      mav.addAttribute("list", boardList); // model에 key="list" , value = boardList 저장
      return mav;
   }
   
   @RequestMapping(value="/board/detail.do")
   public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   System.out.println("디테일 메서드 성공적으로 불러옴");
	   
	   ModelAndView mav = new ModelAndView();
	   mav.setView("board/detail.jsp");
	   
      return mav;
   }
   
   @RequestMapping(value="/board/writeForm.do")
   public ModelAndView writeForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
      System.out.println("게시판 작성 서비스");
      ModelAndView mav = new ModelAndView();
      mav.setView("/board/writeForm.jsp");
      return mav;
   }
   
   @RequestMapping(value="/board/write.do")
   public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   
	  request.setCharacterEncoding("utf-8"); 
	  
	  String title = request.getParameter("title"); 
	  String writer = request.getParameter("writer"); 
	  String content = request.getParameter("content"); 
	  
      ModelAndView mav = new ModelAndView();
      mav.setView("redirect:/board/list.do");
      
      
      return mav;
   }
   
   
   
   

}
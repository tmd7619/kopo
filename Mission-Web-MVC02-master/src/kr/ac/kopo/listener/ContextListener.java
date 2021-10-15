package kr.ac.kopo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.service.BoardService;

public class ContextListener implements ServletContextListener {
		
		// 서버시작 -> listener (처음에 한번 실행됨) -> filter(요청이 올때마다 실행) -> servlet
		// listener : 자원을 공유하기 위해 사용 ( 공통의 일들을 수행) //
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("리스너 시작 .....");
		
		// 리스너 실행시, 객체 생성을 초기에 한번만 하게 됨
		BoardDAO boardDAO = new BoardDAO();
		BoardService boardService = new BoardService(boardDAO); // 생성자패턴으로 boardDAO를 넣어주었기 때문에, dao는 context에 넣을 필요 x
		
		// 생성된 객체들을 서블릿context에 넣어놓고, 필요할때마다 사용 // ServletContext 는 각각의 servlet, controller가 접근할 수 있는 공유영역
		ServletContext context = sce.getServletContext();
		
		context.setAttribute("boardService", boardService);
		
	}
	
	
	
}

package kr.ac.kopo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.controller.HandlerMapping;

public class FrontControllerServlet extends HttpServlet {

	private HandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		
		String propLoc = config.getInitParameter("propertyLocation");
		if(propLoc != null) {
			mappings = new HandlerMapping(propLoc);
			
		} else {
			mappings = new HandlerMapping();
		}
		
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String context = request.getContextPath();
		
		String uri = request.getRequestURI();
		
		uri = uri.substring(context.length()); // 프로젝트 경로를 제외한 나머지 uri 정보를 저장
											   // 요쳥받은 uri 저장 
		
		try {
			
			Controller control = mappings.getController(uri); // 요청받은 uri의 value 값(bean.properties에 있는 kr.ac..../~Controller) control에 저장
															  // 해당 uri를 처리할 Controller mapping 작업
			
			String callPage = control.handleRequest(request, response); // 비즈니스 로직 수행
			
			if(callPage.startsWith("redirect:")) { // sendRedirect 사용
				
				callPage = callPage.substring("redirect:".length());
				
				response.sendRedirect(request.getContextPath() + callPage);
			} else if(callPage.startsWith("ajax:")) { // ajax을 하기 위한 처리
	            callPage = callPage.substring("ajax:".length()); // temp 값만 추출하기 위해 substring
	            
	              response.setContentType("application/x-json; charset=UTF-8");
	              response.getWriter().print(callPage);
	              
	         } else { // forward 사용
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				dispatcher.forward(request, response);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
	}
	
	
	
}

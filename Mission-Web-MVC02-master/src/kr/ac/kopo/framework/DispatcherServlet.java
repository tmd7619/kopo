package kr.ac.kopo.framework;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
//@WebServlet("*.do") // web.xml에 servlet-mapping을 설정해놨을 경우, 주석처리해야 함(아님 에러)
public class DispatcherServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
    private HandlerMapping mappings;
   
   /**
    * @see Servlet#init(ServletConfig)
    */
   public void init(ServletConfig config) throws ServletException {
      String ctrlNames = config.getInitParameter("controllers"); // web.xml에 설정한 param-value를 param-name으로 불러옴
      System.out.println(ctrlNames);
       try {
            mappings = new HandlerMapping(ctrlNames); // 컨트롤러의 name 들을 핸들러하기 위해 HandlerMapping 객체 생성
            
         } catch (Exception e) {
            throw new ServletException(e);
         }
     }

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String uri = request.getRequestURI();
      uri = uri.substring(request.getContextPath().length());
      System.out.println("요청 URI : " + uri);
      
      String view = "";
      
      
      try {
	      CtrlAndMethod cam = mappings.getCtrlAndMethod(uri);
	      
	      if(cam == null) {
	    	  throw new ServletException("해당 URI는 존재하지 않습니다.");
	      }
	      System.out.println("ctrl  : " + cam.getTarget());
	      System.out.println("method : "+ cam.getMethod());
	      
	      Object target = cam.getTarget();
	      Method method = cam.getMethod();
	      
	      /*
	       		/board/list.do 요청
	       		target = new kr.ac.kopo.board.controller.BoardController()
	       		Method method = public String list(HttpServletRequest request, ~ responce) throws Exception ; 
	       		String callPage = target.list(request,responce)
	       */
	      
	      // 컨트롤러의 메서드 리턴 타입이 mav 형태이기에, mav 변수에 저장이 가능함
	      ModelAndView mav = (ModelAndView)method.invoke(target, request, response); // invoke : 동적으로 메소드를 실행하게 해주는 메서드
	      																			 // 메소드 명만으로 동적 실행
	      view = mav.getView(); // 응답화면 정보 저장 
	      
	      // request 공유영역에 등록하기
	      Map<String, Object> model = mav.getModel();
	      Set<String> keys = model.keySet(); // Map객체에 어떤 키값들이 들어오는지 알지 못하기 때문에(여러개가 들어올 경우, 일일히 키값을 입력하여 찾아야함)
	      									 // keySet()으로 키값들을 keys 변수에 담아 관리하기 용이하게 사용함.
	      for(String key : keys) {
	    	  request.setAttribute(key, model.get(key));
	    	  System.out.println("model의 키값 :"  + key);
	      }
      } catch(Exception e){
    	  request.setAttribute("exception", e);
    	  e.printStackTrace();
    	  
      }
      
      // 응답을 위한 JSP 이동, sendRedirect 요청
      if(view.startsWith("redirect:")) {
    	  view = view.substring("redirect:".length());
    	  response.sendRedirect(request.getContextPath() + view); 
    	  // response.sendRedirect(/Mission-Web-MVC02/login.do); // 이런 원리
    	  
      } else {  // forward
    	  RequestDispatcher dispatcher = request.getRequestDispatcher(view);
    	  dispatcher.forward(request, response);
    	  
      }
      
   }

}























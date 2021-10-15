package kr.ac.kopo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MethodServlet extends HttpServlet {
		
	public void doGet(HttpServletRequest request, HttpServletResponse response) // service method
		throws ServletException,IOException{
		
		System.out.println("doGet() 호출.....");
		
		// request 정보 저장
		String id = request.getParameter("id") ; // id라는 name을 가지고 있는 value를 String 변수 id에 저장
		String method = request.getMethod() ;
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI() ;  // uri는 프로토콜,hostname,포트번호를 제외한 나머지 정보 출력하는 것
												// 개발자입장에서 uri를 더 많이 쓰긴함 // url는 사용자 측면 
		
		/*	// request 정보 출력하기
		System.out.println("id : " + id);
		System.out.println("method : " + method);
		System.out.println("url : "+ url.toString() );
		System.out.println("uri : " + uri);
		*/
		
		// client에게 응답
		
		response.setContentType("text/html; charset=utf-8"); // 한글깨짐 방지 
		PrintWriter out = response.getWriter(); // 클라이언트로 내보낼 응답을 작성하기 위해 출력 스트림을 생성 
		out.println("<html>"); // 스트림에 텍스트 작성
		out.println("	<head>");
		out.println("		<title>메소드 호출방식</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("=====================================================<br>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp.요 청 결 과<br>");
		out.println("=====================================================<br>");
		out.println("파라미터(id) : " + id + "<br>");
		out.println("요청방식 : " + method + "<br>");
		out.println("요청 uri : " + uri + "<br>");
		out.println("요청 url : " + url + "<br>");
		out.println("=====================================================<br>");
		out.println("	</body>");
		out.println("</html>");
		
		out.flush();
		out.close(); // 스트림 닫기
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String id = request.getParameter("id");
		
		request.setCharacterEncoding("utf-8"); // post방식일 때 사용해야 한글이 깨지지 않는다.
		
		System.out.println("method : "+ method);
		System.out.println("uri : " + uri);
		System.out.println("id : " + id);
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>메소드 호출 방식 - POST</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("===================================================");
		out.println("&nbsp;&nbsp;&nbsp; 출 력 결 과 <br>");
		out.println("요청 uri : "+ uri + "<br>");
		out.println("요청 메소드 : "+ method + "<br>");
		out.println("파라미터 (id) : "+ id + "<br>");
		out.println("===================================================");
		out.println("===================================================");
		out.println("</body>");
		out.println("</html");
		out.flush();
		out.close();
		
	}
}

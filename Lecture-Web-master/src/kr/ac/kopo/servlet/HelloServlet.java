package kr.ac.kopo.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	
	  @Override public void init(ServletConfig config) throws ServletException { // 없어도 실행은 됨
	  System.out.println("init() : 최초 한번만 실행되는 메소드입니다"); } 
	 

	public void service(HttpServletRequest request, HttpServletResponse response) // 서비스는 반드시 있어야함 // 없으면 405 error
			throws ServletException, IOException {
		System.out.println("service() : 실제 작업이 실행되는 메소드입니다");
		System.out.println("사용자의 요청할 때마다 호출되는 메소드입니다");
	}
}

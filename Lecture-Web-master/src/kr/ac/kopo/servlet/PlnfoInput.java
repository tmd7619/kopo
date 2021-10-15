package kr.ac.kopo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/PInfoResult")
public class PlnfoInput extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String notice = request.getParameter("notice");
		String advertising = request.getParameter("advertising");
		String delivery = request.getParameter("delivery");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인 정보 출력</h2><br>");
		out.println("이름 : " + name+"<br>");
		out.println("아이디 : "+ id+"<br>");
		out.println("암호 : " + pwd+"<br>");
		out.println("성별 : " + gender+"<br>");
		if(notice != null) {
			
			out.println("공지메일 : 받음<br>");
		}else {
			out.println("공지메일 : 받지않음<br>");
			
		}
		if(advertising != null) {
				
				out.println("광고메일 : 받음<br>");
			}else {
				out.println("광고메일 : 받지않음<br>");
				
			}
		if(delivery != null) {
			
			out.println("배송 확인 메일 : 받음<br>");
		}else {
			out.println("배송 확인 메일 : 받지않음<br>");
			
		}
		
		out.println("직업 : " + job+"<br>");
		out.println("<body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}
	
	
	
	
}

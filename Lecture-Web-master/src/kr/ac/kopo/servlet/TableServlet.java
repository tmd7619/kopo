package kr.ac.kopo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/tableExam") // 이 Annotation을 통해 web.xml 파일에 별로의 설정을 하지 않더라도 해당 Servlet을 실행할 수 있다
								  // 단, web.xml에 설정한 가상 url과, 어노테이션 url이 같으면 500 error 발생 => 다르게 지정해줘야 함
public class TableServlet extends HttpServlet {
	
	/*			
	 	http://localhost:9999/Lecture-Web/servlet/table 요청시
	 	
	 	5 X 5 테이블 생성
	 	
	 	http://localhost:9999/Lecture-Web/servlet/table?row=3&col=5 요청시
	 	3 X 5 테이블 생성
	 */

	@Override // 내가 한 방법
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String col = request.getParameter("col");
		String row = request.getParameter("row");
		response.setContentType("text/html; charset=utf-8"); // 한글깨짐 방지 
		
		PrintWriter out = response.getWriter();

		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("=====================================================<br>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp요 청 결 과<br>");
		for(int i = 0 ; i < Integer.parseInt(col) ; i ++ ) {
			for(int j = 0 ; j < Integer.parseInt(row); j ++){
				out.println("| cell("+j+","+i+") |");
			}
			out.println("<br>-----------------------------------------------------<br>");
		}
		out.println("<body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	@Override // 교수님 방법
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		int row = 5;
		int col = 5;
		
		String rowStr = request.getParameter("row");
		String colStr = request.getParameter("col");
		if(rowStr != null)
			row = Integer.parseInt(rowStr);
		col = colStr == null ? 5 : Integer.parseInt(colStr);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("  <title>테이블생성</title>");
		sb.append("<style>");
		sb.append(" td { ");
		sb.append("  padding: 0 10px; ");
		sb.append(" } ");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("  <table border='1'>");
		for(int i = 0; i < row; i++) {
			sb.append("   <tr>");
			for(int j = 0; j < col; j++) {
				sb.append("<td>");
				sb.append("cell( " + i + ", " + j + ")"); // 변화하는 문자열이기 때문에, StringBuilder를 사용(string보단)
				sb.append("</td>");
			}
			sb.append("   </tr>");
		}
		sb.append("  </table>");
		sb.append("</body>");
		sb.append("</html>");
		
		out.println(sb.toString());
		out.flush();
		out.close();
		
	}
	
	
	

}

package kr.ac.kopo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 스프링에서는 인터샙터가 비슷한 역할을 하게 됨
public class EncodingFilter implements Filter { // "utf-8" 방식으로 받게끔 filter 역할을 해주는 클래스
												// 작동순서 : 서버실행 -> 필터 -> servlet
	
	private String charset;
	
	@Override // 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("필터처리 ....");
		
//		request.setCharacterEncoding("utf-8"); // 요청 uri가 들어오면, 모든 요청 uri를 utf-8 방식으로 처리하게 됨
		request.setCharacterEncoding(charset); // 좀더 유연한 방식 
		
		chain.doFilter(request,response); // doFilter를 통해 uri로 넘어감
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		charset = filterConfig.getInitParameter("encoding"); // web.xml 에 등록한 param 값을 가져옴
	}
	
	
	

}

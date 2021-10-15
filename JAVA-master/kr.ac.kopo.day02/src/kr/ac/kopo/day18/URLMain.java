package kr.ac.kopo.day18;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLMain {

	public static void main(String[] args) {

		// checked exception
		try {
//			URL urlObj = new URL("http://www.naver.com:80"); // 포트명을 정의하지 않으면 -1 
			URL urlObj = new URL("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=java");
			System.out.println("프로토콜 : " + urlObj.getProtocol());
			System.out.println("호스트명 : " +  urlObj.getHost());
			System.out.println("포트명 : " +  urlObj.getPort()); 
			System.out.println("경로 : " + urlObj.getPath());
			System.out.println("쿼리 : " + urlObj.getQuery());
			
			System.out.println("==========================================================");
			URLConnection uc = urlObj.openConnection(); // input,outputStream 형식을 모두 받아올 수 있다. // write 가능
			InputStream is = uc.getInputStream();
//			InputStream is = urlObj.openStream(); // 바이트스트림 형식이라 한글이 깨지는 현상이 나타남.
			InputStreamReader isr = new InputStreamReader(is,"utf-8"); // 필터클래스인 isr를 통해 문자스트림으로 변환
																	   // 인자로 인코딩 방식을 넣을 수 있음.
			
			while(true) {
				int c  = isr.read();
				if(c == -1)break;
				System.out.print((char)c); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

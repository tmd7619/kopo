package kr.ac.kopo.day18;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerMain {
	
	/*
	   EchoServer : 클라이언트가 전송해 주는 데이터를 그대로 되돌려 전송해 주는 기능의 서버를 의미한다.
	 */
	
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("EchoServer 실행 시작....");
			
			Socket client = server.accept();
			
			System.out.println("접속한 클라이언트 정보 : " + client.getInetAddress().getHostAddress());
			
			// 클라이언트에서 전송한 데이터를 수신할 수 있는 객체
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			
			
			// 수신한 데이터를 클라이언트에 재전송할 객체 
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw); // printWriter가 Buffer 제거까지 함
			
			while(true) {
			String msg = br.readLine(); // 클라이언트에서 넘어온 데이터 받기 // 순서 2
			
			if(msg == null) {
				System.out.println("클라이언트와 접속을 종료합니다.");
				client.close();
				break;
			}
			
			System.out.println("클라이언트에서 전달된 메세지 : " + msg );
			
			 pw.println(msg);
             pw.flush();
			}
			
		}catch(Exception e ) {
			e.printStackTrace();
			
		}
	}

}

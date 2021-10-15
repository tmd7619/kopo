package kr.ac.kopo.day18;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerMain {

	public static void main(String[] args) {
		try {
		ServerSocket server = new ServerSocket(10000);
		System.out.println("어플리케이션 서버 실행 ...");
		
	
		Socket client = server.accept() ; 
		System.out.println("연결된 클라이언트 정보 : " +  client);
		
		// 소켓 통신시, dos로 보냈으면, client도 DataInputStream으로 받아야한다. 
		String msg = "접속을 환영합니다. "; // 메시지 전달 // outputstream 필요
		OutputStream os = client.getOutputStream(); // os는 바이트,인트형 밖에 write를 쓸 수 있음
		DataOutputStream dos = new DataOutputStream(os); // 필터 클래스를 통해 String write
		dos.writeUTF(msg);
		dos.flush(); // 버퍼 비우기
		
		client.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

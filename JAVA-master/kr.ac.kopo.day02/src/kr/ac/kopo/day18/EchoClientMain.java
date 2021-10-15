package kr.ac.kopo.day18;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClientMain {
	
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("192.168.217.57",10001);

			// 키보드로 입력받을 객체
//			Scanner keyboard = new Scanner(System.in);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); //
			
			
			// 클라이언트가 키보드로 입력받은 데이터를 서버에게 전달 객체 
			OutputStream os = socket.getOutputStream() ; 
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);  // 버퍼라이터와 비슷한 기능하는 클래스
			
			// 서버에서 재전송한 데이터 수신
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			
			while(true) {
			System.out.print("메세지 입력 :  "); 
			String msg = keyboard.readLine(); // 키보드로 입력받기 
			
			if(msg.equalsIgnoreCase("quit")) {
				System.out.println("서버 연결을 종료합니다.");
				socket.close();
				break;
			}
			
			pw.println(msg); // 순서 1 // 서버에 처음으로 메시지 보내기 
			pw.flush();
			
			String echoMsg = br.readLine();	// 순서 3 // 서버에서 받은 메시지 받기 
			System.out.println("서버에서 전송한 메세지 : " + echoMsg);
			
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

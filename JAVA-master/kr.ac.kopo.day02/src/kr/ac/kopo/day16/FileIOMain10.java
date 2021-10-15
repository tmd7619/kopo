package kr.ac.kopo.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIOMain10 {

	public static void write() throws Exception{
		UserInfo user = new UserInfo("홍길동", 25, "서울시 서초구");
		
		
		
		FileOutputStream fos = new FileOutputStream("iodata/objectData.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);  // 바이트스트림 형태이기에, fw가 아닌 fos
		
		oos.writeObject(user); // 객체 단위로 write 하는 메서드 
		oos.flush();
		
		
		System.out.println("objectData.txt 저장완료");
		
//		FileWriter fw = new FileWriter("iodata/userInfo.txt");
//		PrintWriter pw = new PrintWriter(fw);
		
//		pw.println(user.getName());
//		pw.println(user.getAge());
//		pw.println(user.getAddr());
//		
//		pw.flush();
//		FileClose.close(pw);
//		FileClose.close(fw);
//		
//		System.out.println("userInfo.txt에 저장을 완료하였습니다.");
	}
	
	public static void read() throws Exception{
		
		FileInputStream fis = new FileInputStream("iodata/objectData.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		UserInfo user = (UserInfo)ois.readObject(); // 객체단위로 read하는 메서드
		
		System.out.println("파일 로드 완료....");
		System.out.println(user);
		
		
//		FileReader fr = new FileReader("iodata/userInfo.txt");
//		BufferedReader br = new BufferedReader(fr);
//		
//		String name = br.readLine();
//		int age = Integer.parseInt(br.readLine());
//		String addr = br.readLine();
//		
//		UserInfo user = new UserInfo(name,age,addr);
//		
//		FileClose.close(br);
//		FileClose.close(fr);
//		System.out.println("파일 로드를 완료하였습니다.");
//		System.out.println(user);
	}
	
	
	public static void main(String[] args) {
		
		try {
//			write();
			read();	// transient로 인해 age는 0으로 읽어온다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

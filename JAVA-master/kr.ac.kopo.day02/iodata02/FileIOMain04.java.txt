package kr.ac.kopo.day15;

import java.io.*;

import kr.ac.kopo.util.FileClose;

public class FileIOMain04 {

	public static void write() {
		
		char c = 'A';
		int i = 10;
		double d = 12.34;
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;		// 바이트를 조합해서 정수나 실수 등 기본자료형타입으로 넘겨주고 싶을때
		try{
			fos = new FileOutputStream("iodata/test.dat");
			dos = new DataOutputStream(fos);
			
			dos.writeChar(c);		// write 1번째 문자(2byte)
			dos.writeInt(i);		// write 2번째 정수(4byte)
			dos.writeDouble(d);		// write 3번째 실수(8byte)
			
			System.out.println("쓰기완료...");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			FileClose.close(fos);
			FileClose.close(dos);
			
		}
	}
	
	public static void read() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("iodata/test.dat");
										// write 순서대로 출력이 되기 때문에, write 순서를 항상 고려해야함
			char c = dis.readChar();	// char=2byte니까 2바이트를 조합해서 문자값 읽어오기
			int i = dis.readInt();		// int = 4byte니까 char c 뒤에 4바이트를 조합해서 정수값 읽어오기
			double d = dis.readDouble();
			
			System.out.println("읽어온 데이터 출력...");
			System.out.println("문자 : "+c);
			System.out.println("정수 : "+i);
			System.out.println("실수 : "+d);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			FileClose.close(dis, fis);
		}
	}
	
	
	public static void main(String[] args) {
		write();
		read();
	}
}

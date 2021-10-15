package kr.ac.kopo.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileIOMain11 {

	
	public static void write() {
		
		UserVO user = new UserVO("홍길동",26,"010-1111-2222","서울시 서초구");
		UserVO user2 = new UserVO("구길동",23,"010-2323-2222", "경기도 광명시 철산구");
		UserVO user3 = new UserVO("박길동",25,"010-5533-2323","서울시 송파구");
		
		
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(user);
		list.add(user2);
		list.add(user3);
		
		try {
			FileOutputStream fos = new FileOutputStream("iodata/UserVO.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(list);
			oos.flush();
			System.out.println("UserVO에 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	
	public static void read() {
		List<UserVO> list = null;
		
		try {
			FileInputStream fis = new FileInputStream("iodata/UserVO.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
			list = (List<UserVO>)ois.readObject();
			System.out.println("파일 로드 완료...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < list.size(); i ++ ) {
			System.out.println(list.get(i));
			
		}
		
	}
	
	public static void main(String[] args) {
		write();
		read();
		
	}
}

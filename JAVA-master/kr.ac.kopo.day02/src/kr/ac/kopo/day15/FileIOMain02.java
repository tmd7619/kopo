package kr.ac.kopo.day15;

/*
 * iodata/dog.jpg -> iodata.dog2.jpg 복사하기
 * 
 * 1. stream open
 * 2. read / write 수행
 * 3. stream close
 * 
 * dog ( input) ====> do2 ( output)
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOMain02 {

	public static void main(String[] args) {
		/*
		 * FileOutputStream fos = new FileOutputStream("aa.txt"); // 파일명만 쓰면, 프로젝트 밑에
		 * 생성된다 (C:\Users\HP\eclipse-workspace\kr.ac.kopo.day02)
		 */
		// Project Explorer은 실시간으로 업로딩이 안되서, 새로고침해야 보임
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			long start = System.currentTimeMillis();
			// 1. stream open
			fis = new FileInputStream("iodata/dog.jpg");
			fos = new FileOutputStream("iodata/dog2.jpg");	// stream 통로만 연결시켰음
			
			// 2. read/write
			while(true) {
			int c =fis.read();
			if(c==-1) break;			// -1 : 파일의 끝
			fos.write(c);
			}
			long end = System.currentTimeMillis();
			System.out.println("복사완료");
			System.out.println("소요시간  : "+ (end-start)/1000. +"초");
			
			/* while(true); */				// 읽거나 쓰기를 하려할때, 파일이 실행중이거나 사용중이면 수정완료가 제대로 되지 않는다(Rocked).
		} catch (Exception e) {
			e.printStackTrace(); // 지정된 파일이 존재하지 않으면 exception
		}finally {
			// 3. stream close
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //=>  fis, fos 변수는 try구문 내에 쓰여지는 지역변수이기 때문에 에러가 난다. 따라서 변수 선언을 try 밖에다 해주자
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

package kr.ac.kopo.day15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import kr.ac.kopo.util.FileClose;

public class FileIOMain03 {
	public static void main(String[] args) {
		// dog.jgp -> dog3.jpg 복사
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			long start = System.currentTimeMillis();
			fis = new FileInputStream("iodata/dog.jpg");
			fos = new FileOutputStream("iodata/dog3.jpg");
			
			// 버퍼사용 객체연결
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			// 복사수행
			int c = 0;
			while((c =bis.read()) != -1) {
				bos.write(c);		// 저장
			}
			long end = System.currentTimeMillis();
			System.out.println("dog3.jpg에 복사완료....");	
			System.out.println("소요시간 : "+(end-start)/1000.+"초");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
			FileClose.close(bis,fis);
			FileClose.close(bos,fos);

			}
		
	}

}

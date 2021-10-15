package kr.ac.kopo.day15;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileIOMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("입력을 하세요. ctrl+z를 누르면 종료됩니다.");

		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);

		try {
			while (true) {
				int c = isr.read();
				if (c == -1)
					break;
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * InputStream is = System.in; // 바이트 단위로 int c = is.read(); // 읽은 바이트가 파일의 끝이면
		 * -1 을 반환
		 * 
		 * while(true) { c = is.read(); // 라인의 첫열에서만 ctrl + z 가 인식된다. if(c == -1)break;
		 * System.out.print((char)c); }
		 */

	}

}

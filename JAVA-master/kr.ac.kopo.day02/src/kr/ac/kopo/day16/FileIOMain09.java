package kr.ac.kopo.day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import kr.ac.kopo.util.FileClose;

public class FileIOMain09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		FileReader fr = null;
		FileWriter fw = null;	
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader("iodata/FileIOMain04.java");
			fw = new FileWriter("iodata/FileIOMain04.java.txt");
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			while(true) {
				String data = br.readLine();
				if(data == null)break;
				bw.write(data);
				bw.newLine();
			}
			bw.flush();
			System.out.println("파일 복사를 완료하였습니다.");
		
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(br,bw);
			FileClose.close(fr,fw);
		}
	}

}

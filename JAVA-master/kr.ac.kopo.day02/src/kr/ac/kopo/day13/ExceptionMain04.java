package kr.ac.kopo.day13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionMain04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("a.txt"); // checked exception : 무조건 예외처리를 해야지만 실행할 수 있는 코드
		} catch(FileNotFoundException fnfe) {
			try {
			FileWriter fw = new FileWriter("error.log");
			} catch(IOException ie) {
				ie.printStackTrace();
			}
		}
		
	}

}

package kr.ac.kopo.day17;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * 
 *  File 객체를 활용한 입출력 -> 파일에 대한 정보를 가져올 수 있다. 
 * 
 */


public class FileMain {
	public static void main(String[] args) {
		
		// 두가지 모두 가능
		File fileObj = new File("iodata/filemain.txt"); 
//		File fileObj = new File("C:\\Users\\HP\\eclipse-workspace\\kr.ac.kopo.day02\\iodata\\filemain"); //절대경로 
		
		String name = fileObj.getName();
		String parent = fileObj.getParent();
		String path = fileObj.getPath()	;
		String abpath = fileObj.getAbsolutePath()	;
		
		
		System.out.println("파일명 : "+ name);
		System.out.println("부모이름 : "+ parent);
		System.out.println("경로 : "+ path);
		System.out.println("절대경로 : "+ abpath);
		
		boolean bool = fileObj.isFile()	;
		System.out.println(bool ? "파일입니다" : "파일이 아닙니다.");
		bool = fileObj.isDirectory()	;
		System.out.println(bool ? "디렉토리입니다" : "디렉토리가 아닙니다.");
		
		bool = fileObj.exists() ; 
		System.out.println(bool ? "존재합니다" : "존재하지 않습니다.");
		
		long size = fileObj.length() ; 
		System.out.println("파일크기 : " + size + "byte(s)" );
		
		long time = fileObj.lastModified() ; // millisecond 단위로 나타내줌
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println("마지막 수정 날짜 " + sdf.format(new Date(time)));
		
		bool = fileObj.canWrite(); // 쓰기가 가능한지? // 읽기전용 파일은 불가능하다고 나옴 
		System.out.println(bool ? "쓰기 가능" : "쓰기 불가능 ");
	
		bool = fileObj.canRead() ; // 읽기 가능?
		System.out.println(bool ? "읽기 가능" : "읽기 불가능 ");
		
		bool = fileObj.canExecute() ; // 실행 가능?
		System.out.println(bool ? "실행 가능" : "실행 불가능 ");
		
		
	}
}

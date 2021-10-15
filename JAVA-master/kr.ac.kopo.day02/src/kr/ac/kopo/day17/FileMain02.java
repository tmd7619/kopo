package kr.ac.kopo.day17;

import java.io.File;

public class FileMain02 {
	public static void main(String[] args) {
		File dirObj = new File("iodata");
		
		System.out.println(dirObj.exists() ? "유효한 디렉토리 "  : "유효하지 않는 디렉토리 ");
		System.out.println(dirObj.isDirectory() ? "디렉토리입니다 " : "디렉토리가 아닙니다");
		
		String[] list = dirObj.list() ; // 해당 디렉토리안에 있는 모든 파일들의 정보를 알려줌 // list() 리턴타입 : 스트링배열
		System.out.println("===================================================================");
		System.out.println("\t " + dirObj.getName() + "정보");
		System.out.println("===================================================================");
		for(String name : list ) {
			System.out.println(name);
			
		}
		System.out.println("===================================================================");
		
		File newDirObj =  new File("iodata/새폴더/고니");
		if( ! newDirObj.exists() ) {
			boolean bool = newDirObj.mkdir() ; 
			System.out.println(bool ? "생성 성공 " : "생성 실패 ");
			
		}
		
		newDirObj = new File("iodata/새새폴더/오리"); 
		if( ! newDirObj.exists() ) {
			boolean bool = newDirObj.mkdirs() ; // mkdir에 s를 붙이게 되면, 중간중간 없는 부모폴더까지 만들어 준다.
			System.out.println(bool ? "생성 성공 " : "생성 실패 "); // 생성 성공 
			
		}
		
		boolean bool = newDirObj.delete() ; // 가장 맨 밑에 있는 하위폴더를 delete  
		System.out.println(bool ? "삭제 성공 " : "삭제 실패");		
		
		
	}


}

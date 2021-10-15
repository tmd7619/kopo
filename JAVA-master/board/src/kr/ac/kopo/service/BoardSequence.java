package kr.ac.kopo.service;

public class BoardSequence { // 게시판의 일련번호를 만드는 클래스

	private static int no  = 1 ;
	
	public static synchronized int getNo() { // 동기화를 통해 일관성 유지// 작업이 실행되는 동안 rock을 걸어, 중복수행이 되지 않기 위해
		return BoardSequence.no++;
	}
	
}

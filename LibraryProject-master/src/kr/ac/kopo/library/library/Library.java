package kr.ac.kopo.library.library;

import java.text.ParseException;

public interface Library {

	public void bookLookup();  // 도서목록조회 사용자 + 관리자 
	
	public void bookAdd() throws ParseException; // 도서 등록 // 관리자
	public void bookUpdate();  // 도서수정 // 관리자
	public void bookDelete();  // 도서삭제 // 관리자 
	
	public void borrowInfo(String userId); // 대출정보 조회 // 사용자
	public void bookBorrow(String userid); // 대출하기  // 사용자 	
	public void bookReturn(String userid); // 책 반납하기 // 사용자
	
}

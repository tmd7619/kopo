package kr.ac.kopo.library.member;

import java.text.ParseException;

public interface Member {
	public void register();
	public void userSwitch (String logId, String logpasswd) throws ParseException; // main에서 user와 admin을 구별하기 위한 메소드
	
	public void adminMemberUpdate();	 // 회원수정
	public void adminMemberDelete();  // 회원삭제
	public void adminMemberLookup();  // 회원조회
	
	public void userMemberUpdate();	 // 회원수정
	public void userMemberDelete();  // 회원삭제
	public void userMemberLookup();  // 회원조회
}

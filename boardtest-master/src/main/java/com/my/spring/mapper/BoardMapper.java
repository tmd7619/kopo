package com.my.spring.mapper;

/*
 * mapper 인터페이스는 여러 mapper 인터페이스 작성시 설정한다.
 * 매핑파일에 기재된(src/main/resources/mapper/BoardMapper.xml)SQL을 호출하기 위한 인터페이스다.
 * 매핑파일에 있는 SQL을 인터페이스로 호출한다.
 */

import java.util.List;

import com.my.spring.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> viewAll(); //BoardMapper.xml 작성한 SQL문의 결과값이 여러개일 수 있으므로
//								      BoardVO타입만 담을 수 있는 List타입으로 메소드를 정의하고
//									  매퍼파일에서 불러올 SQL문의 id를 메소드 이름으로 입력해준다.

	public BoardVO viewDetail(int seq);
	
	// 조회수 +1
	public boolean plusCnt(int seq);
	
	// 게시물 작성
	public int insertBoard(BoardVO vo);
	
	// 게시물 삭제
	public boolean deleteBoard(int seq);
	
	// 게시물 수정
	public boolean updateBoard(BoardVO vo);
}


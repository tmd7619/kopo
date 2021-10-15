package com.my.spring.service;

import java.util.List;

import com.my.spring.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> viewAll();//BoardMapper인터페이스에서 작성한 내용과 동일한 내용이다.
//									BoardMapper에서 사용한 viewAll이란 이름은 매퍼파일의 id값과 매칭하기 위함이었다.
//									하지만 서비스 영역은 해당 SQL문을 이용해 어떠한 기능을 하는가에 대해 작명해주면 된다.
//									따라서 꼭 viewAll로 이름을 정의할 필요는 없지만 본 포스팅에선 편의를 위해 동일하게 작성한다.
	
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

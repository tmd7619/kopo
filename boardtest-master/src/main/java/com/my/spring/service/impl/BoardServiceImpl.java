package com.my.spring.service.impl;

/*
	기본적으로 인터페이스는 객체를 생성할 수 없다. 즉 new 키워드를 사용한 객체생성이 불가능하다.
	@Autowired를 사용하면 Spring Framework가 해당 인터페이스(BoardMapper)를 참조하고
	해당 인터페이스와 연동된 매퍼(BoardMapper.xml)을 참고해 자동으로 객체를 생성해 mapper란 변수에 주입한다. 
	이러한 작업을 의존성 주입(Dependency Injection)이라 한다.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.spring.domain.BoardVO;
import com.my.spring.mapper.BoardMapper;
import com.my.spring.service.BoardService;

@Service //해당 클래스가 구현된 Service란것을 알리기 위한것이다.
public class BoardServiceImpl implements BoardService {
	
	@Autowired //의존성 주입을 위한 것이다. 쉽게 말하면, 스프링에서 객체생성해줌
	private BoardMapper mapper;

	@Override //의존성 주입을 받은 mapper변수로 BoardMapper 안의 viewAll메소드를 호출했다.
	public List<BoardVO> viewAll() { // mapper -> BoardMapper 인터페이스 -> BoardMapper.xml -> viewAll을 참조해
		return mapper.viewAll();     // BoardMapper.xml에 작성된 id가 viewAll인 SQL문의 결과 값이 위 메소드의 리턴값이 되는것이다.
	}
	
	@Override
	public BoardVO viewDetail(int seq) {
	  return mapper.viewDetail(seq);
	}
	
	
	@Override
	public boolean plusCnt(int seq) {
	  return mapper.plusCnt(seq);
	}
	
	@Override
	public int insertBoard(BoardVO vo) {
		return mapper.insertBoard(vo);
	}
	
	@Override
	public boolean deleteBoard(int seq) {
		return mapper.deleteBoard(seq);
	}
	
	@Override
	public boolean updateBoard(BoardVO vo) {
		return mapper.updateBoard(vo);
	}
	
	
	
}
package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardService {

	
	private BoardDAO dao;
	
	/*
	public BoardService() {
		dao = new BoardDAO();
	}
	*/
	
	public BoardService(BoardDAO dao) {
		this.dao = dao ; // dao 객체 생성을 service에서 생성이 아닌, 그대로 가져오게 하겠다.
	}
	public List<BoardVO> listAll(){
		
		List<BoardVO> list = dao.selectAll();
		
		return list;
		
		
	}
}

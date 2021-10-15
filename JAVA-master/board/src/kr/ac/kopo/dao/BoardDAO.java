package kr.ac.kopo.dao;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {
	/*
	 * 프로그램 상에서만 작동하는 DAO 
	 */
	
	private List<BoardVO> list;
	
	public BoardDAO() {
		list = new ArrayList<>();
	}

	
	/*
	 * 전체 게시글 조회  
	 */
	public List<BoardVO> 전체게시글조회() throws Exception{
		System.out.println("dao 전체 게시글 조회..");
		return list;
	}
	
	public List<BoardVO> 글번호조회(int no) throws Exception {
		
		for(BoardVO board : list) {
			if(board.getNo() == no ) {
				return list;
			}
		}
		return null;
	}
	
	public void 새글등록(BoardVO newBoard) {
		list.add(newBoard);
		System.out.println("dao : " + newBoard +  " size : " + list.size());
	}
	
	public void 게시글수정(BoardVO board) {
		for(BoardVO vo: list) {
			if(vo.getNo() == board.getNo()) {
				vo.setTitle(board.getTitle());
				return; // 메서드 종료 
			}
		}
	}
	
	public void 게시글삭제(int no) {
		for(int i = 0 ; i < list.size(); i ++	) {
			if(list.get(i).getNo() == no) {
				list.remove(i);
				return;
			}
		}
		
	}
	
}

package kr.ac.kopo.ui;

import kr.ac.kopo.vo.BoardVO;

public class AddUI extends BaseUI { // business logic class

	
	@Override
	public void execute() throws Exception {
		
		String title = scanStr("등록할 제목을 입력하세요 : ");
		String writer = scanStr("등록할 글쓴이를 입력하세요 : ");
		
		BoardVO newBoard = new BoardVO();
		newBoard.setTitle(title);
		newBoard.setWriter(writer);
		
		service.새글등록(newBoard); // protected로 인해 자식클래스가 service를 사용할 수 있다.
		
		System.out.println("게시글 등록을 완료하였습니다.");
		
	}
	
	
	
}

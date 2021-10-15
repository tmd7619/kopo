package kr.ac.kopo.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;

public class BoardDAO {
	
	private SqlSession session;

	public BoardDAO() {
		session = new MyConfig().getInstance();
		System.out.println("session : "+ session);
	}
	
	public void work() {
//		insert();
//		selectAll();
//		selectOne();
//		selectOne2();
//		selectNos();
//		selectWhere();
		update();
		
	}
	
	private void insert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("객체로 삽입....");
		board.setWriter("홍길동");
		board.setContent("삽입되었나?");
		
		
		session.insert("board.BoardDAO.newBoard", board); // id는 namespace까지 포함한다.
		session.commit();  // 커밋을 해야 정상 insert 이루어짐
		
		System.out.println("삽입완료");
	}
	
	private void selectAll() {
//		List<BoardVO> list = session.selectList("board.BoardDAO.selectAll"); // list 형태로 return
		List<BoardVO> list = session.selectList("board.BoardDAO.selectAllMap"); 
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
		
	}
	

	private void selectOne() {
		BoardVO board = new BoardVO();
		board.setNo(108);
//		BoardVO result = session.selectOne("board.BoardDAO.selectOne", board); // 알아서 BoardVO 타입으로 리턴
		
//		BoardVO result = session.selectOne("board.BoardDAO.selectOne2", 108); // 두번째 방법 // 파라미터 변수 넘기긴
		
		BoardVO result = session.selectOne("board.BoardDAO.selectOne3", 108); // 두번째 방법 // 파라미터 변수 넘기긴
		System.out.println(board);
	}
	
	private void selectOne2() { // map type으로 sql 결과값 가져오기
		BoardVO board = new BoardVO();
		board.setNo(141);
		
		Map<String, Object> map = session.selectOne("board.BoardDAO.selectOne4", board); // 알아서 BoardVO 타입으로 리턴
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}

	}

	
	private void selectNos() { // select ~ where no in ~ 을 구성하기 위한 목적
		/*
		BoardVO board = new BoardVO();
		board.setNos(new int[] {1,2,3,4,5,19,20,21});
		
		List<BoardVO> list = session.selectList("board.BoardDAO.selectNos" , board);
		 */
		List<Integer> nos = new ArrayList<>();
		nos.add(1);
		nos.add(2);
		nos.add(3);
		nos.add(4);
		nos.add(5);
		
//		List<BoardVO> list = session.selectList("board.BoardDAO.selectNos2" , nos);
		List<BoardVO> list = session.selectList("board.BoardDAO.selectNos3" , nos);
		
		for(BoardVO b : list) {
			System.out.println(b);
		}
		
	}
	
	private void selectWhere() { // select ~ where title like ~ 
//		List<BoardVO> list = session.selectList("board.BoardDAO.selectWhere", "홀리");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("홀리");
		vo.setWriter("토마스"); // 주석처리를 할 경우, '홀리%'의 모든 데이터 출력됨
		List<BoardVO> list = session.selectList("board.BoardDAO.selectWhere2", vo);
		
		
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}

	private void update() {
		Scanner sc = new Scanner(System.in);
		
		BoardVO vo = new BoardVO();
		System.out.print("수정할 글 번호를 입력하세요 : ");
		vo.setNo(sc.nextInt());
		sc.nextLine();
		
		System.out.print("변경할 제목을 입력하세요 : ");
		vo.setTitle(sc.nextLine());
		
		
		session.update("board.BoardDAO.updateBoard", vo);
		session.commit();
		
		System.out.println(vo.getTitle()+"으로 변경완료");
		
	}
	
}

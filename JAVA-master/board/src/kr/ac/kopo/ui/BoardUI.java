package kr.ac.kopo.ui;

public class BoardUI extends BaseUI {
	
	/*
	 * 메뉴 class
	 * 
	 */
	

	@Override
	public void execute() throws Exception { // 예외처리를 BoardMain의 catch구문에 넘김 

		while (true) { // switch 예외 처리를 해주기 위해 while문에 try/catch 구문을 넣는 것이 좋다.// 안그러면 main catch구문이 처리
			try {
			IBoardUI ui = null;
			int type = menu();
			switch (type) {
			case 1:
				ui = new SearchAllUI(); // 묵시적 형변환
				break;
			case 2:
				ui = new SearchOneUI(); 
				ui.execute();
				break;
			case 3:
				ui = new AddUI();
				break;
			case 4:
				ui = new UpdateUI();
				break;
			case 5:
				ui = new DeleteUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			}
			if(ui != null) {
			ui.execute();
			} else {
				System.out.println("잘못선택하셨습니다.");
			}
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		}

	}

	private int menu() { // 외부에 보일 이유가 없으니, private 사용

		System.out.println("================================================");
		System.out.println("\t 게시판 관리 프로그램 ");
		System.out.println("================================================");
		System.out.println("\t 1. 전체 게시글 조회 ");
		System.out.println("\t 2. 글번호 조회 ");
		System.out.println("\t 3. 새글등록 ");
		System.out.println("\t 4. 게시글 수정 ");
		System.out.println("\t 5. 게시글 삭제 ");
		System.out.println("\t 0. 종료 ");
		System.out.println("================================================");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		return type;
	};

}
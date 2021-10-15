package kr.ac.kopo.service;

public class BoardServiceFactory {
	
	private static final BoardService service = new BoardService() ;
	
	
	public static BoardService getInstance() {
	
			return service ;
		}
	

}

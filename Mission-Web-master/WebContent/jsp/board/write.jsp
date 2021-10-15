<%@page import="kr.ac.kopo.board.vo.BoardFileVO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="kr.ac.kopo.util.KopoFileNamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 
       작업순서
       1. 파라미터(제목, 작성자, 내용) 추출
       2. 추출된 데이터를 DB(t_board)에 삽입
       3. 목록페이지 이동
       
       https://zero-gravity.tistory.com/168 파일업로드 참고 링크
       
     -->
     <%
     	String saveDirectory = "C:/Users/HP/Lecture/web-workspace/Mission-Web/WebContent/upload";
     	MultipartRequest multiRequest =  new MultipartRequest(
     															request, 
     															saveDirectory, // 저장될 서버 경로
     															1024 * 1024 * 3, // 3MB로 파일크기 제한
     															"utf-8", // 인코딩방식
     															new KopoFileNamePolicy() // 같은이름의 파일명 방지 처리
     			);
	     // MultipartRequest로 전송받은 데이터를 불러온다.
	     // enctype을 "multipart/form-data"로 선언하고 submit한 데이터들은 request객체가 아닌 MultipartRequest객체로 불러와야 한다.														
	     
	    // 1. 게시글 저장 
     	String title = multiRequest.getParameter("title");
     	String writer = multiRequest.getParameter("writer");
     	String content = multiRequest.getParameter("content");
        
        BoardDAO dao = new BoardDAO();
  	   // 게시물 번호 추출
		int boardNo = dao.selectNo();
     	
        BoardVO board = new BoardVO();
        board.setTitle(title);
        board.setWriter(writer);
        board.setContent(content);
		board.setNo(boardNo);
        System.out.println(board);
        
		dao.insert(board);
       	
		// 2. 첨부파일 저장(t_board_file)	
		Enumeration<String> files = multiRequest.getFileNames(); // getFileNames의 return 타입이 Enumeration이다.
		
		while(files.hasMoreElements()){ //hasMoreElements() : 읽어올 요소가 남아있는지 확인. 
										//있으면 true, 없으면 false. Iterator의 hasNext()와 같음
			
			String fileName = files.nextElement();  //nextElement(): 현재 커서값 리턴(getFileNames중 파일이름), 다음 커서로 이동
			File f = multiRequest.getFile(fileName); // getFile() : 업로드된 파일의 File type의 객체 얻는다
			if( f != null){
				String fileOriName = multiRequest.getOriginalFileName(fileName); // 원래 파일명 리턴 // ex) dog.jpg
				String fileSaveName = multiRequest.getFilesystemName(fileName); // 서버 상에 실제 파일명을 리턴 // upload 폴더에 있는 파일명
				int fileSize = (int)f.length(); // length() 기본형은 long으로, int 형변환 // length -> filesize
//				System.out.println(fileOriName + " : " + fileSaveName); 
				
				BoardFileVO fileVO = new BoardFileVO();
				
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				fileVO.setBoardNo(boardNo);
				
				dao.insertFile(fileVO);
			}
			System.out.println(fileName); //file의 name속성 출력 
		}
		
     %>
<script>
   alert('새글 등록이 완료되었습니다.')
   location.href="list.jsp"
</script>
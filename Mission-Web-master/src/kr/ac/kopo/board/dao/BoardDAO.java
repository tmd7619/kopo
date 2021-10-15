package kr.ac.kopo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.board.vo.BoardFileVO;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.util.ConnectionFactory;

public class BoardDAO {
	
	// t_board sequence 추출
	public int selectNo() {
		int no = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("select seq_t_board_no.nextval from dual " );
		
		try(
				Connection conn = new ConnectionFactory().getConnection() ;
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());)
		{
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				no = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return no;
	}
	
	

	public void insert(BoardVO board) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board(no,title,writer,content)");
		sql.append(" values(?, ?, ?, ?)");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1; // pstmt.set 메서드에 변수화를 함으로써, 유지보수에 용이해짐
			
			pstmt.setInt(loc++, board.getNo());
			pstmt.setString(loc++, board.getTitle());
			pstmt.setString(loc++, board.getWriter());
			pstmt.setString(loc++, board.getContent());

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<BoardVO> selectAll() {

		List<BoardVO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, to_char(reg_date,'yyyy-mm-dd') as reg_date ");
		sql.append("from t_board ");
		sql.append("order by no desc");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");

				BoardVO board = new BoardVO();
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);

				list.add(board);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public BoardVO selectByNo(int boardNo) {
		
		BoardVO board = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, content, view_cnt ");
		sql.append("     , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_board ");
		sql.append(" where no = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			board = new BoardVO();
			board.setContent(rs.getString("content"));
			board.setNo(boardNo);
			board.setRegDate(rs.getString("reg_date"));
			board.setTitle(rs.getString("title"));
			board.setViewCnt(rs.getString("view_cnt"));
			board.setWriter(rs.getString("writer"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}
	
	public static void main(String[] args) { // java application으로 실행하여, dao로 넘어오는 값들을 찍어볼 수 있다.
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.selectByNo(1);
		System.out.println(board);
	}
	
	
	
	public void delete(BoardVO boardVO) {
		
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_board ");
		sql.append(" where no = ?  ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());)
		{
			pstmt.setInt(1, boardVO.getNo());
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(BoardVO board) {

		StringBuilder sql = new StringBuilder();
		sql.append("update t_board set title = ? ,  ");
		sql.append(" content = ? where no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void updateViewCnt(int boardNo) {
		StringBuilder sql = new StringBuilder();
		sql.append("update t_board " );
		sql.append(" set view_cnt = view_cnt +1");
		sql.append(" where no = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////                t_board_file 테이블의 CRUD
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void insertFile(BoardFileVO file) {
		   
		   StringBuilder sql = new StringBuilder();
		    sql.append("insert into t_board_file(no,board_no, file_ori_name, file_save_name, file_size) ");
		    sql.append("values(SEQ_T_BOARD_FILE_NO.nextval,?,?,?,?) ");
		    
		   try (
		         Connection conn = new ConnectionFactory().getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		         
		   ){
		      
		        int loc = 1;
		        pstmt.setInt(loc++,file.getBoardNo());
		        pstmt.setString(loc++,file.getFileOriName());
		        pstmt.setString(loc++,file.getFileSaveName());
		        pstmt.setInt(loc++,file.getFileSize());
		      
		        pstmt.executeUpdate();
		      
		   }catch (Exception e) {
		      e.printStackTrace();
		   }
		}
	
	public List<BoardFileVO> selectFileByNo(int boardNo){
		
		List<BoardFileVO> fileList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder() ;
		sql.append("select file_ori_name, file_save_name,file_size,no  ");
		sql.append(" from t_board_file" );
		sql.append(" where board_no = ? " );
		
		try (
		         Connection conn = new ConnectionFactory().getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		   ){
		      pstmt.setInt(1, boardNo);
		      
		      ResultSet rs = pstmt.executeQuery();
		      
		      while(rs.next()) {
		    	  BoardFileVO FileVO = new BoardFileVO();
		    	  FileVO.setBoardNo(rs.getInt("no"));
		    	  FileVO.setFileOriName(rs.getString("file_ori_name"));
		    	  FileVO.setFileSaveName(rs.getString("file_save_name"));
		    	  FileVO.setFileSize(rs.getInt("file_size"));
		    	  fileList.add(FileVO);
		      }
				
		   }catch (Exception e) {
		      e.printStackTrace();
		   }
		return fileList;
		
	}
	
	
}




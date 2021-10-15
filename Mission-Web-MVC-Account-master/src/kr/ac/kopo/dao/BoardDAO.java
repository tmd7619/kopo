package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {

	// 시퀀스를 가져온다.
	public int getSeq() {
		int result = 1;
		StringBuffer sql = new StringBuffer();
		// 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
		sql.append("SELECT ACCOUNT_BOARD_SEQ.NEXTVAL FROM DUAL");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			ResultSet rs = pstmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	} // end getSeq

	
	public void insert(BoardVO board) {
	      
	      StringBuilder sql = new StringBuilder();
	      
	      sql.append("insert into account_board(no, title, writer, content, Board_re_ref, board_parent) ");
	      sql.append(" values(?, ?, ?, ?, ?, ? ) ");
	      
	      try (
	            Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());   
	         ){   
	         
	         int boardNo = board.getNo();
	         int groupNo = board.getBoard_re_ref();
	         int parentNo = board.getBoard_parent();
	      
	         if(parentNo == 0) groupNo = boardNo; 
	         System.out.println("gropNo  :"+ groupNo);
	         System.out.println(boardNo);
	         System.out.println(parentNo);
	         
	         int loc = 1;
	         pstmt.setInt(loc++, boardNo);
	         pstmt.setString(loc++, board.getTitle());
	         pstmt.setString(loc++, board.getWriter());
	         pstmt.setString(loc++, board.getContent());
	         pstmt.setInt(loc++, groupNo);
	         pstmt.setInt(loc++, parentNo);
	         
	         pstmt.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public List<BoardVO> selectAll(HashMap<String, Object> listOpt) {
		   
	   List<BoardVO> boardList = new ArrayList<>();

	   	  int start = (Integer)listOpt.get("start"); // 현재 페이지번호
	      StringBuilder sql = new StringBuilder();
	      
          sql.append("SELECT * FROM");
          sql.append(" (SELECT  ROWNUM AS rnum, data.* FROM ");
          sql.append("    (SELECT LEVEL, no, writer,    title,");
          sql.append("            content,BOARD_COUNT,");
          sql.append("            BOARD_RE_REF, BOARD_PARENT, reg_date");
          sql.append("    FROM account_board");
          sql.append("    START WITH BOARD_PARENT = 0");
          sql.append("    CONNECT BY PRIOR no = BOARD_PARENT");
          sql.append("    ORDER SIBLINGS BY BOARD_RE_REF desc)");              
          sql.append(" data) ");
          sql.append("where rnum>=? and rnum<=?");


	      try(
	         Connection conn = new ConnectionFactory().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	      ) {
	         
	    	  pstmt.setInt(1, start);
              pstmt.setInt(2, start+9);
              
	         ResultSet rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            
	            BoardVO board = new BoardVO();
//	            board.setRowNum(rs.getInt("rowNumber"));
	            board.setNo(rs.getInt("no"));
	            board.setTitle(rs.getString("title"));
	            board.setContent(rs.getString("content"));
	            board.setWriter(rs.getString("writer"));
	            board.setBoard_re_lev(rs.getInt("LEVEL"));
	            board.setRegDate(rs. getString("reg_date"));
	            board.setBoard_count(rs.getInt("board_count"));
	            board.setBoard_re_ref(rs.getInt("Board_re_ref"));
	            board.setBoard_parent(rs.getInt("board_parent"));
	            
	            System.out.println(board);
	            
	            boardList.add(board);
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return boardList;
	   }

	public BoardVO getDetail(int boardNum) {
		BoardVO board = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select * from account_board where no = ?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setNo(boardNum);
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setBoard_count(rs.getInt("BOARD_COUNT"));
				board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
				board.setRegDate(rs.getString("reg_date"));
				board.setBoard_parent(rs.getInt("BOARD_PARENT"));
			}

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return board;
	} // end getDetail()




	public void deleteBoard(int no) {

		StringBuilder sql = new StringBuilder();
		sql.append(" delete from account_board where no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setInt(1, no);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateBoard(BoardVO board) {

		StringBuilder sql = new StringBuilder();
		sql.append(" update account_board set title = ? , content = ? where no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// 조회수 증가 
	public void updateCount(int boardNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			sql.append("update account_board set BOARD_COUNT = BOARD_COUNT+1 ");
			sql.append("where no = ?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);

			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				conn.commit(); // 완료시 커밋
			}
		} catch (Exception e) {
			try {
				conn.rollback(); // 오류시 롤백
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				JDBCClose.close(conn, pstmt);
			}
		}
	} // end updateCount

	
	
	// 글의 개수를 가져오는 메서드
    public int getBoardListCount(HashMap<String, Object> listOpt)
    {
        int result = 0;
        StringBuilder sql = new StringBuilder();
        
        sql.append("select count(*) from account_board");
        
        try (
        		Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        		)
        
        {
            
            ResultSet rs  = pstmt.executeQuery();
            if(rs.next())    result = rs.getInt(1);
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        return result;
        
    } 
    

}


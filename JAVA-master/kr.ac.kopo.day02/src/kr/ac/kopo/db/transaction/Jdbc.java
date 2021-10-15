package kr.ac.kopo.db.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.ac.kopo.util.JDBCClose;

public class Jdbc {

	
	
	public void transferAccount()  {

		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		StringBuilder sql = new StringBuilder(); // 내 계좌 출금 쿼리문
		StringBuilder sql2 = new StringBuilder(); // 상대방 계좌 입금 쿼리문
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "system";
			String password = "manager33";
			
			conn = DriverManager.getConnection(url,user,password);
			
			conn.setAutoCommit(false); // AutoCommit을 false로 변경
			
//-----------------------------------------------------------------------------------------------	
			sql.append("UPDATE HANA_BANK SET AMOUNT = AMOUNT - 10000 WHERE BANK_NO = 1 ");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.executeUpdate(); 
//-----------------------------------------------------------------------------------------------			
			sql2.append("UPDATE KB_BANK@TLINK SET AMOUNT = AMOUNT + 10000 WHERE BANK_NO = 1 ");
			pstmt2 = conn.prepareStatement(sql2.toString());
			
			pstmt2.executeUpdate() ;
			

			conn.commit(); // 계좌이체가 정상적으로 완료된 경우, 커밋 // 가장 마지막에 수행
			System.out.println("\t 계좌 이체가 정상적으로 완료되었습니다.");
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("\t계좌 이체가 정상적으로 완료되지 않았습니다. 다시 시도해주세요.");	
			}
			e.printStackTrace();
		}finally {
			JDBCClose.close(conn, pstmt);
		}
		

	}
	
	
}

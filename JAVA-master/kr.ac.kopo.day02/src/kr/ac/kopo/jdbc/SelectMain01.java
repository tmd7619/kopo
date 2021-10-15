package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class SelectMain01 {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			ConnectionFactory factory = new ConnectionFactory()	;
//			conn = factory.getConnection() ; 	
			
			conn = new ConnectionFactory().getConnection() ; 
			
			//3단계 실행객체 만들기
			String sql = "SELECT * FROM T_TEST ";
			pstmt = conn.prepareStatement(sql);  // ?자리가 없기 때문에 set메서드를 사용할 필요가 없다
			
			//4단계
			ResultSet rs = pstmt.executeQuery();			
			
			while(rs.next()) { // rs.next()가 false일때까지 반복문 수행 
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println("id : "+id + "  name : "+ name );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(conn, pstmt);	// 스태틱 메소드는 인스턴스 메서드처럼 객체 생성을 할 필요가 없다. -> 클래스명.메소드명 으로 실행
		}
		
	}
}

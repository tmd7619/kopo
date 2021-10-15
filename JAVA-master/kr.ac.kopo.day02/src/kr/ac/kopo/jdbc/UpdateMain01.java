package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 	아이디를 입력 : hong
 	수정할 이름을 입력 : 홍길순
 	 
 
 */

public class UpdateMain01 {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1단계

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2단계
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(url,user,password);
			
			// 3단계
			Scanner sc = new Scanner(System.in);
			System.out.printf("아이디를 입력  : ");
			String id = sc.nextLine();
			
			System.out.printf("수정할 이름 입력 : ");
			String name = sc.nextLine();
			/*
			String sql = "update t_test ";
				   sql += " set name = ? ";
				   sql += " where id = ? ";
			pstmt = conn.prepareStatement(sql);
			*/
			
			StringBuilder sql = new StringBuilder()	; // String은 변하지 않는 문자열이기 때문에, 좀더 유연하고 속도가 빠른 StringBuilder를 쓰는것이 더 좋다.
			sql.append("update t_ test " );			  // why ? 쿼리문의 변화가 자주 일어날 수 있기 때문 ( web에서도 StringBuilder를 선호 ) 
			sql.append(" set name = ? " );
			sql.append(" where id = ? " );
			
			pstmt = conn.prepareStatement(sql.toString()); // 
			
			pstmt.setString(1,name);
			pstmt.setString(2, id);
			
			// 4 단계
			int cnt = pstmt.executeUpdate()	;
			System.out.println(cnt + "개의 행을 수정했다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5단계
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e ) {
					e.printStackTrace();
				}
			}
		}

	}
}

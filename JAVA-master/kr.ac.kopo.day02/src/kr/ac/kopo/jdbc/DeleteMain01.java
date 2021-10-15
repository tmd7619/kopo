package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteMain01 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null ;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(url,user,password)	;
			
			System.out.print("삭제할 아이디 입력 : ");
			String id = sc.nextLine()	;
			
			String sql = "DELETE FROM T_TEST WHERE ID = ?  ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			int cnt = pstmt.executeUpdate()	;
			System.out.println(cnt + "개의 행을 수정");
			

		}catch(Exception e){
			e.printStackTrace();
		}finally {
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
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			sc.close();
		}
	}
}

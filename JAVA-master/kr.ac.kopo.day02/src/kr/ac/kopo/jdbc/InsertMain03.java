package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 * JDBC 작업 순서
 * 1. 드라이버 로딩 
 * 2. DB 접속 후 연결객체 얻기
 * 3. SQL문 실행할 객체 얻기 
 * 4. SQL문 실행 및 결과 얻기
 * 5. DB 접속 해제 
 */

// jdbc connection도 내부적으로 io 형태를 띄고 있다.

public class InsertMain03 {

	public static void main(String[] args) {
		
		Connection conn = null; // finally에서 close를 하기 위해 지역변수 escape
		PreparedStatement pstmt = null ;  // 일반 statement 보다 성능도 빠르다.
		Scanner sc = new Scanner(System.in);
		
		try {
			// 1단계 jdbc 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			// 2단계 db 연결 후 Connection 객체 얻기
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password); // 데이터베이스 연결
			System.out.println("conn : " + conn);
			
			System.out.print("아이디 입력 : ");
			String id = sc.nextLine();
			
			System.out.printf("이름을 입력 : ");
			String name = sc.nextLine()	;
			
			// 3단계 sql 실행객체 얻기
			String sql = "insert into t_test(id,name) ";
				   sql += " values(?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // values의 첫번째 ?에 자동으로 ' ' 를 붙여줌
			pstmt.setString(2, name);
			
			// 4단계 SQL문 실행 및 결과 얻기
			int cnt = pstmt.executeUpdate()	;
			System.out.println(cnt + "개 행 삽입 ");
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//항상 close는 열려있는 역순으로 실행
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
				conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			sc.close(); // 스캐너도 외부장치이기 때문에, close를 같이 써줘야함
		}

	}
}

package kr.ac.kopo.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
 
public class InsertMain02 {

	public static void main(String[] args) {
		
		Connection conn = null; // finally에서 close를 하기 위해 지역변수 escape
		Statement stmt = null ; 
		Scanner sc = new Scanner(System.in);
		
		try {
			// 1단계 jdbc 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			// 2단계 db 연결 후 Connection 객체 얻기
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn : " + conn);
			
			System.out.print("아이디 입력 : ");
			String id = sc.nextLine();
			
			System.out.printf("이름을 입력 : ");
			String name = sc.nextLine()	;

			
			// 3단계 sql 실행객체 얻기
			stmt = conn.createStatement();
			String sql = "insert into t_test(id, name) "; //습관적으로 "옆에 공백을 넣어주자 쿼리문 실행시, FROMT_TEST 처럼 형식에러날 수 있음.
            sql += " values('" + id + "', '" + name + "') ";
			// 4단계 SQL문 실행 및 결과 얻기
			int cnt = stmt.executeUpdate(sql);
			System.out.println("총" + cnt + "개 행 삽입");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//항상 close는 열려있는 역순으로 실행
			if(stmt != null) {
				try {
				stmt.close();
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

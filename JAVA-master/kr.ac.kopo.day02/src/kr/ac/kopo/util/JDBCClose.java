package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.Statement;

/*
 * DB접속했을시, close를 시키는 클래스
 * 
 */

public class JDBCClose {

	public static void close(Connection conn, Statement pstmt) {  // 인자명을 pstmt를 쓰게 되면, 스태틱 메소드 실행시 인자값 변경필요가 없음 (pstmt쓸때)
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
	}
}

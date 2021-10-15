package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTestMain {

	public static void main(String[] args) {
		
		// 1단계 : JDBC 드라이버 로딩
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공 ....");
		
		// 2단계 : DB 접속 및 연결객체 얻기
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.119.119:1521:dink","scott","tiger");
		System.out.println("DB접속 성공 : " + conn);
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}
}

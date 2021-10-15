package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 
 * db를 연결해서 연결객체를 가져오는 클래스
 * 
 */

public class ConnectionFactory {
		
	public Connection getConnection() {
		Connection conn = null;
		try {
		//1단계
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		//2단계
		String url ="jdbc:oracle:thin:@192.168.119.119:1521:dink";
		String user = "scott";
		String password ="tiger";
		
		conn = DriverManager.getConnection(url,user,password);
		} catch(Exception e ) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
}

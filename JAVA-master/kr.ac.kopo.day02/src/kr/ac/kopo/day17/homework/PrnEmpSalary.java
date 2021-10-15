package kr.ac.kopo.day17.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class A implements AutoCloseable{

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("close()완료");
		
	}

}


public class PrnEmpSalary {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0 ;
		
		StringBuilder sql = new StringBuilder()	;
		sql.append("SELECT J.JOB_TITLE ,AVG(E.SALARY) AS AVG " );			
		sql.append(" FROM EMPLOYEES E , JOBS J " );
		sql.append(" WHERE E.JOB_ID = J.JOB_ID AND E.SALARY >= ? " );
		sql.append(" GROUP BY J.JOB_TITLE " );
		sql.append(" ORDER BY AVG DESC " );
		while(true) {
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			String url = "jdbc:oracle:thin:@192.168.217.57:1522:xe";
			String user = "hr";
			String password = "hr";
			
			conn = DriverManager.getConnection(url,user,password);
			pstmt = conn.prepareStatement(sql.toString());
			
			System.out.printf("급여를 입력하시오  : ");
			String salary = sc.nextLine();
			
			pstmt.setString(1, salary);
			ResultSet rs = pstmt.executeQuery()	;
			while(rs.next()) { // rs.next()가 false일때까지 반복문 수행 
				String job_title = rs.getString("JOB_TITLE");
				String avg = rs.getString("AVG");
				System.out.println("직무 : "+job_title + "  직무별 평균 급여 : "+ avg );
				cnt ++;
			}
			System.out.println("총 "+"["+cnt+"]"+"명이 검색되었습니다.");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		
		
	}

}

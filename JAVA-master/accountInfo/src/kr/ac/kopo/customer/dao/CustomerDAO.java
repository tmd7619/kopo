package kr.ac.kopo.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.customer.vo.Customer;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;


public class CustomerDAO {
	
	//회원가입
	   public void register(Customer customer) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         //연결
	         conn = new ConnectionFactory().getConnection();
	         
	         //쿼리생성
	         StringBuilder sql = new StringBuilder();
	         sql.append("insert into bank_customer(id, pwd, name, birth) ");
	         sql.append(" values( ?, ?, ?, ?) ");      
	         
	         pstmt = conn.prepareStatement(sql.toString());
	         pstmt.setString(1, customer.getId());
	         pstmt.setString(2, customer.getPwd());
	         pstmt.setString(3, customer.getName());
	         pstmt.setString(4, customer.getBirth());
	         
	         //쿼리실행
	         pstmt.executeQuery();
	         System.out.println();
	         System.out.println("\t회원가입이 완료되었습니다.");
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCClose.close(conn, pstmt);
	      }
	   }

	   //로그인
	   public Customer login(String id, String pwd) {
		  Customer customer = null;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         //연결
	         conn = new ConnectionFactory().getConnection();
	         
	         //쿼리생성
	         StringBuilder sql = new StringBuilder();
	         sql.append("select * ");
	         sql.append(" FROM BANK_CUSTOMER ");
	         sql.append(" where id = ? and pwd = ? ");
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setString(1, id);
	         pstmt.setString(2, pwd);
	         
	         //쿼리실행
	         ResultSet rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            customer = new Customer();
	            customer.setId(rs.getString("id"));
	            customer.setPwd(rs.getString("pwd"));
	            customer.setName(rs.getString("name"));
	            customer.setBirth(rs.getString("birth"));
	            customer.setRegdate(rs.getString("regdate"));
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCClose.close(conn, pstmt);
	      }
	      return customer;
	   }
	   
	   // 아이디 중복체크
	   public Customer overlapCheck(String id) {
		   Customer customer = null;
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      try {
			         //연결
			         conn = new ConnectionFactory().getConnection();
			         
			         //쿼리생성
			         StringBuilder sql = new StringBuilder();
			         sql.append("select id ");
			         sql.append(" FROM BANK_CUSTOMER ");
			         sql.append(" where id = ? ");
			         pstmt = conn.prepareStatement(sql.toString());
			         
			         pstmt.setString(1, id);
			         
			         //쿼리실행
			         ResultSet rs = pstmt.executeQuery();
			         
			         if(rs.next()) {
			            customer = new Customer();
			            customer.setId(rs.getString("id"));
			            
			         }
			         
			      } catch (Exception e) {
			      } finally {
			         JDBCClose.close(conn, pstmt);
			      }
			      return customer;
			   }	
	   
	   
	   

}

package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;

public class MemberDAO {
	
	
	public MemberVO login(MemberVO memberVO) {
		
		
		MemberVO userVO = null;
		
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id , name , type, password, phone ") ; 
		sql.append(" from ACCOUNT_MEMBER ");
		sql.append(" where id = ? and password = ? ");
		
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				userVO = new MemberVO();
				userVO.setPassword(rs.getString("password"));
				userVO.setId(rs.getString("id"));
				userVO.setName(rs.getString("name"));
				userVO.setType(rs.getString("type"));
				userVO.setPhone(rs.getString("phone"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return userVO;
		
	}
	
	
	public void register(MemberVO memberVO) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" insert into account_member(id,password, ");
		sql.append(" name, birth, phone, email, address) ");
		sql.append(" values(?, ?, ?, ?, ?, ?, ? ) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getBirth());
			pstmt.setString(5, memberVO.getPhone());
			pstmt.setString(6, memberVO.getEmail());
			pstmt.setString(7, memberVO.getAddress());
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public MemberVO kakaoLogin(String kakaoId) {
		
		MemberVO userVO = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id , name , type, password ") ; 
		sql.append(" from ACCOUNT_MEMBER ");
		sql.append(" where id = ?  ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, kakaoId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				userVO = new MemberVO();
				userVO.setPassword(rs.getString("password"));
				userVO.setId(rs.getString("id"));
				userVO.setName(rs.getString("name"));
				userVO.setType(rs.getString("type"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return userVO;
		
	}
	
	public String idOverlapCheck(String id) { // 아이디 중복 체크 method
		
		String temp = "0";
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id , name , type, password ") ; 
		sql.append(" from ACCOUNT_MEMBER ");
		sql.append(" where id = ?  ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				temp ="1"; // 해당 아이디가 존재하면, temp = 1 값 리턴 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	
	

}

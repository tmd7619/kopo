package kr.ac.kopo.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.util.ConnectionFactory;

public class MemberDAO {
	
	/**
	 * 사용자가 입력한 id , password로 로그인 여부를 판단 
	 * @return 해당 LoginVO
	 * @param loginVO 로그인시 입력한 id, password를 포함
	 */
	
	public MemberVO login(MemberVO memberVO) { // 매개변수 형태로 날라와도 되고,객체형태로 날라와도 됨
		
		MemberVO userVO = null;
		
		StringBuilder sql = new StringBuilder(); // 1.7버전 try/catch구문에서는 try안에 StringBuilder형의 sql을 넣을 수 없다.
		sql.append("select id, name, type " ); // password 정보를 굳이 가져올 필요 없음 //
		sql.append(" from t_member ");
		sql.append( " where id = ? and password = ?");
		
		try( 
				// 1.7버전의 try/catch구문 // autocloseable를 상속받아, 자동으로 close해줌
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {  
			
				pstmt.setString(1, memberVO.getId());
				pstmt.setString(2, memberVO.getPassword());
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					userVO = new MemberVO();
					userVO.setId(rs.getString("id"));
					userVO.setName(rs.getString("name"));
					userVO.setType(rs.getString("type"));
					
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userVO;
	}
	
	public List<MemberVO> selectAll(){ // 회원 전체조회
		
		List<MemberVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select id, name, type, to_char(reg_date,'yyyy-mm-dd') as reg_date ");
		sql.append(" from t_member order by reg_date desc ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				)
		{
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			MemberVO member = new MemberVO();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setType(rs.getString("type"));	
			member.setRegDate(rs.getString("reg_date"));
			list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public MemberVO selectOne(String userId) {
		
		MemberVO member = new MemberVO();
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name, password, email_id, email_domain, ");
		sql.append(" tel1,tel2,tel3,post,basic_addr,detail_addr, type  ");
		sql.append("     , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_member ");
		sql.append(" where id = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			member.setId(rs.getString("id"));
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
			member.setEmailId(rs.getString("email_id"));
			member.setEmailDomain(rs.getString("email_domain"));
			member.setTel1(rs.getString("tel1"));
			member.setTel2(rs.getString("tel2"));
			member.setTel3(rs.getString("tel3"));
			member.setPost(rs.getString("post"));
			member.setDetailAddr(rs.getString("detail_addr"));
			member.setType(rs.getString("type"));
			member.setRegDate(rs.getString("reg_date"));
			member.setBasicAddr(rs.getString("basic_addr"));
		} catch (Exception e) {
		}
		
		return member;
	}
	
	public void register(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
	    sql.append("insert into t_member(id,password,name,email_id,email_domain, " );
	    sql.append(" tel1,tel2,tel3,post,basic_addr,detail_addr) ");
	    sql.append(" values(?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ? )");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
		    pstmt.setString(1,member.getId());
		    pstmt.setString(2,member.getPassword());
		    pstmt.setString(3,member.getName());
		    pstmt.setString(4,member.getEmailId());
		    pstmt.setString(5,member.getEmailDomain());
		    pstmt.setString(6,member.getTel1());
		    pstmt.setString(7,member.getTel2());
		    pstmt.setString(8,member.getTel3());
		    pstmt.setString(9,member.getPost());
		    pstmt.setString(10,member.getBasicAddr());
		    pstmt.setString(11,member.getDetailAddr());
			
		    pstmt.executeQuery();
		    
		    
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
	
	
	
}

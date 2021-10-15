package kr.ac.kopo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.TransactionVO;

public class AccountDAO {

	
	
	public List<AccountVO> selectAll(String userId) {

		StringBuilder sql = new StringBuilder();
		
		List<AccountVO> list = new ArrayList<>();
		sql.append("select accountno, holder, balance, account_nickname, to_char(reg_date,'yyyy-mm-dd') as reg_date ");
		sql.append(" from t_account ");
		sql.append(" where id = ? ");
		
		sql.append(" order by reg_date desc ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
						
				AccountVO account = new AccountVO();
				account.setNo(rs.getString("accountno"));
				account.setHolder(rs.getString("holder"));
				account.setBalance(rs.getInt("balance"));
				account.setRegDate(rs.getString("reg_date"));
				account.setNickName(rs.getString("account_nickname"));
				
				list.add(account);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	public void openAccount(MemberVO userVO, AccountVO accountVO) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into t_account(accountno, password, holder, account_nickname, id )" );
		sql.append(" values(? , ? , ? , ? , ?)");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
		
		pstmt.setString(1, accountVO.getNo());
		pstmt.setInt(2, accountVO.getPassword());
		pstmt.setString(3, userVO.getName());
		pstmt.setString(4, accountVO.getNickName());
		pstmt.setString(5, userVO.getId());
		
		pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public boolean transfer(AccountVO myAccount, int amount, TransactionVO receiverAccount ) {
		
		boolean check = false;
		Connection conn = null;
		
		StringBuilder sql = new StringBuilder();
	   int result =0;
		
		sql.append(" {call exec_transfer(?, ?, ?, ?, ?, ?)} ");


		try{
		
		conn = new ConnectionFactory().getConnection();
		conn.setAutoCommit(false); // AutoCommit을 false로 변경
		
		CallableStatement cstmt = conn.prepareCall(sql.toString());
		
		cstmt.setString(1, receiverAccount.getTranAccount());
		cstmt.setInt(2, amount);
		cstmt.setString(3, receiverAccount.getTranBankname());
		cstmt.setString(4, receiverAccount.getTranHolder());
		cstmt.setString(5, myAccount.getNo());
	    cstmt.registerOutParameter(6, java.sql.Types.INTEGER);	
		cstmt.executeUpdate();
		
		conn.commit(); // 두 프로시저 모두 정상적으로 처리될 경우, commit;
		check = true;  // 정상적으로 완료되었기 때문에, check = true 변경
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		return check;
	}
	
	
	
	public boolean withdraw(AccountVO account , int amount) {
		
		
		boolean check = false;
		Connection conn = null;
		
		StringBuilder sql = new StringBuilder();
		StringBuilder sql2 = new StringBuilder();
		
		sql.append(" update t_account set balance = balance -  ? where accountno = ? and password = ? ");		
		sql2.append(" insert into transaction_history(tran_idx , tran_myaccount, tran_type , tran_amount ,   ");		
		sql2.append(" tran_mybalance) values(trans_seq.nextval , ? , ? , ? ,  ");
		sql2.append(" (select balance from t_account where accountno = ? )) ");
		
		
		try{
			
		conn = new ConnectionFactory().getConnection();
		conn.setAutoCommit(false); // AutoCommit을 false로 변경
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, amount);
		pstmt.setString(2, account.getNo());
		pstmt.setInt(3, account.getPassword());
		
		pstmt.executeUpdate();
		
		
		PreparedStatement pstmt2 = conn.prepareStatement(sql2.toString());
		
		pstmt2.setString(1, account.getNo());
		pstmt2.setString(2, "거래출금");
		pstmt2.setInt(3, amount);
		pstmt2.setString(4, account.getNo());
		
		pstmt2.executeUpdate();
		
		conn.commit(); // 두 쿼리문 모두 정상적으로 처리될 경우, commit;
		check = true;  // 정상적으로 완료되었기 때문에, check = true 변경
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return check;
	}
	
	public boolean deposit(AccountVO account , int amount) {
		
		
		boolean check = false;
		Connection conn = null;
		
		StringBuilder sql = new StringBuilder();
		StringBuilder sql2 = new StringBuilder();
		StringBuilder sql3 = new StringBuilder();
		
		sql.append(" update t_account set balance = balance +  ? where accountno = ? and password = ? ");	
		
		sql2.append(" insert into transaction_history(tran_idx , tran_myaccount, tran_type , tran_amount ,   ");		
		sql2.append(" tran_mybalance) values(trans_seq.nextval , ? , ? , ? ,  ");
		sql2.append(" (select balance from t_account where accountno = ? )) ");
		
		
		try{
			
		conn = new ConnectionFactory().getConnection();
		conn.setAutoCommit(false); // AutoCommit을 false로 변경
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, amount);
		pstmt.setString(2, account.getNo());
		pstmt.setInt(3, account.getPassword());
		
		pstmt.executeUpdate();
		
		
		PreparedStatement pstmt2 = conn.prepareStatement(sql2.toString());
		
		pstmt2.setString(1, account.getNo());
		pstmt2.setString(2, "거래입금");
		pstmt2.setInt(3, amount);
		pstmt2.setString(4, account.getNo());
		
		pstmt2.executeUpdate();
		
		conn.commit(); // 두 쿼리문 모두 정상적으로 처리될 경우, commit;
		check = true;  // 정상적으로 완료되었기 때문에, check = true 변경
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return check;
	}	
	
	
	public void update(String newNickName, String accountNo) {
		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" update t_account set account_nickname = ? where accountNo = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
		
		pstmt.setString(1, newNickName);
		pstmt.setString(2, accountNo);
			
		pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<AccountVO> selectByOtherBank(String phoneNum){
		
		
		List<AccountVO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		StringBuilder sql2 = new StringBuilder();
		StringBuilder sql3 = new StringBuilder();
		
		// YR 뱅크 조회
		sql.append(" select accountno, account_pwd, bank_code, account_owner, balance, account_nickname, to_char(open_acc_date,'yyyy-mm-dd') as reg_date ");
		sql.append(" from t_account@yr a, member_tbl@yr b ");
		sql.append(" where a.user_id = b.id and b.tel= ?  ");
		
		// JH 뱅크 조회
		sql2.append(" select accountno , b.name as holder, balance, alias as account_nickname, to_char(opendate,'yyyy-mm-dd') as open_date ");
		sql2.append(" from t_member@jh a, t_account@jh b  ");
		sql2.append(" where a.id = b.id and a.tel = ? ");
		
		
		// SJ 뱅크 조회
		sql3.append(" select  accountno,  b.name as holder, t.alias as account_nickname, balance, to_char(b.reg_date,'yyyy-mm-dd') as open_date ");
		sql3.append(" from banking_login@sj b , t_account@sj t ");
		sql3.append(" where b.banking_id = t.banking_id and b.phone_no = ?  ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				PreparedStatement pstmt2 = conn.prepareStatement(sql2.toString());
				PreparedStatement pstmt3 = conn.prepareStatement(sql3.toString());
			) 
		{
			
			pstmt.setString(1, phoneNum);
			pstmt2.setString(1, phoneNum);
			pstmt3.setString(1, phoneNum+"  ");
			
			ResultSet rs = pstmt.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();
			ResultSet rs3 = pstmt3.executeQuery();
			
			while (rs.next()) {
						
				AccountVO account = new AccountVO();
				account.setNo(rs.getString("accountno"));
				account.setHolder(rs.getString("account_owner"));
				account.setBalance(rs.getInt("balance"));
				account.setRegDate(rs.getString("reg_date"));
				account.setNickName(rs.getString("account_nickname"));
				
				list.add(account);

			}
			
			while (rs2.next()) {
				
				AccountVO account = new AccountVO();
				account.setNo(rs2.getString("accountno"));
				account.setHolder(rs2.getString("holder"));
				account.setBalance(rs2.getInt("balance"));
				account.setRegDate(rs2.getString("open_date"));
				account.setNickName(rs2.getString("account_nickname"));
				list.add(account);

			}
			
			while (rs3.next()) {
				
				AccountVO account3 = new AccountVO();
				account3.setNo(rs3.getString("accountno"));
				account3.setHolder(rs3.getString("holder"));
				account3.setBalance(rs3.getInt("balance"));
				account3.setRegDate(rs3.getString("open_date"));
				account3.setNickName(rs3.getString("account_nickname"));
				
				list.add(account3);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
		
	}
	
	
}

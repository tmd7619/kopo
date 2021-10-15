package kr.ac.kopo.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.account.vo.Account;
import kr.ac.kopo.account.vo.Transaction;
import kr.ac.kopo.customer.ui.CustomerBaseUI;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class AccountDAO {

	public List<Account> searchAll() throws Exception { // 전체 계좌 조회

		List<Account> list = new ArrayList<Account>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();

		try {

			conn = new ConnectionFactory().getConnection();
			sql.append("select account, bankname, customer_name, balance, ");
			sql.append(" nvl(nickname,'없음') as nickname, customer_id, TO_CHAR(credate,'YY/MM/DD') ");
			sql.append(" from account_info where customer_id = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, CustomerBaseUI.getCustomer().getId());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setAccount(rs.getString("account"));
				account.setBankName(rs.getString("bankname"));
				account.setCustomerName(rs.getString("customer_name"));
				account.setBalance(rs.getString(4));
				account.setNickname(rs.getString(5));
				account.setCustomerID(rs.getString(6));
				account.setCredate(rs.getString(7));

				list.add(account);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return list;
	}

	public List<Account> searchBank(String bankName) throws Exception { // 은행별 계좌 조회

		List<Account> list = new ArrayList<Account>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = new ConnectionFactory().getConnection();
			sql.append("select account, bankname, customer_name, balance, ");
			sql.append(" nvl(nickname,'없음') as nickname, customer_id, TO_CHAR(credate,'YY/MM/DD') as credate ");
			sql.append(" from account_info where customer_id = ? and  ");
			sql.append(" bankname = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, CustomerBaseUI.getCustomer().getId());
			pstmt.setString(2, bankName);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setAccount(rs.getString(1));
				account.setBankName(rs.getString(2));
				account.setCustomerName(rs.getString(3));
				account.setBalance(rs.getString(4));
				account.setNickname(rs.getString(5));
				account.setCustomerID(rs.getString(6));
				account.setCredate(rs.getString("credate"));

				list.add(account);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);

		}
		return list;

	}

	public Account searchAccount(String accountNum) throws Exception { // 계좌번호로 게좌 조회

		List<Account> list = new ArrayList<Account>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		Account account = new Account();
		
		try {
			conn = new ConnectionFactory().getConnection();
			sql.append("select account, bankname, customer_name, balance, ");
			sql.append(" nvl(nickname,'없음') as nickname, customer_id, TO_CHAR(credate,'YY/MM/DD') as credate  ");
			sql.append(" from account_info where customer_id = ? and ");
			sql.append(" account = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, CustomerBaseUI.getCustomer().getId());
			pstmt.setString(2, accountNum);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				account.setAccount(rs.getString(1));
				account.setBankName(rs.getString(2));
				account.setCustomerName(rs.getString(3));
				account.setBalance(rs.getString(4));
				account.setNickname(rs.getString(5));
				account.setCustomerID(rs.getString(6));
				account.setCredate(rs.getString("credate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);

		}
		return account;

	}

	public boolean updateNickname(String nicknameAccountNum, String nickname) { // 별칭 설정
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		boolean check = false;
		
		try {
			conn = new ConnectionFactory().getConnection();
			sql.append("update account_info set nickname = ? where customer_id = ? and  account = ?  ");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, nickname);
			pstmt.setString(2, CustomerBaseUI.getCustomer().getId());
			pstmt.setString(3, nicknameAccountNum);

			pstmt.executeUpdate();
			check = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return check;
	}
	
	public int deposit(String amount, String accountNum) { // 계좌 입금
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		StringBuilder sql = new StringBuilder();
		StringBuilder sql2 = new StringBuilder();
		
		int check = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			sql.append("update account_info set balance = balance + ? where customer_id = ? and account = ?  ");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, Integer.parseInt(amount));
			pstmt.setString(2, CustomerBaseUI.getCustomer().getId());
			pstmt.setString(3, accountNum);

			pstmt.executeUpdate(); // 성공하면 1 이상, 실패하면 0을 리턴
			
			sql2.append(" INSERT INTO TRANSACTION_HISTORY(TID,TRAN_ACCOUNT,TRAN_TYPE,TRAN_AMOUNT,TRAN_BANKNAME,TRAN_BALANCE) " );
			sql2.append(" VALUES(TRAN_SEQ.NEXTVAL, ? , ? , ? , " );
			sql2.append(" (SELECT BANKNAME FROM ACCOUNT_INFO WHERE ACCOUNT = ? ) , " );
			sql2.append(" (SELECT BALANCE FROM ACCOUNT_INFO WHERE ACCOUNT = ? )) " );
			
			pstmt2 = conn.prepareStatement(sql2.toString());

			
			pstmt2.setString(1, accountNum);
			pstmt2.setString(2, "계좌입금");
			pstmt2.setInt(3, Integer.parseInt(amount));
			pstmt2.setString(4, accountNum);
			pstmt2.setString(5, accountNum);
			
			pstmt2.executeUpdate();
			check++;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return check;
		
	}
	
	public int withdraw(String amount, String accountNum) { // 출금
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		StringBuilder sql = new StringBuilder();
		StringBuilder sql2 = new StringBuilder();
		int check = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			sql.append("update account_info set balance = balance - ? where customer_id = ? and account = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, Integer.parseInt(amount));
			pstmt.setString(2, CustomerBaseUI.getCustomer().getId());
			pstmt.setString(3, accountNum);
	
			pstmt.executeUpdate(); // 성공하면 1 이상, 실패하면 0을 리턴
			
			sql2.append(" INSERT INTO TRANSACTION_HISTORY(TID,TRAN_ACCOUNT,TRAN_TYPE,TRAN_AMOUNT,TRAN_BANKNAME,TRAN_BALANCE) " );
			sql2.append(" VALUES(TRAN_SEQ.NEXTVAL, ? , ? , ? , " );
			sql2.append(" (SELECT BANKNAME FROM ACCOUNT_INFO WHERE ACCOUNT = ? ) , " );
			sql2.append(" (SELECT BALANCE FROM ACCOUNT_INFO WHERE ACCOUNT = ? )) " );
			
			pstmt2 = conn.prepareStatement(sql2.toString());

			
			pstmt2.setString(1, accountNum);
			pstmt2.setString(2, "계좌출금");
			pstmt2.setInt(3, Integer.parseInt(amount));
			pstmt2.setString(4, accountNum);
			pstmt2.setString(5, accountNum);
			
			pstmt2.executeUpdate();

			check++;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return check;
	}
	
		
	

	public Account openAccount(Account newAccount) { // 계좌개설
		
		Connection conn  = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		
		try {
			conn = new ConnectionFactory().getConnection();
			sql.append(" INSERT INTO ACCOUNT_INFO(ACCOUNT,BANKNAME,CUSTOMER_NAME,CUSTOMER_ID,NICKNAME) ");
			sql.append(" VALUES(? , ?, ? ,?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,newAccount.getAccount());
			pstmt.setString(2,newAccount.getBankName());
			pstmt.setString(3,CustomerBaseUI.getCustomer().getName());
			pstmt.setString(4,CustomerBaseUI.getCustomer().getId());
			pstmt.setString(5, newAccount.getNickname());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCClose.close(conn, pstmt);
			
		}
		return newAccount;
	}
	
	public String compareDate() { // 가장 최근에 생성한 계좌의 날짜정보 가져오기
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		String latelyDate = null;
		try {
			conn = new ConnectionFactory().getConnection();
			sql.append("SELECT credate FROM (SELECT CREDATE,CUSTOMER_ID FROM ACCOUNT_INFO ORDER BY CREDATE DESC) A  ");
			sql.append(" WHERE ROWNUM =1 AND CUSTOMER_ID = ?  ");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, CustomerBaseUI.getCustomer().getId());
			
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
			
				latelyDate = rs.getString("credate");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(conn, pstmt);
		}
		return latelyDate;
	}

	public String overlapCheck(String checkNum) { // 계좌번호 중복체크
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		String check = null;
		try {
			conn = new ConnectionFactory().getConnection();
			sql.append("SELECT ACCOUNT FROM ACCOUNT_INFO   ");
			sql.append(" WHERE ACCOUNT = ? AND CUSTOMER_ID = ?  ");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, checkNum);
			pstmt.setString(2, CustomerBaseUI.getCustomer().getId());
			
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
			
				check = rs.getString("account");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(conn, pstmt);
		}
		return check;
		
	}

	public boolean deleteAccount(String deleteAccountNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		boolean check = false;
		
		try {
			conn = new ConnectionFactory().getConnection();
			sql.append("DELETE FROM ACCOUNT_INFO WHERE CUSTOMER_ID = ? AND ACCOUNT = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, CustomerBaseUI.getCustomer().getId());
			pstmt.setString(2, deleteAccountNum);
			
			pstmt.executeUpdate(); 
			check = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(conn, pstmt);
		}
		return check;
		
	}

	public void transferAccount(String senderAccountNum, String receiverBankName, String receiverAccountNum,  // 계좌이체
			String transferAmount)  {

		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		StringBuilder sql = new StringBuilder(); // 내 계좌 출금 쿼리문
		StringBuilder sql2 = new StringBuilder(); // 상대방 계좌 입금 쿼리문
		StringBuilder sql3 = new StringBuilder();
		boolean bool = false;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false); // AutoCommit을 false로 변경
			
			sql.append("UPDATE ACCOUNT_INFO SET BALANCE = BALANCE - ? WHERE CUSTOMER_ID = ? and account = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, Integer.parseInt(transferAmount));
			pstmt.setString(2, CustomerBaseUI.getCustomer().getId());
			pstmt.setString(3, senderAccountNum);
			
			pstmt.executeUpdate(); 
//-----------------------------------------------------------------------------------------------			
			sql2.append("UPDATE ACCOUNT_INFO SET BALANCE = BALANCE + ? WHERE  account = ? ");
			pstmt2 = conn.prepareStatement(sql2.toString());
			pstmt2.setInt(1, Integer.parseInt(transferAmount));
			pstmt2.setString(2, receiverAccountNum);
			
			pstmt2.executeUpdate() ;
//-----------------------------------------------------------------------------------------------			
			sql3.append("INSERT ALL INTO TRANSACTION_HISTORY(TID, " );
			sql3.append(" TRAN_ACCOUNT,TRAN_TYPE,TRAN_AMOUNT,TRAN_BANKNAME,TRAN_BALANCE) " );
			sql3.append(" VALUES(TRAN_SEQ.NEXTVAL, ? , ? , ? ,(SELECT BANKNAME FROM ACCOUNT_INFO WHERE ACCOUNT = ?) , " );
			sql3.append(" (SELECT BALANCE FROM ACCOUNT_INFO WHERE ACCOUNT = ? )) " );
			sql3.append(" INTO TRANSACTION_HISTORY(TID,TRAN_ACCOUNT,TRAN_TYPE,TRAN_AMOUNT,TRAN_BANKNAME,TRAN_BALANCE) " );
			sql3.append(" VALUES(TRAN_SEQ.NEXTVAL, ? , ? , ? , ? ,  " );
			sql3.append(" (SELECT BALANCE FROM ACCOUNT_INFO WHERE ACCOUNT = ? )) " );
			sql3.append(" SELECT * FROM DUAL ");
			pstmt3 = conn.prepareStatement(sql3.toString());
			
			pstmt3.setString(1, senderAccountNum);
			pstmt3.setString(2, "이체출금");
			pstmt3.setInt(3, Integer.parseInt(transferAmount));
			pstmt3.setString(4, senderAccountNum);
			pstmt3.setString(5, senderAccountNum);
			
			pstmt3.setString(6, receiverAccountNum);
			pstmt3.setString(7, "이체입금");
			pstmt3.setInt(8, Integer.parseInt(transferAmount));
			pstmt3.setString(9, receiverBankName);
			pstmt3.setString(10, receiverAccountNum);
			
			pstmt3.executeUpdate() ;

			
			

			conn.commit(); // 계좌이체가 정상적으로 완료된 경우, 커밋 // 가장 마지막에 수행
			bool = true;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("\t계좌 이체가 정상적으로 완료되지 않았습니다. 다시 시도해주세요.");	
			}
			e.printStackTrace();
		}finally {
			JDBCClose.close(conn, pstmt);
		}
		

	}

	public boolean checkBalance(String senderAccountNum, String transferAmount) { // 잔액체크
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		boolean bool = false;
		int check  = 0;
		try {
			conn = new ConnectionFactory().getConnection();
			sql.append("SELECT balance - ? as balance FROM ACCOUNT_INFO WHERE CUSTOMER_ID = ? and account = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, transferAmount);
			pstmt.setString(2, CustomerBaseUI.getCustomer().getId());
			pstmt.setString(3, senderAccountNum);
			
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
			
				check = rs.getInt("balance");	
				
			}
			
			if(check > 0) {
				bool = true;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return bool;
		
	}

	public Account searchOtderAccount(String receiverAccountNum) {
		Account account = new Account();
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = new ConnectionFactory().getConnection();
			sql.append("select account, bankname, customer_name, balance, ");
			sql.append(" nvl(nickname,'없음') as nickname, customer_id, TO_CHAR(credate,'YY/MM/DD') as credate  ");
			sql.append(" from account_info where account = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, receiverAccountNum);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				account = new Account();
				account.setAccount(rs.getString(1));
				account.setBankName(rs.getString(2));
				account.setCustomerName(rs.getString(3));
				account.setBalance(rs.getString(4));
				account.setNickname(rs.getString(5));
				account.setCustomerID(rs.getString(6));
				account.setCredate(rs.getString("credate"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);

		}
		return account;
	}

	public List<Transaction> searchTransaction() { // 거래내역 조회하기
		List<Transaction> list = new ArrayList<Transaction>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();


		try {

			conn = new ConnectionFactory().getConnection();
			sql.append("SELECT T.TID,T.TRAN_BANKNAME,T.TRAN_ACCOUNT,T.TRAN_TYPE,T.TRAN_AMOUNT , T.TRAN_BALANCE, ");
			sql.append("  T.TRAN_DATE FROM ACCOUNT_INFO A , TRANSACTION_HISTORY T ");
			sql.append(" WHERE A.ACCOUNT = T.TRAN_ACCOUNT AND A.CUSTOMER_ID = ? ORDER BY T.TRAN_DATE DESC  ");

			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, CustomerBaseUI.getCustomer().getId());

			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setTranId(rs.getString("TID"));
				transaction.setTranBankname(rs.getString("TRAN_BANKNAME"));
				transaction.setTranAccount(rs.getString("TRAN_ACCOUNT"));
				transaction.setTranType(rs.getString("TRAN_TYPE"));
				transaction.setTranAmount(rs.getString("TRAN_AMOUNT"));
				transaction.setTranBalance(rs.getString("TRAN_BALANCE"));
				transaction.setTranDate(rs.getString("TRAN_DATE"));
				list.add(transaction);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return list;
	}
	
	
	
	
	

}

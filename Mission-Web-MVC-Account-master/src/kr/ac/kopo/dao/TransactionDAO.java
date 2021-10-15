package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.TransactionVO;

public class TransactionDAO {
	
	
	public List<TransactionVO> selectByAccountNo(String accountNo) {

		List<TransactionVO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select TRAN_IDX, TRAN_MYACCOUNT, TRAN_ACCOUNT, TRAN_TYPE, to_char(TRAN_DATE,'yyyy-mm-dd') as TRAN_DATE ,  ");
		sql.append(" TRAN_AMOUNT, TRAN_MYBALANCE, TRAN_BANKNAME, TRAN_HOLDER ");
		sql.append(" from transaction_history ");
		sql.append(" where TRAN_MYACCOUNT = ? ");
 		sql.append(" order by TRAN_IDX desc ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			
			pstmt.setString(1, accountNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
						
				TransactionVO transaction = new TransactionVO();
				transaction.setTranIdx(rs.getInt("tran_idx"));
				transaction.setTranMyAccount(rs.getString("tran_myaccount"));
				transaction.setTranAccount(rs.getString("tran_account"));
				transaction.setTranType(rs.getString("tran_type"));
				transaction.setTranDate(rs.getString("tran_date"));
				transaction.setTranAmount(rs.getInt("tran_amount"));
				transaction.setTranBalance(rs.getInt("tran_mybalance"));
				transaction.setTranBankname(rs.getString("tran_bankname"));
				transaction.setTranHolder(rs.getString("tran_holder")); // 상대방 예금주
				
				
				list.add(transaction);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	public List<TransactionVO> selectByOtherBank(String accountNo){
		
		
		List<TransactionVO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		StringBuilder sql2 = new StringBuilder();
		StringBuilder sql3 = new StringBuilder();
		
		sql.append( " select transaction_no, transaction_code, my_acc_no, trans_money, balance, others_name, ");
		sql.append(  " others_bank_name, others_acc_no, to_char(transaction_date, 'yyyy-mm-dd') as transaction_date  " );
		sql.append(" from transaction_history@yr ");
		sql.append(" where my_acc_no = ?  ");
 		sql.append(" order by transaction_date desc ");
 		
 		sql2.append( " select no, to_char(transdate, 'yyyy-mm-dd') as transdate, accountno, TRANSACCOUNTNO, amount,  " );
 		sql2.append( " balance, debit, transbank, transname " );
 		sql2.append( " from t_statement@jh " );
 		sql2.append( " where TRANSACCOUNTNO = ? " );
 		sql2.append(" order by transdate desc ");
 		
		sql3.append( " select trans_no, my_account_no, amount, to_account_no,  " );
 		sql3.append( " to_name, to_char(trans_date, 'yyyy-mm-dd') as trans_date, bank_name, my_balance " );
 		sql3.append( " from transaction_details@sj " );
 		sql3.append( " where my_account_no = ? " );
 		sql3.append(" order by trans_date desc ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				PreparedStatement pstmt2 = conn.prepareStatement(sql2.toString());
				PreparedStatement pstmt3 = conn.prepareStatement(sql3.toString());
			) 
		{
			
			pstmt.setString(1, accountNo);
			pstmt2.setString(1, accountNo);
			pstmt3.setString(1, accountNo);
			
			ResultSet rs = pstmt.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();
			ResultSet rs3 = pstmt3.executeQuery();
			
			// yr 뱅크
			while(rs.next()) { 
				
				TransactionVO transaction = new TransactionVO();
				transaction.setTranMyAccount(accountNo);
				transaction.setTranAmount(rs.getInt("trans_money"));
				transaction.setTranType(rs.getString("transaction_code"));
				transaction.setTranBalance(rs.getInt("balance"));
				transaction.setTranDate(rs.getString("transaction_date"));
				
				list.add(transaction);
			}
			
			// jh뱅크
			while(rs2.next()) { 
			
			TransactionVO transaction = new TransactionVO();
			transaction.setTranMyAccount(accountNo);
			transaction.setTranAmount(rs.getInt("amount"));
			transaction.setTranType("계좌이체");
			transaction.setTranBalance(rs.getInt("balance"));
			transaction.setTranDate(rs.getString("transdate"));
			
			list.add(transaction);
			}
			
			//sj뱅크
			while(rs3.next()) { 
				
				TransactionVO transaction = new TransactionVO();
				transaction.setTranMyAccount(accountNo);
				transaction.setTranAmount(rs.getInt("amount"));
				transaction.setTranType("계좌이체");
				transaction.setTranBalance(rs.getInt("balance"));
				transaction.setTranDate(rs.getString("trans_date"));
				
				list.add(transaction);
			}
			
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}

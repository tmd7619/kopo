package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;

/*
 * 
 *  1.7 버전의 try 구문 사용하기  -> try 구문에 객체생성 o  
 *  AutoCloseable을 통해 close()를 안해줘도 자동으로 자원이 해제된다.
 * 
 */

class Test implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("close()....");

	}

}

public class SelectMain02 { // finally에서 close()를 할 필요 없다.

	public static void main(String[] args) { // try 구문 안에 객체를 생성하기 위해서는 클래스가 AutoCloseable를 상속받아야 한다.

		String sql = "select * from t_test"; // String은 AutoCloseable를 상속받지 않기 때문에, try()에 올 수 없다 따라서 try 밖에다 배치

		try (Connection conn = new ConnectionFactory().getConnection(); // Connection는 AutoCloseable를 상속받기에, try에 객체 생성
																		
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			ResultSet rs = pstmt.executeQuery()	;
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println("id :  "+ id + ", name : "+name );
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

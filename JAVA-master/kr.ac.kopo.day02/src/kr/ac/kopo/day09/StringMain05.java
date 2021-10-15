package kr.ac.kopo.day09;

public class StringMain05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long start = System.currentTimeMillis();
		String str = "";
		for(int i = 0 ; i < 100000; i++) {
			str += i;
//			str = str.concat(String.valueOf(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("소요시간 : "+ (end-start)/1000.0+"초");	//소요시간이 오래걸림
		
		System.out.println("------------------------------");
		start = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer() ; // 생성자를 만들어줘야함.
		for(int i = 0 ; i < 100000; i ++) {
			sb.append(i);					   // 변하는 문자열이기때문에, 대입연산자로 넣어줄 필요는 없음
		}
		end = System.currentTimeMillis();
		System.out.println("소요시간 : "+ (end-start)/1000.0+"초");
	}

	
}
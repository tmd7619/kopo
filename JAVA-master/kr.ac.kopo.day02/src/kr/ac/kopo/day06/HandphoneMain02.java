package kr.ac.kopo.day06;

public class HandphoneMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Handphone[] hpArr = new Handphone[3]; 	// new Handphone 뒤에 ()가 붙어야, 실제 핸드폰 객체의 인스턴스가 생성된다.
												// 주소값만 가지는 참조 자료형으로 만들어짐
												// 따라서 각 배열의 원소는  NULL값을 가지고 있음
		
		// 그림 3
		Handphone[] hpArr = new Handphone[] {new Handphone(), new Handphone(), new Handphone() };	// 인스턴스 객체 생성 
		
		hpArr[0].name = "홍길동";
		hpArr[0].phone = "010-1111-2222";
		hpArr[0].company = "삼성";
		
		hpArr[1].name = "홍길동";
		hpArr[1].phone = "010-3333-4444";
		hpArr[1].company = "애플";
		
		hpArr[2].name = "고길동";
		hpArr[2].phone = "010-5555-6666";
		hpArr[2].company = "LG";
		
		for(Handphone hp : hpArr) {
			System.out.println("소유주명 : " +hp.name+", 전화번호 : " + hp.phone+ " , 제조사 : "+ hp.company);
		}
		
	}	

}

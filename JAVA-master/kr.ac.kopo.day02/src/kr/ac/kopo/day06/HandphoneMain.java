package kr.ac.kopo.day06;

public class HandphoneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// "홍길동", "010-1111-2222", "삼성"을 가지는 Handphone 객체 hp 생성
		Handphone hp =new Handphone();	// 핸드폰이란 인스턴스 객체 만들어서 참조변수 hp에 넣기
		hp.name = "홍길동";
		hp.phone = "010-1111-2222";
		hp.company = "삼성";
		
		// "윤길동", "010-3333-4444", "애플"을 가지는 Handphone 객체 hp2 생성
		Handphone hp2 = new Handphone(); 
		hp2.name = "윤길동";
		hp2.phone = "010-3333-4444";
		hp2.company = "애플";
		
		Handphone hp3 = new Handphone(); 
		hp3.name = "고길동";
		hp3.phone = "010-5555-6666";
		hp3.company = "LG";
		
		
		
		
		System.out.println("소유주명 : " + hp.name+ " 전화번호 : " + hp.phone + " 제조사 : " + hp.company);
		System.out.println("소유주명 : " + hp2.name+ " 전화번호 : " + hp2.phone + " 제조사 : " + hp2.company);
		
		System.out.println("===========================================================");
		
		Handphone[] hpArr = {hp, hp2, hp3}; 	//  그림2
		
		for(int i = 0; i < hpArr.length;i++) {
			System.out.println("소유주명 : " + hpArr[i].name +  " 전화번호 :  "+hpArr[i].phone + " 제조사 : "+hpArr[i].company);
		}
		
		System.out.println("===========================================================");
		
		for(Handphone h : hpArr){
			System.out.println("소유주명 : " + h.name +  " 전화번호 :  "+h.phone + " 제조사 : "+h.company);
		}
		
	}

}

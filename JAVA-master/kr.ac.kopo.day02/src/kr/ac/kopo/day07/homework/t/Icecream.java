package kr.ac.kopo.day07.homework.t;

public class Icecream {
	
	String icename;
	int iceprice;
	
	void set(String n , int p){				// 아이스크림 배열 초기화
		icename = n;
		iceprice = p;
	}

	String getName() {			// 직접적으로 멤버변수에접근하기보다, 메소드로 접근하는 것이 유용함
		return icename;			// 변화에 둔감하다
		
	}
	
	int getPrice() {
		return iceprice;
	}
	
	

	
//	void print() {
//		int num  = 1;
//		System.out.println(num++ +"\t"+icename+"\t"+iceprice);
//	}
}

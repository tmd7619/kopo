package kr.ac.kopo.day10.homework;

import java.util.Scanner;

import kr.ac.kopo.day07.homework.t.Icecream;

public class IcecreamMarket02 {

	Icecream02[] iceArr; // Icecream 타입의 iceArr 배열 선언
	Scanner sc = new Scanner(System.in);

	Icecream02 ice = new Icecream02();	// 인스턴스 생성
	
	public void buyIcecream() {			
		buy();
		info();
	}

	public void buy() {
		while (true) {
			System.out.print("아이스크림 몇개 구입할래? : ");
			int icecnt = inputInt();
			ice.setTotalNum(icecnt);		
			System.out.println(icecnt + "개 구입 확인했습니다.");
			this.iceArr = new Icecream02 [icecnt];
			for (int i = 0; i < iceArr.length; i++) {
				System.out.println((i+1) + "번");
				System.out.print("아이스크림명 : " );
				String inPutName = inputName();
				System.out.print("아이스크림가격 : " );
				int inputPrice = inputInt();
				iceArr[i] = new Icecream02();
				iceArr[i].setIce(inPutName, inputPrice);	// iceArr배열에 이름과 가격을 넣기
				ice.setTotalSum(inputPrice);			 	// totalSum에 가격값 넣기
			}
			print();
			System.out.print("계속구매할래?(Y/N) => ");
			String b = sc.nextLine();
			if(b.charAt(0)=='y' || b.charAt(0)=='Y') {	// 입력받은 문자열의 0번째가 y or Y 일경우, while문 continue
				continue;
			}else {										// 아닐경우 break		
				break;
			}
		}
	}
	
	public void print() {		// 구매목록 출력함수
		System.out.println("*** 아이스크림 구매목록 출력 ***");
		System.out.println("이름\t가격");
		for(Icecream02 ice : iceArr) {
			System.out.println(ice.getName()+"\t"+ice.getPrice());
		}
	}
	
	public void info() {		// total정보 출력함수
		System.out.println("총 "+ice.getTotalPerson()+"명의 고객이 아이스크림을 구매했습니다.");
		System.out.println("판매된 아이스크림 총 개수 : "+ice.getTotalNum());
		System.out.println("총 판매액 : "+ice.getTotalSum());
	}


	public int inputInt() {		 // 아이스크림가격 입력받는 함수
		int p = ice.getPrice();	 // getPrice 함수로 price 멤버변수 접근
		p = sc.nextInt(); 
		sc.nextLine();
		return p;
	}

	public String inputName() {	// 아이스크림명 입력받는 함수
		String n = ice.getName(); // getName 함수로 name 멤버변수 접근
		n = sc.nextLine();
		return n;
	}
}

package kr.ac.kopo.day07.homework.t;

import java.util.Scanner;

public class IcecreamMarket {

	Icecream[] iceArr; // Icecream 타입의 iceArr 배열 선언
	Scanner sc = new Scanner(System.in);
	
	Icecream ice = new Icecream();			

	int inputInt(String msg) { // 아이스크림 개수 및 price 입력받기
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	String intputString(String msg) { // 아이스크림 이름 입력받기
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}

	void doSomething() {
		// 손님 아이스크림 구매
		buy();

		// 구매정보 출력
		info();
		
//		print();
		
	}

	void buy() {
		int count = inputInt("아이스크림 몇개 구입할래? : "); // return값을 대입연산자 = 로 받아 count에 저장
		System.out.println(count + "개 구입 확인했습니다.");
		iceArr = new Icecream[count]; // iceArr 배열 길이 설정
		for (int i = 0; i < iceArr.length; i++) {
			System.out.println("*** " + (i + 1) + "번째 아이스크림 구매정보 입력 ***");
			String name = intputString("아이스크림명 : ");
			int price = inputInt("아이스크림 가격 : ");
			iceArr[i] = new Icecream(); // 인스턴스 생성
			iceArr[i].set(name, price);	// iceArr.name에 name을 , iceArr.price에 price를 대입

		}
	}

	void info() {
		System.out.println("< 총 "+iceArr.length+"개 구매정보 출력>");
		System.out.println("번호\t아이스크림명\t아이스크림가격");
		for(int i = 0 ; i < iceArr.length;i++) {
			System.out.println(i+1 +"\t"+iceArr[i].getName()+"\t\t"+iceArr[i].getPrice());	//  멤버변수로 통신이 아닌, 메소드 통신 이용
//			System.out.println(i+1 +"\t"+iceArr[i].name+"\t\t"+iceArr[i].price); // 멤버변수로 통신을 했기때문에, 멤버변수가 변경되면 에러발생
		}
//		int no = 1 ;	// 1.5 포문
//		for(Icecream ice : iceArr) {
//			System.out.println(no++ +ice.getName() + "\t" + ice.getPrice());
		}
	
}

package kr.ac.kopo.day11.abs02.copy;

import java.util.Scanner;

public class Menu {

	public int selectMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("LV2프린터를 선택하세요(1.LG 2.삼성 3.HP) => ");
		int no = sc.nextInt();
		
		return no;
	}
	
	public void choice() {
		int type = selectMenu();
		print(type);
	}
	
	public void print(int no) {
		
		Printer p = null;  	// 객체 형변환을 하기 위해 null 값으로 초기화
			
		switch(no){
		case 1:
			 p = new LGPrinter();		// 객체 형변환 // 부모 클래스의 메소드를 하위클래스에서 오버라이딩 했을경우, 
			 							// 상위클래스의 메소드가 아닌 하위클래스에 선언된 메소드가 호출이 된다.
		case 2:							// 묵시적 형변환이 일어났음 Printer p = (Printer) new LGPrinter();
			 p = new SamsungPrinter();
			break;
		case 3:
//			 p = new HPInkjetPrinter();
			 p = new HPLaserPrinter();
			break;
		}
		if(p!=null)
		p.print();
		else {
			System.out.println("잘못선택하셨습니다");
		}
		
		
		/*
		switch(no){
		case 1:
			LGPrinter lg = new LGPrinter();
			lg.print();
			break;
		case 2:
			SamsungPrinter sam = new SamsungPrinter();
			sam.print();
			break;
		case 3:
			HPPrinter hp = new HPPrinter();
			hp.print();
			break;
		}
		*/
	}
}

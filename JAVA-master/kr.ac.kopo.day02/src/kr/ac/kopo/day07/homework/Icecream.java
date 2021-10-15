package kr.ac.kopo.day07.homework;

import java.util.Scanner;

public class Icecream {

	Scanner sc = new Scanner(System.in);
	int price;
	String name;
	
	void info() {				
		System.out.print("아이스크림 몇개 구입할꺼야? : ");
		int iceNum = sc.nextInt();
		sc.nextLine();
		Icecream[] iceArr = new Icecream[iceNum];		//인덱스당 name과 price를 갖는 iceArr배열 생성
		for(int i = 0 ; i < iceArr.length; i ++) {
			iceArr[i] = iceList(i);		// 아이스크림 정보를 iceArr에 넣기
		}
		System.out.println("<총 "+iceNum+"개의 아이스크림 구매 정보 출력>");
		System.out.println("번호\t"+"아이스크림명\t"+"\t아이스크림가격");
		int num = 0;
		for(Icecream I : iceArr) {
			System.out.println((num+1)+"\t"+I.name+"\t\t"+I.price);
			num++;
		}
		
	}
	Icecream iceList(int num) { 			// 아이스크림 정보 입력
		Icecream iceinfo = new Icecream();
		
		System.out.println("*** " + (num+1) + " 번째 아이스크림 구매정보 ***");
		System.out.print("아이스크림 명 : ");
		iceinfo.name = sc.nextLine();
		
		System.out.print("아이스크림가격 : ");
		iceinfo.price = sc.nextInt();
		sc.nextLine();
		return iceinfo;
	}
}



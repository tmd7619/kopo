package kr.ac.kopo.day06.homework;

import java.util.Scanner;

/*1. 다음의 결과를 보이는 프로그램을 작성하시오

아이이스크림 몇개 구입할꺼야? : 4(입력)

*** 1번째 아이스크림 구매정보 입력 ***
아이스크림명 : 비비빅(입력)
아이스크림 가격: 800

*** 2번째 아이스크림 구매정보 입력 ***
아이스크림명: 브라보콘
아이스크림가격: 1500

*** 3번째 아이스크림 구매정보 입력 ***
아이스크림명: 구구콘
아이스크림가격: 2000

*** 4번째 아이스크림 구매정보 입력 ***
아이스크림명: 메로나
아이스크림가격: 800

 < 총 4개의 아이스크림 구매 정보 출력>
 번호	아이스크림명		아이스크림가격
 1		비비빅				800
 2		브라보콘				1500
 3		구구콘				2000
 4		메로나				800
 
 총계 : 5100원
 */


// 버퍼를 일종의 char 배열이라고 생각하면 된다. 입력시에, 엔터 전까지 입력된 모든 것들을 버퍼에 저장함 


public class Classhomework01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이스크림 몇개 구입할꺼야? : ");
		int num = sc.nextInt();
		sc.nextLine();						//입력버퍼 지우기
		Icecream[] iceArr = new Icecream[num];
		
		for(int i = 0; i < num; i ++) {
			iceArr[i] = new Icecream();		// 인스턴스 객체 생성
			System.out.println("*** "+(i+1)+"번째 아이스크림 구매정보 입력 "+"***");
			System.out.print("아이스크림명 : ");
			String icename = sc.nextLine();
			iceArr[i].name = icename;
			
			System.out.print("아이스크림가격 : ");
			int iceprice = sc.nextInt();
			iceArr[i].price = iceprice; 
			sc.nextLine();						//입력버퍼 지우기
			
		}
		System.out.println("<총 "+num+"개의 아이스크림 구매 정보 출력>");
		System.out.println("번호\t"+"아이스크림명\t"+"\t아이스크림가격");
		num = 0;
		for(Icecream I : iceArr) {
			System.out.println((num+1)+"\t"+I.name+"\t\t"+I.price);
			num++;
		}
		

	}

}

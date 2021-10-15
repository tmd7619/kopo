package kr.ac.kopo.day10.homework;

import java.util.Scanner;

public class Icecream02 {
	private String name; // 아이스크림 이름 및 개수
	private int price; // 아이스크림 가격
	static private int totalNum; // 판매된 아이스크림 총 개수
	static private int totalSum; // 아이스크림 총 판매액
	static private int totalPerson; // 총 사람수

	Scanner sc = new Scanner(System.in);

	public String getName() {			// name을 불러오는 함수
		return name;	
	}

	public int getPrice() {				// price를 불러오는 함수
		return price;
	}
	
	public int getTotalNum() {			// totalNum을 불러오는 함수
		return totalNum;
	}

	public int getTotalSum() {			// totalSum을 불러오는 함수
		return totalSum;
	}

	public int getTotalPerson() {		// totalPerson을 불러오는 함수	
		return totalPerson;
	}

	public void setIce(String n, int p) {	// name과 price를 수정하는 함수
		this.name = n;
		this.price = p;
	}

	public void setTotalSum(int totalSum) {	// 아이스크림 가격 총합을 수정하는 함수
		Icecream02.totalSum += totalSum;	
	}
	public void setTotalNum(int totalNum) {	// 아이스크림을 구매한 사람수와 총개수를 수정하는 함수
		Icecream02.totalNum += totalNum;
		Icecream02.totalPerson ++;
	}
	
	

}

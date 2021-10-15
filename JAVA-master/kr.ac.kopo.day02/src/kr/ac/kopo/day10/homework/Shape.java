package kr.ac.kopo.day10.homework;

import java.util.Random;

public class Shape {
	private String name;
	private int width; // 가로길이
	private int length; // 세로길이 및 높이
	private int radius; // 반지름
	private int count; // 계산값

	Shape() { // 기본생성자 생성

	}

	public int getRandom() {				// 2 ~ 10 랜덤 값 불러오기
		Random r = new Random();
		int ranNum = r.nextInt(9) + 2;		// nextInt(x) : 0 ~ x 미만 
		return ranNum;
	}

	public int getWidth() {		// 가로길이 호출
		return this.width;
	}

	public int getRadius() {	// 반지름 호출
		return this.radius;
	}

	public int getLength() {	// 세로길이 호출
		return this.length;
	}

	public String getName() {	// 도형이름 호출
		return this.name;
	}

	public int getCount() {		// 계산값 호출
		return this.count;
	}

	public void setWidth(int width) {	// 가로길이 수정
		this.width = width;
	}

	public void setLength(int length) {	// 세로길이 수정
		this.length = length;
	}
	
	public void setRadius(int radius) {	// 반지름 수정
		this.radius = radius;
	}

	public void setName(String name) {	// 도형이름 수정
		this.name = name;
	}

	public void setCount(int count) {	// 계산값 수정
		this.count = count;
	}

	public void print(int num) {
		if (num == 1) {
			System.out.print("가로 " + getWidth() + " 세로 " + getLength());
		} else if (num == 2) {
			System.out.print("가로 " + getWidth());
		} else if (num == 3) {
			System.out.print("가로 " + getWidth() + " 높이 " + getLength());
		} else {
			System.out.print("반지름 " + getRadius());
		}
		if (num == 4) {
			System.out.print("의 " + getName() + " 면적은 " + getCount() + "π입니다");
		}
		else {
			System.out.print("의 " + getName() + " 면적은 " + getCount() + "입니다");
		}
	}

}

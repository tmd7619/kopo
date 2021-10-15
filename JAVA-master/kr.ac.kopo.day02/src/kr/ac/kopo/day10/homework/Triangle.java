package kr.ac.kopo.day10.homework;

public class Triangle extends Shape {
	
	Triangle(){
		setName("삼각형");
		
	}
	@Override
	public void print(int num) {
		setWidth(getRandom());
		setLength(getRandom());
		setCount(getWidth()*getLength());	
		super.print(num);
	}
}

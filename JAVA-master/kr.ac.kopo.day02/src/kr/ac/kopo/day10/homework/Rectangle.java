package kr.ac.kopo.day10.homework;

public class Rectangle extends Shape {
	
	Rectangle(){
		setName("직사각형");
	}
	
	@Override
	public void print(int num) {
		setWidth(getRandom());
		setLength(getRandom());
		setCount(getWidth()*getLength());	
		super.print(num);
	}
}

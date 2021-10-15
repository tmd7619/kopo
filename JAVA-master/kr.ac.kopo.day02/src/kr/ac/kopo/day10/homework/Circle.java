package kr.ac.kopo.day10.homework;

public class Circle extends Shape {

	Circle() {
		setName("원");
	}

	@Override
	public void print(int num) {
		setRadius(getRandom());
		setCount(getRadius() * getRadius());
		super.print(num);
	}
}

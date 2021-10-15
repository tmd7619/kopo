package kr.ac.kopo.day11.homework;

public class Triangle extends AbstractShape {

	@Override
	public void printShape() {
		int width = Shape.getRandom();
		int height = Shape.getRandom();
		System.out.print("가로 " + width + " 높이 " + height + "의 삼각형의 면적은 " + (width * height) + "입니다");

	}
}

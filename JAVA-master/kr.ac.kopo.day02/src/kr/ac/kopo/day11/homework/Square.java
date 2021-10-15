package kr.ac.kopo.day11.homework;

public class Square extends AbstractShape {

	@Override
	public void printShape() {
		int width = Shape.getRandom();
		System.out.print("가로 " + width + " 세로 " + width + "의 정사각형의 면적은 " + (width * width) + "입니다");

	}
	
}
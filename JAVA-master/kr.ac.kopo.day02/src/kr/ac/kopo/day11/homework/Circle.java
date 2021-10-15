package kr.ac.kopo.day11.homework;

public class Circle extends AbstractShape {

	
	@Override
	public void printShape() {
		int radius = Shape.getRandom();
		
		System.out.print("반지름 "+radius+"의 원의 면적은 "+(radius*radius)+"π입니다");
		
	}
}

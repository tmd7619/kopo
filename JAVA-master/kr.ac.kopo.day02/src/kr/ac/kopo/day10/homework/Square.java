package kr.ac.kopo.day10.homework;

public class Square extends Shape {
	Square(){
//		super();					//   super()를 쓰지 않아도, 자동으로  Square() 생성자 안에 생성된다.
		setName("정사각형");
	}
	
	@Override
	public void print(int num) {
		setWidth(getRandom());
		setCount(getWidth()*getWidth());	
		super.print(num);
	}
	
	
}

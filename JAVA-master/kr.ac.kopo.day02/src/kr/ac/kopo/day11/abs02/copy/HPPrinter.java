package kr.ac.kopo.day11.abs02.copy;

public abstract class HPPrinter extends Printer {

}

class HPLaserPrinter extends HPPrinter{

	@Override
	public void print() {
		System.out.println("HP레이저 프린트에서 출력중......");
	}

}

class HPInkjetPrinter extends HPPrinter{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("HP잉크젯프린트에서 출력중.....");
	}
	
	
	
}
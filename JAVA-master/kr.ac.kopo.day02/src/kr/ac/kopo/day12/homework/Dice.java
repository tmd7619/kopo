package kr.ac.kopo.day12.homework;

public class Dice implements Game {

	Dice(){
		System.out.println("주사위 값 맞추기 게임입니다");
	}
	
	int me = (int)(Math.random()*6+1);
	int point = 0;
	@Override
	public int startGame(int you) {
		if(me==you) {
			System.out.println("You win");
			point++;
		} else {
			System.out.println("You lose");
		}
		return point;
	}

}

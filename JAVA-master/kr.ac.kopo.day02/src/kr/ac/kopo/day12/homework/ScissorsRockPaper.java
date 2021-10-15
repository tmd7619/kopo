package kr.ac.kopo.day12.homework;

public class ScissorsRockPaper implements Game {

	
	ScissorsRockPaper(){
		System.out.println("가위바위보 게임입니다.");
	}
	
	
	@Override
	public int startGame(int you) {
		int me = (int)(Math.random()*3+1);
		int point  = 0;
		
		if(me==Game.SCISSOR && you == Game.PAPER) {
			System.out.println("You lose");
		}else if(me==Game.SCISSOR && you == Game.ROCK){
			System.out.println("You win");
			point ++;
		}else if(me==Game.ROCK && you == Game.SCISSOR) {
			System.out.println("You lose");
		}else if(me==Game.ROCK && you == Game.PAPER) {
			System.out.println("You win");
			point ++;
		}else if(me==Game.PAPER && you == Game.SCISSOR) {
			System.out.println("You win");
			point ++;
		}else if(me==Game.PAPER && you == Game.ROCK){
			System.out.println("You lose");
		}else {
			System.out.println("Draw");	 // 비기면 2 반환
			point += 2;
		}
		
		return point;
	}

}

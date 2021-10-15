package kr.ac.kopo.day12.homework;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int win = 0;
		int lose = 0;
		int draw = 0;

		Loop1: while (true) {
			System.out.println("게임을 선택하세요");
			System.out.println("A. 가위바위보");
			System.out.println("B. 주사위 값 맞추기");
			System.out.println("C. 종료");

			String input = sc.nextLine();

			Loop2: while (true) {
				if (input.equalsIgnoreCase("A")) { // a or A

					Game ga = new ScissorsRockPaper();
					System.out.println("가위바위보중 하나를 선택하세요");
					System.out.println("1:가위, 2:바위, 3:보");

					int num = sc.nextInt(); // 사용자가 1 ~ 3 입력
					sc.nextLine();			// 입력버퍼 지우기
					if (!(num >= 1 && num <= 3)) { // 사용자가 입력한 숫자가 1~3이 아닐경우
						System.out.println("다시 입력하세요");
						continue;
					}

					int point = ga.startGame(num); // 이기면 1, 지면 0 비기면 2 반환
					if (point == 1) {
						win++;
					} else if (point == 0) {
						lose++;
					} else {
						draw++;
					}
					break;
				} else if (input.equalsIgnoreCase("B")) {
					Game ga = new Dice();
					System.out.println("주사위를 선택하세요(1~6값 중 하나)");
					int num = sc.nextInt(); // 1 ~ 6 입력
					sc.nextLine();			// 입력버퍼 지우기
					if (!(num >= 1 && num <= 6)) { // 사용자가 입력한 숫자가 1~6이 아닐경우
						System.out.println("다시 입력하세요");
						continue;
					}

					int point02 = ga.startGame(num);
					if (point02 == 1) {
						win++;
					} else {
						lose++;
					}
					break;

				} else if (input.equalsIgnoreCase("C")) {
					System.out.println("게임을 종료합니다.");
					System.out.println("당신의 게임 전적은 " + win + "승 " + lose + "패 " + draw + "무입니다");
					break Loop1;

				} else {
					System.out.println("다시 입력하세요");
					break;
				}
				
			}
		}
		
	}

}

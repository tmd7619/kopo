package kr.ac.kopo.day05.exem;

import java.util.*;

/*7. 사용자가 생각하는 숫자를 컴퓨터가 맞추는 프로그램을 작성하세요

사용자가 생각하는 숫자가 [88]입니까? (맞으면 0 작은수면 1 큰수면 2 ) ==> 1
*/

public class Arrhomework07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random(); // 컴퓨터가 부르는 숫자
		Scanner sc = new Scanner(System.in);
		int min = 1, max = 100;

		while (true) {
			int num = r.nextInt((max - min) + 1) + min; // min ~ max 범위지정
			System.out.println("사용자가 생각하는 숫자가 " + num + "입니까?");
			int answer = sc.nextInt();

			if (num > max || num < min) {
				continue;
			}

			if (answer == 0) {
				System.out.println("정답이군요..하하");
				break;
			} else if (answer == 2) { // 정답 < num
				min = num + 1;

			} else { // 정답 > num
				max = num - 1;

			}

		}
	}
}

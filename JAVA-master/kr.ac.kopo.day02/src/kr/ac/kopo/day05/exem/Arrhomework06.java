package kr.ac.kopo.day05.exem;

import java.util.*;

/* 6. 숫자 맞추기 게임 구성

1 - 100 : 30
30보다 큰수입니다
기회는 4번 남았습니다
31 - 100 : 70
70보다 작은수입니다
기회는 3번남앗습니다
31 - 69 : 80
31 - 69 : 55 
55보다 큰수입니다
기회는 2번남앗습니다
56 - 69: 60
60보다 큰수입니다
기회는 1번남앗습니다
61 - 69 : 63
63보다 작은수입니다
기회는 0번남았습니다

아쉽습니다..기회를 다 소진하였습니다 
정답은 61입니다

*/

public class Arrhomework06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random(); // 맞춰야할 숫자
		Scanner sc = new Scanner(System.in);
		int random = r.nextInt(100) + 1; // (0~99) + 1 => (1 ~ 100)
		int start = 1, end = 100, count = 5;
		while (true) {
			System.out.println(start + "-" + end + " : ");
			int num = sc.nextInt();
			if (num > end || num < start) {
				continue;
			}

			if (num == random) {
				System.out.println("축하합니다 정답을 맞추셨습니다.");
				break;
			}
			if (num > random) {
				if (num < end) {
					System.out.println(num + "보다 작은수입니다.");
					end = num - 1;
				}
			} else { // num < random
				if (num > start) {
					System.out.println(num + "보다 큰수 입니다.");
					start = num + 1;
				}
			}
			if (count != 0) {
				count--;
				System.out.println("기회는 " + count + "번남았습니다");
			} else {
				System.out.println("아쉽지만 기회를 다 쓰셨습니다 정답은 " + random + "입니다");
				break;
			}

		}
	}

}

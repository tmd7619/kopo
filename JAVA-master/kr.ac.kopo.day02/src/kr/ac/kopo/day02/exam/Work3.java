package kr.ac.kopo.day02.exam;

import java.util.Scanner;

public class Work3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("물건값을 입력 :");
		int num = sc.nextInt();
		System.out.print("지불한 액수를 입력 :");
		int num2 = sc.nextInt();
		// 방식 1
		if (num2 >= num) {
			System.out.println("<방식1>");
			System.out.printf("거스름돈 : %d원\n", num2 - num);

			int num3 = num2 - num;

			if (num3 / 1000 == 0) {
				System.out.printf("1000원 : 0\n");
			} else {
				// 몫
				System.out.printf("1000원 : %d\n", num3 / 1000);

				num3 = num3 % 1000;

			}

			if (num3 / 500 == 0) {
				System.out.printf("500원 : 0\n");
			} else {
				// 몫
				System.out.printf("500원 : %d\n", num3 / 500);

				num3 = num3 % 500;
			}

			if (num3 / 500 == 0) {
				System.out.printf("500원 : 0\n");
			} else {
				// 몫
				System.out.printf("500원 : %d\n", num3 / 500);

				num3 = num3 % 500;
			}

			if (num3 / 50 == 0) {
				System.out.printf("50원 : 0\n");
			} else {
				// 몫
				System.out.printf("50원 : %d\n", num3 / 50);

				num3 = num3 % 50;
			}

			if (num3 / 10 == 0) {
				System.out.printf("10원 : 0\n");
			} else {
				// 몫
				System.out.printf("10원 : %d\n", num3 / 10);

				num3 = num3 % 10;
			}
			System.out.println("<방식2>");
			System.out.printf("거스름돈 : %d원\n", num2 - num);

			num3 = num2 - num;

			if (num3 / 1000 != 0) {
				// 몫
				System.out.printf("1000원 : %d\n", num3 / 1000);

				num3 = num3 % 1000;
			}
			// 방식2
			if (num3 / 500 != 0) {
				// 몫
				System.out.printf("500원 : %d\n", num3 / 500);

				num3 = num3 % 500;
			}

			if (num3 / 100 != 0) {
				// 몫
				System.out.printf("100원 : %d\n", num3 / 100);

				num3 = num3 % 100;
			}

			if (num3 / 50 != 0) {
				// 몫
				System.out.printf("50원 : %d\n", num3 / 50);

				num3 = num3 % 50;
			}
			if (num3 / 10 != 0) {
				// 몫
				System.out.printf("10원 : %d\n", num3 / 10);

				num3 = num3 % 10;
			}

		} else {
			System.out.printf("%d원이 부족합니다.\n", num - num2);

		}
	}
}

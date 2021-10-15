package kr.ac.kopo.day14.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LotoUtil {
	private Random r = new Random();

	LotoUtil() {
		System.out.println("로또번호를 돌려봅시다");
	}

	private int printRandom() {
		Scanner sc = new Scanner(System.in);

		System.out.print("게임수를 입력하세요 : ");
		int gameNum = sc.nextInt();
		sc.nextLine();
		return (gameNum);
	}

	public void arrayUtli() {		// 방법1

		int gameNum = printRandom();
		int i = 1;
		
		while (i <= gameNum) { // 게임수까지 while문 실행
			int[] intArr = new int[6]; // i++ 할때마다 배열초기화
			loop1: for (int j = 0; j < intArr.length; j++) {
				int random = r.nextInt(45) + 1; // 배열에 넣을때마다 random값 초기화
				intArr[j] = random; // 인덱스에 random값 넣기
				for (j = 0; j < intArr.length; j++) {
					if (intArr[j] == random) { // 각 인덱스 값과 랜덤값이 똑같으면
						continue loop1; // loop1으로 돌아가기 (중복값 제거)
					}
				}
			}
			System.out.println("게임 " + i + " : " + Arrays.toString(intArr));
			i++;
		}
	}

	public void arrayListUtli() {	// 방법2
		int gameNum = printRandom();
		int i = 1;
		
		while (i <= gameNum) {
			List<Integer> list = new ArrayList<>();
			while (true) {
				int random = r.nextInt(45) + 1;
				if (!list.contains(random)) { // random 값이 없으면,
					list.add(random); // random 값 추가 (중복제거)
				}

				if (list.size() % 6 == 0) { // 리스트 원소개수가 6개가 되면,
					Integer[] intArr = list.toArray(new Integer[6]); // 크기가 6인 배열로 변환
					System.out.println("게임 " + i + " : " + Arrays.toString(intArr)); // 출력
					break;
				}
			}
			i++;
		}
	}

	public void setUtil() {		// 방법3
		int gameNum = printRandom();
		int i = 1;
		
		while (i <= gameNum) {
			Set<Integer> set = new HashSet<>();
			while (true) {
				set.add(r.nextInt(45) + 1);
				if (set.size() == 6) { // set 원소 개수가 6개가 되면,
					Object[] arr = set.toArray(); // arr 배열에 집어넣기
					System.out.println("게임 " + i + " : " + Arrays.toString(arr)); // 배열출력
					break;
				}
			}
			i++;
		}
	}

	public void mapUtil() {		// 방법4
		int gameNum = printRandom();
		int i = 1;
		
		while (i <= gameNum) {
			Map<Integer, Integer> map = new HashMap<>();
			while (map.size() < 6) {
				int random = r.nextInt(45) + 1;
				map.put(random, random);
			}
			System.out.println("게임 " + i + " : " + map.keySet());
			i++;
		}
	}
}

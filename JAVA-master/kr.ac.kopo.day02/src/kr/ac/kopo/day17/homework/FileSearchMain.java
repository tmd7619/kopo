package kr.ac.kopo.day17.homework;

import java.util.Scanner;

public class FileSearchMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = null;
		
		FileSearch e = new FileSearch();
		loop1 : while (true) {
			e.search();
			while (true) {
				System.out.print("[M]새폴더  [R]이름변경  [D]삭제 [.]상위폴더이동 [move]하위폴더 이동 [q]종료 : ");
				input = sc.nextLine();

				if (input.equals("M") || input.equals("m")) {
					e.newDir(); // 디렉토리 생성
					break;
				} else if (input.equals("R") || input.equals("r")) {
					e.chgName(); // 이름변경
					break;
				} else if (input.equals("D") || input.equals("d")) {
					e.delFile(); // 파일삭제
					break;
				} else if (input.equals(".")) {
					e.upDir(); // 상위폴더 이동
					break;
				} else if (input.startsWith("move")) {
					e.downDir(input.substring(5)); // 하위폴더 이동 // "move "뒤에 하위폴더명을 인자로 받음
					break;
				} else if (input.equals("q")) {
					System.out.println("파일 탐색기를 종료하겠습니다.");
					break loop1 ;
				} else {
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요. ");
					continue;
				}
			}
		}
	}
}

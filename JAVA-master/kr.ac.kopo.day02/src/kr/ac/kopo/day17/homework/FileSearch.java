package kr.ac.kopo.day17.homework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 1. 탐색기 구현
------------------------------------------
	iodata 폴더 정보
-------------------------------------------
이름			종류		크기		마지막수정날짜
------------------------------------------
새폴더		폴더
새새폴더		폴더
a.txt		파일		3bytes		2021-05-25 11:22:12
b.txt		파일		25bytes
------------------------------------------
[M]새폴더  [R]이름변경  [D]삭제 [.]상위폴더이동 [move]하위폴더 이동 : move 새새폴더
------------------------------------------
	iodata/새새폴더 폴더 정보
-------------------------------------------
이름			종류		크기		마지막수정날짜
------------------------------------------
*/

public class FileSearch {

	Scanner sc = new Scanner(System.in);
	private String fileName; // 파일 이름을 담는 변수 
	private String path ; // 경로 정보를 담는 변수
	private String input; // 하위폴더 이동할때 입력받는 변수
	private int cnt = 0 ; // switch 기능 변수 (폴더이동 시)
	File dir ;; // File 객체 저장 목적 (상위폴더이동 시) 
	
	
	public void search() {

		// 파일 최종 수정일 날짜 형식
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if(cnt == 0 ) { // cnt가 0 일때, iodata폴더 탐색 // default // 처음시작시 보이는 화면
			path = "iodata";
		dir = new File("iodata");
		}else if (cnt == 1) { // cnt가 1 일때, 현재 dir 객체 내 담긴 폴더 탐색  
			dir = new File(path);
		} 
		
		String fn = null; // 파일 이름
		String fk = null; // 파일 종류
		long fs; // 파일 크기
		String flm = null; // 파일 최종 수정 날짜

		System.out.println("--------------------------------------------");
		System.out.println("\t\t" + dir.getName() + " 폴더 정보\t\t");
		System.out.println("--------------------------------------------");
		System.out.println("이름\t종류\t크기\t마지막수정날짜");
		System.out.println("--------------------------------------------");
		File[] list = dir.listFiles();
		for (File f : list) {
			fn = f.getName(); // 파일 이름 저장

			if (f.isDirectory()) { // 디렉토리일 경우, fk에 디렉토리로 저장
				fk = "디렉토리";
			} else { // 아닐경우 파일로 져장
				fk = "파일";
			}
			fs = f.length(); // 파일 사이즈 저장

			flm = sdf.format(new Date(f.lastModified()));

			System.out.println(fn + "\t" + fk + "\t" + fs + "byte(s)\t" + flm);
		}
		System.out.println("--------------------------------------------");
	}

	public void newDir() {
		while (true) {
			System.out.print("만드실 디렉토리 명을 입력하세요 : ");
			fileName = sc.nextLine();
			File newDirObj = new File("iodata/" + fileName);
			if (!newDirObj.exists()) { // 동일한 폴더 명이 존재하지 않을 시 ,
				newDirObj.mkdir(); // 폴더생성
				System.out.println(fileName + "명의 디렉토리가 생성되었습니다.");
				break;
			} else if (newDirObj.exists()) {
				System.out.println("이미 존재하는 디렉토리 명입니다. 다시 입력하세요.");
				System.out.println();
			}
		}
	}

	public void chgName() {
		while (true) {
			System.out.println("======================================================");
			System.out.print("파일 명을 입력해주세요. : ");
			fileName = sc.nextLine(); // 변경 전 파일명
			System.out.print("변경할 파일 명을 입력하세요. : ");
			String chgName = sc.nextLine(); // 변경 후 파일명
			File chgFileObj = new File("iodata/" + fileName);
			if (chgFileObj.exists()) {
				boolean bool = chgFileObj.renameTo(new File("iodata/" + chgName)); // 이름변경 
				if (bool) {
					System.out.println(chgName + " 명으로 변경이 완료되었습니다.");
					break;
				} else {
					System.out.println("이미 동일한 파일명이 존재합니다. 다시 입력하세요.");
					System.out.println("===================================================");
				}
			} else {
				System.out.println("파일이 존재하지 않습니다. 다시 입력하세요.");
				System.out.println("===================================================");
			}
		}
	}

	public void delFile() {
		while (true) {
			System.out.println("======================================================");
			System.out.print("삭제할 파일 or 디렉토리 명을 입력하세요 : ");
			fileName = sc.nextLine();
			File delFileObj = new File("iodata/" + fileName);
			if (delFileObj.exists()) {
				if (delFileObj.isDirectory()) { // 디렉토리일 경우,
					File[] file = delFileObj.listFiles(); // File 배열 생성
					for (int i = 0; i < file.length; i++) { // 배열에 저장된 모든 파일 제거
						file[i].delete(); // 디렉토리 내 모든 파일 제거 
					}
					delFileObj.delete(); // 디렉토리 제거 
					System.out.println(fileName + "  디렉토리와 디렉토리 내 모든 파일이 삭제되었습니다.");
					break;

				} else {
					delFileObj.delete(); // 디렉토리가 아닐경우 , 파일 제거
					System.out.println(delFileObj + " 파일이 삭제되었습니다.");
					break;
				}
			} else {
				System.out.println("파일이 존재하지 않습니다. 다시 입력해주세요.");
			}

		}

	}

	public void upDir() { // 상위 디렉토리 이동 메서드
		
		path = dir.getParent(); // getParent()를 통해 path(경로)에 부모 디렉토리 경로 정보 저장
		cnt = 1; // cnt 를 1로 변경 // default로 iodata가 탐색되는 것이 아닌, path 경로로 탐색 
	}

	public void downDir(String input) { // input은 "move "문자열 뒤에 있는 값 => 하위 디렉토리명
		this.input = input; // input값으로 넘어온 매개변수를 this.input에 저장
		path = path + "/" + this.input; // 현재 경로에 input을 더해줌  

		cnt = 1; // cnt 를 1로 변경 // default로 iodata가 탐색되는 것이 아닌, path 경로로 탐색
	}

}
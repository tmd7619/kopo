package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.service.BoardServiceFactory;

public abstract class  BaseUI implements IBoardUI { 
	
	/*
	 * abstract class로, IBoardUI의  execute() 메서드는 자식 클래스가 override하는 역할
	 * 자주 쓰는 스캐너 메서드를 BaseUI에 정의하여, 자식클래스가 사용할 수 있게 함
	 */

	private Scanner sc ;
	protected BoardService service;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		service = BoardServiceFactory.getInstance();
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;	
	}
	
	protected int scanInt(String msg ) {
		int num = Integer.parseInt(scanStr(msg));
		return num;
		
	}
}

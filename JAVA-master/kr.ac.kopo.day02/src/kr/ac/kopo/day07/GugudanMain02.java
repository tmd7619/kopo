package kr.ac.kopo.day07;

public class GugudanMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gugudan gu = new Gugudan();
		

		int dan = gu.getDan("2 - 9 사이의 단 입력");	// return을 통해 넘겨받는 방식
		
		gu.print(dan);
		
		System.out.println("-------전체단 출력-------");
		
		gu.print(); 			// 전체 단 출력
		
		System.out.println("--------입력단 출력---------");
		int startDan = gu.getDan("시작단을 입력 : ");

		int endDan = gu.getDan("종료단을 입력 : ");
		
		gu.print(startDan, endDan);
		
		
	}

}

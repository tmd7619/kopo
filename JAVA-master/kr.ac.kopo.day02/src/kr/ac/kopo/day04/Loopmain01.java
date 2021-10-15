package kr.ac.kopo.day04;

public class Loopmain01 {
/*
 * 
 *  break
 *  break문의 3가지 역할
 *  switch문에서 switch문을 벗어나는데 사용
 *  반복문에서 반복루프를 벗어나는데 사용
 *  중첩된 반복문을 한번에 빠져나갈때
 * 
 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		loop01: for(int i = 1; i <= 3; i++ ) {
			for(int j = 1 ; j <= 2; j++) {
				if(j==3) {
					break loop01;
				}
				System.out.print(j);
			}
			System.out.println();
		}
			

	}

}

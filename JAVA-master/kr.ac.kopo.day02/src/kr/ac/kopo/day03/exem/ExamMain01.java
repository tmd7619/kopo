package kr.ac.kopo.day03.exem;



/*
 *  1)
 *  12345
 * 	23456
 * 	34567
 * 	45678
 *  56789
 */


public class ExamMain01 {

	public static void main(String[] args) {
		
		//1
		for(int i = 1; i <= 5; i++) {
			for(int j = i ;j <= i+4 ; j++) {
				System.out.print(j);
			}
			
			System.out.println();
		}

		
		
	}
}

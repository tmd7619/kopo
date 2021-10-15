package kr.ac.kopo.day03.exem;


/*	5)
*	*****
*	-****
*	--***
*   ---**
*   ----*
*   ---**
*   --***
*   -****  
*	*****
*/

public class ExamMain5_2 {

	public static void main(String[] args) {
		
		// for 3 + if 3
		for(int i = 1; i <= 9; i ++) {
			if(i<=5) {
				for(int j = 1 ; j <= 5; j++ ) {
					if(j<i) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
			}else {
				for(int j = 1 ; j<=5 ; j++)
				System.out.print(j<10-i ? " " : "*");
			}
			System.out.println();
		}
		
	}
}

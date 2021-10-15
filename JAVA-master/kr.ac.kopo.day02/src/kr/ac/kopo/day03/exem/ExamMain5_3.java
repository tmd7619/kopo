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

public class ExamMain5_3 {

	public static void main(String[] args) {
		// for 3  + if 1
		int star = 5;
		for(int i =1 ; i <= 9 ; i++) {
			for(int j =1 ; j <= 5-star ; j++) {
				System.out.print("-");
			}
			for(int j =1; j <= star; j ++ ) {
				System.out.print("*");
			}
			System.out.println();
			
			if(i < 5) {			// 5 미만인 이유는 이미 i=5일때, space를 위에서 찍었기 때문임.
				star--;
			} else {
				star++;
			}
		}
	}
}

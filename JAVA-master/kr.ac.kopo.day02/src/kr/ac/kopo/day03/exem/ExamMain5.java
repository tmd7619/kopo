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

public class ExamMain5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//5
		for(int i = 0; i <= 8 ; i++) { // i = 0 ~ 8
			if(i<5) { // i - 0, 1, 2, 3 , 4
				//공백
				for(int space = 1; space<= i ; space++ ) {	
					System.out.print(" ");
				}	
				//별
				for(int j=4 ; j>=i ; j--){
					System.out.print("*");
				}
				
				
			} else { // i = 5부터 시작 5,6,7,8
				for(int space = 8; space> i; space--  ) {
					System.out.print(" ");
				}
				for(int j = 4 ; j<=i;j++) {
					System.out.print("*");
				}
				
			}
			System.out.println();
			
		}
	}

}

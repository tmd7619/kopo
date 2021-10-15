package kr.ac.kopo.day03.exem;

/*   
 * 7) 
 * 
 *           *
 *          ***
 *         *****
 *        *******
 *       *********
 *        *******
 *         *****
 *          ***
 *           *
 * 
 *
 * */


public class ExamMain7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 5 , z = 0; z < 4; z++, i--) {
			
			// 공백 4,3,2,1
			for(int j = i ; j >1; j--) {
				System.out.print(" ");
			}
			
			// 별 1,3,5,7
			for(int k = 2*z+1; k>0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int z = 5,i = 0 ; i < 5 ; z--,i++) { // i = 0,1,2,3,4
			
			// 공백 0 1 2 3 4
			for(int j =  i; j > 0; j-- ) {
				System.out.print(" ");
			}
			// 별 9 7 5 3 1
			for(int k = 2*z- 1; k >0 ;k--  ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}

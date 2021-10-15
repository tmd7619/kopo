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


public class ExamMain7_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  n = 1; 
		for(int i = 1 ; i <= 9 ; i ++) {
			for(int j = 1 ; j<= 5-n; j++) {
				System.out.print('-');
			}
			for(int j = 1 ; j <= 2*n-1 ; j++) {
			System.out.print("*");
			}
			System.out.println();
			
			if(i <5) {
				n++;
			} else {
				n--;
			}
		}
		
		
	}

}

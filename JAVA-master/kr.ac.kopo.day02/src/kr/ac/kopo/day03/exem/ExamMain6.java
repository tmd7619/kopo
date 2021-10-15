package kr.ac.kopo.day03.exem;

/*
*	6)
*	*********
*   -*******
*   --*****
*	---***
*	----*
*/

public class ExamMain6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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

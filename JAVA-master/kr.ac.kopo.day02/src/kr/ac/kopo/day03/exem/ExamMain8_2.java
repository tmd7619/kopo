package kr.ac.kopo.day03.exem;

/*  
 * 8)
 * 	*-------*	1 7 1		
 * 	**-----**	2 5 2		
 * 	***---*** 	3 3 3		
 * 	****-****	4 1 4		
 * 	*********	
 * 	****-****	4 1 1		
 * 	***---***	3 3 3		
 * 	**-----** 	2 5 2		
 *	*-------*	1 7 1		
 *
 * */


public class ExamMain8_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int star = 1 ;
		for(int i = 1 ; i <= 9 ;  i ++ ) {
			for(int j = 1 ; j <= 9 ; j++) {
				if( j <= star || j >= 10-star) {
					System.out.print("*");
				} else {
					System.out.print("-");
				}
				/*
				if(j <= star) {
					System.out.print("*");
				} else if(j < 10-star){
					System.out.print("-");
				} else { // j >= 10-star
					System.out.print("*");
				}
				*/
			}
			System.out.println();
			if(i<5) {
				star++;
			} else {
				star--;
			}
		}
		
	}

}

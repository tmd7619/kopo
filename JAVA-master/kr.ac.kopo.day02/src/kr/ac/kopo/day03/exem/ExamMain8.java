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

public class ExamMain8 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int b = 0;
		for(int i=0, k=4; i<9;i++,k--) {
			if(i<4) {
				//* ** *** **** 
				for(int x=0;x<i+1;x++) {
					System.out.print("*");
				}
				// 공백 : 7-5-3-1
				for(int y=0; y<2*k-1;y++){
					System.out.print(" ");
				}
				// * ** *** ****
				for(int z=0;z<i+1;z++) {
					System.out.print("*");
				}
			} else if(i==4) {
				for(int x=0; x<9;x++) {
					System.out.print("*");
				}
			}else { // i = 5,6,7,8
				// **** *** ** *
				b++;
				for(int x=0; x<9-i;x++) {
					System.out.print("*");
				}
				// 공백 1-3-5-7
				
				for(int y=0; y<2*b-1;y++) {
					System.out.print(" ");
				}
				// **** *** ** *
				for(int z=0;z<9-i;z++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
	}
}
package kr.ac.kopo.day03.exem;


//*  4)
//*  *
//*  **
//*  ***
//*  ****
//*  *****
//*  ****
//*  ***
//*  **
//*  *

public class ExamMain4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4
				for(int i = 1 ; i<=9 ; i++) {
					if( i <=5) {
						for(int j = 1; j<=i; j++) {
							System.out.print("*");
						}
					}
					else {
						for(int j = i ;j<=9; j++) {
							System.out.print("*");
						}
					}
					System.out.println();
				}
				
				System.out.println("--------------------------");

	}

}

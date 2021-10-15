package kr.ac.kopo.day03.exem;

public class ExamMain7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 1, s = 4, t = 1; i <= 9; i++)
		{

			for(int j = 1; j <= s; j++) 
				System.out.print(" ");

			for(int k = 1; k <= 2 * t - 1; k++) 
				System.out.print("*");

		 	if(i < 5) {
			s = s -1 ;  t +=1  ;
		 	}else {
			s = s +1 ; t = t-1 ;
		}

		 	System.out.println();
		}
	}

}

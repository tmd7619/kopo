package kr.ac.kopo.day05;

import java.util.Arrays;

public class ArrayMain05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {10,20,30};	
		int[] b;
//		b = a;			// shallow copy
		
///		b =  new int[a.length]; // deep copy
//		for(int i = 0 ; i < b.length; i ++ ) {
//			b[i] = a[i];
//		}
		
		//deep copy
		b =  new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		
		System.out.println("a : " + Arrays.toString(a));
		System.out.println("b : " + Arrays.toString(b));
		
		System.out.println("a의 주소값  : " + a );
		System.out.println("b의 주소값  : " + b );		//  a와 b의 주소값이 동일. // deep copy는 주소값이 서로 다름.
		
		/*
		++b[0];
		System.out.println("++b[0] 수행후 ...");
		System.out.println("a : " + Arrays.toString(a));
		System.out.println("b : " + Arrays.toString(b));
		*/
	}

}

package kr.ac.kopo.day04;

public class ArrayMain03 {
	
	/*
	 * 2차원 배열
	 * 배열의 이름 = new 배열유형[1차원배열개수][1차원배열의크기]
	 * 배열의 이름 = new 배열유형[1차원배열개수][] // 1차원 배열의 크기를 지정 안해주면 , NULL값이 생성됨
	 * 
	 * 2차원 배열 : 배열유형[][]배열명 = {{값1,값2},{값3,값,4}};
	 * ex) int[][]twoarr = {{1,2},{3,4},{5,6}}; 	// 이렇게 이용하는 경우는 거의 없음
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[][] arr = new int[2][3];
		int[][] arr = new int[2][0]; // null값 출력
		arr[0] = new int[5];
		arr[1] = new int[3];
		
		
		System.out.println("arr : " + arr[1][2]);
		System.out.println("arr.length : " + arr.length);
		System.out.println("arr[0].length : " + arr[0].length);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr["+ i +"]: " + arr[i]);
			System.out.println("arr["+ i + "].length : " + arr[i].length);
		}
		
	}

}

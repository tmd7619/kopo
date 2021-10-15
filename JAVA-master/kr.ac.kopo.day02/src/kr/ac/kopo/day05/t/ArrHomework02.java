package kr.ac.kopo.day05.t;

import java.util.Scanner;

public class ArrHomework02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("짝수 몇개 입력 :");
		int evenNum= sc.nextInt();
		System.out.println("홀수 몇개 입력 :");
		int oddNum = sc.nextInt();
		
		int[] nums = new int[evenNum + oddNum];
		/*
		 * 짝수 : nums[0] ~ nums[evenNum-1] 
		 * 홀수 : nums[evenNum] ~ nums[nums.length-1]
		 */
		int evenIdx = 0 , oddIdx = nums.length-1; // 맨 앞 인덱스 맨 뒤 인덱스 지정
		for(int i = 0; i < nums.length; i++) {
			System.out.print("num "+(i+1) + " : ");
			int num = sc.nextInt();
			
			if(num % 2 ==0 && evenIdx < evenNum) {
				nums[evenIdx++] = num; // 앞에서부터 짝수 채우기
			}else if(num % 2 == 1 && oddIdx >= evenNum ) {
				nums[oddIdx--] = num; // 뒤에서부터 홀수 채우기
			}else {			// 조건이 만족이 안될때 
				i--;				
			}
		}
		
		System.out.println("< 총 " + nums.length + "개 정수 출력>");
		for(int num : nums) {
			System.out.print(num + "  ");
		}
	}

}

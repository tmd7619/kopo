package kr.ac.kopo.day05.t;

public class ArrHomework04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[99]; 		// 2~ 100 숫자를 저장하기 위한 배열
		
		for(int i = 0; i < nums.length; i ++) {
			nums[i] = i+2;
		}
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println("num[" + i + "] : " + nums[i]);
			if(nums[i] != 0){			
				for(int j = i+1 ; j < nums.length; j++) {
					if(nums[j] % nums[i] == 0){
						nums[j] = 0;
					}
				}
			}
		}
		
		for(int i : nums) {
			if(i != 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

}

package kr.ac.kopo.day05.t;

/*3. 소수는 1 ~ (판단정수) 사이의 소수로만 나누어 약수가 존재하지 않는다라는 규칙성을 이용함
2 ~ 100사이의 소수를 구분 및 출력하는 코드를 작성 ( 배열 사용)
*/

public class ArrHomework03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] prime = new int[30]; // 임의로 개수 지정. 소수는 자기 범위의 30%이상 넘지 않는다.
		int loc = 0 ;
		
		for(int num = 2 ; num <= 100; num++) { // 2부터 100까지 판단
			boolean flag = true;			  // 소수인지 판단여부
			for(int j = 0; j < loc; j ++) {	  // 판단할 정수 까지만 돌리기
				if(num % prime[j] == 0) { // prime의 소수가 num의 약수이면,
					flag = false;  // 소수가 아니다
					break;
				}
			}
			
			if(flag) {					//  flag가  true일때 소수
				prime[loc++] = num;		// loc 번째에 소수값 저장
			}
		}	
		for(int i = 0 ; i < loc; i++) {
			System.out.print(prime[i]+ "\t");
			if((i+1)%5 == 0) {
				System.out.println();
			}
		}
		
	}

}

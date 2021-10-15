package kr.ac.kopo.day04;

public class ArrayMain01 {

/*
* 
* 배열 : 같은 시공간에 연속적으로 저장된 자료구조집합
* 배열을 만들었을 때, 실제로 배열은 heap영역에 만들어 진다.
* heap 자체는 주소값을 알 수 없기 때문에 heap의 주소값을 저장할 수 있는 참조변수를 stack 영역에 선언을 해야 한다.
* 배열은 객체로 취급 ( new로 생성함)
* 각 변수의 접근은 주소값을 통해 알아낸다
* arr: 주소값을 기억하는 참조변수
* 
* 배열이 생성되면(new라는 키워드로 만들어진 배열) 자동적으로 배열요소는 기본값으로 초기화
* ex) int : 0
* boolean : false
* char : '\u0000'
* 참조형 : null
* 
* 배열의 인덱스는 0부터 시작
* 배열의 크기 : 배열이름.length
* 마지막 요소 인덱스 : 배열크기 -1
* 
*  
*/ 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. 배열 선언
		int[] prime; //해당 선언법을 더 자주쓴다. 
		int prime1[];//prime이라는 변수는 실제 배열을 가지고 있는 변수가 아닌 heap안의 배열의 주소값을 가리키는 참조변수이다.

		//2. 배열 초기화
		prime1 = new int[3];

		//데이터 삽입 방법 1. 인덱스 사용
		prime1[0] = 10;
		prime1[1] = 20;
		prime1[2] = 30;

		//데이터 삽입 방법 2. 선언과 동시에 삽입
		int[] arr1 = new int[]{10, 20, 30};

		//데이터 삽입 방법 3. new int[]를 사용하지 않고 삽입
		int[] brr = {10, 20, 30};
		
		int[] arr;
		
		arr = new int[5]; 		// arr[0] ~ arr[4]
		
		System.out.println("arr : " + arr+", 원소개수 : " + arr.length); // @~ : 주소값, .length : 원소개수 표시
		
		System.out.println("첫번째 정수 : "  + arr[0]);	
		System.out.println("두번째 정수 : "  + arr[1]); // 모든 정수의 초기값은 0이기 때문에 1번째 정수도 0이 됨
		System.out.println("세번째 정수 : "  + arr[2]);	// 이하동일
		
		for(int i = 0; i < 5; i++) {
			System.out.printf("%d번째 정수 : %d\n" ,i+1,arr[i]) ;
			}
		arr = new int[3]; // new를 하면 공간이 다시 재생성됨. 
		System.out.println("arr : " + arr+", 원소개수 : " + arr.length); // @~ : 주소값, .length : 원소개수 표시
		
		for(int i = 0; i <3; i++) {
			System.out.printf("%d번째 정수 : %d\n" ,i+1,arr[i]) ;
			}
		for(int i = 0; i <arr.length; i++) {	// legnth라는 변수를 통해 만드는 것이 더 좋음 
			System.out.printf("%d번째 정수 : %d\n" ,i+1,arr[i]) ;
			}
		
	}

}

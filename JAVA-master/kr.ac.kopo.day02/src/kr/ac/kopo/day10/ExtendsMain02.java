package kr.ac.kopo.day10;

public class ExtendsMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 사원번호가 1 , 연봉을 4000을 받은 홍길동 사원 객체 생성
		Employee e = new Employee(1,"홍길동",4_000,"사원");  // 3자리마다 _을 붙여, 자리수 표시를 할 수 있다.
		Employee e2 = new Employee(2,"박길동",4_200,"사원");
		Employee e3 = new Employee(3,"강길동",4_800,"대리");
		Employee e4 = new Employee(4,"한길동",5_500,"과장");
		Employee e5 = new Employee(5,"박길동",5_200,"대리");
		
		e.info();	
		e2.info();
		e3.info();
		e4.info();
		e5.info();
		
		Employee[] empList = {e,e2,e4};
		Manager01 m = new Manager01(100, "나캡틴", 9_000, "부장",empList);
		
		Manager02 m2 = new Manager02(100, "나캡틴", 9_000, "부장",empList);	// 상속을 통한
		
		Manager02 m3 = new Manager02(100, "나캡틴", 9_000, "부장",empList);	// 상속을 통한
		
		m.info();
		m2.info();
		m3.info();
		
	}

}

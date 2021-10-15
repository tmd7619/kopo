package kr.ac.kopo.day10;

// 관리자클래스	
public class Manager02 extends Employee {

//	int no;			//상속을 받았기 때문에, 변수 선언을 하지 않아도 된다.
//	String name;
//	int salary;
//	String grade;
	Employee[] empList;		// 관리사원 목록 저장목적으로 생성한다
	
	Manager02(int no , String name, int salary, String grade, Employee[] empList){	
//		super(); 생락되있다.		
		this.no = no;			// 만약 부모 멤버변수에 private를 쓰게 되면, this 불가 => error 발생
		this.name = name;
		this.salary = salary;
		this.grade = grade;
		this.empList = empList;
	}
	
	
//	오버라이딩				// 선언한 메서드가 오버라이드 되었다는 것을 나타냅니다. // 주석+에러 체크 기능
	@Override	            // 상위(부모) 클래스(또는 인터페이스)에서 해당 메서드를 찾을 수 없다면 컴파일 에러를 발생
	void info() {
//		info(); //  super.를 생략하게 되면 this.info()로 인식되어, 부모 함수를 쓸때는 super.를 붙여줘야 한다.
				// 함수의 이름이 다를 경우, 생략가능
		System.out.println("관리자 번호 : "+no+" 관리자 이름 : "+name+" 연봉 : "+salary+" 직급 : "+grade);
		System.out.println("===========================");
		System.out.println("\t<관리사원 목록>");
		for(Employee e : empList){
			e.info();
		}
		System.out.println("===========================");
	}
}

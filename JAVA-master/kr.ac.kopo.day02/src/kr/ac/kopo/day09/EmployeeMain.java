package kr.ac.kopo.day09;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Employee.printTotalEmployee02();
		System.out.println("-------------------");
		Employee e = new Employee("홍길동",3200,"사원");
		e.info();
		Employee e2 = new Employee("강길동",4000,"주임");
		e2.info();
		Employee e3 = new Employee("고길동",5000,"과장");
		e3.info();
		System.out.println("-------------------");
		e3.printTotalEmployee();			// e, e2, e3에 각각 totalEmployee가 1이기 때문에, 1 값이 나옴
											// static 변수로 만든 뒤, 실행하면 정상적으로 3이 나옴
		
//		System.out.println("사원 이름 : "+e.name); // private로 인해 e.name이 불가능
		System.out.println("e 사원 이름 : "+e.getName()); // 따라서 getName 메소드를 통해 접근
		System.out.println("e 사원 연봉 : "+e.getSalary()); 
		System.out.println("-------------------");
		
		e.setSalary(3800); 	// 첫번째 사원 연봉 3800으로 변경
		
		e.info();			// 변경된 연봉 확인
	}

}

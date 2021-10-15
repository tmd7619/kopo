package kr.ac.kopo.day09;

/*
 * 
 * 멤버변수는 private로, 메소드는 public으로 만들자
 * 
 */

public class Employee {
	
	private String name;   // 멤버변수	// private으로 인해 직접적인 접근이 불가하고, 메서드를 통해서만 접근 가능하다
	private int salary;
	private String grade;
	static int totalEmployee;		// 총 사원수  스태틱변수로 생성
	
	
	Employee(){		// 기본생성자 먼저 생성하는 것이 좋음
		totalEmployee++;
	}

	Employee(String name, int salary, String grade){ // 매개변수3개 생성자 생성
		this.name = name;
		this.salary = salary;
		this.grade = grade;	
		totalEmployee++;			// 이렇게 만들게 되면, 각 인스턴스에 한개씩 만들어짐
	}
	void info() {
		System.out.println("name : "+this.name+" grade : "+this.grade+" salary : "+this.salary);
		Employee.printTotalEmployee02();	// void가 실행될때, 이미 static 메소드는 생성되있기 때문에 void 안에 스태틱 메소드를 사용할 수 있다.
	}
	
	void printTotalEmployee() {		// 일반 메서드는 인스턴스 객체를 생성해야지만, 실행이 가능함
		System.out.println("총 사원수 : "+totalEmployee);
	}
	static void printTotalEmployee02() { // static을 붙여, 인스턴스 객체 생성을 하지 않고 static변수에 접근이 가능하게 함 
		System.out.println("총 사원수 : "+Employee.totalEmployee+"명");
		
	}
	
	public String getName(){				// private으로인해 접근하지 못하는 name을 getName을 통해 접근하게 한다
		return this.name;					// setName()을 만들지 않아 다른 사람들이 접근하지 못하게 함 => 보안성 증가
	}
	public int getSalary() {
		return this.salary;
	}
	public void setSalary(int salary) {	   // 제어자로 인해 접근하지 못하는 salary를 setSalary를 통해 수정할 수 있다.
		this.salary = salary;
	}
	public void grade(String grade) {
		this.grade = grade;
	}
	
}

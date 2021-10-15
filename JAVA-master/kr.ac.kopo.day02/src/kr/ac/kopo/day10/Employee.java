package kr.ac.kopo.day10;

// 사원클래스
public class Employee {

   int		no;
   String	name;
   int		salary;
   String	grade;

	public Employee(){			// 기본 생성자를 생성해야, 자식 클래스에서 에러 없이 super()가 작동이 된다.
		
	}
	                
	public Employee(int no , String name, int salary, String grade){
		this.no = no;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
	}
	
	void info() {
		System.out.println("사원 번호 : "+no + " 사원명 : "+name+" 연봉 : "+salary+" 직급 : "+grade);
	}
	
}				
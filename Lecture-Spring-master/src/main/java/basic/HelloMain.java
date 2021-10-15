package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	
	public static void main(String[] args) {
		
		
		// ApplicationContext는 xml을 읽는 순간 모든 bean객체를 생성하여 읽어들임
		ApplicationContext context = new GenericXmlApplicationContext("beanContainer.xml"); // 가장 유연한 방법 // 밑에 두방법을 모두 사용 가능함
								//  new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml");
								//	new ClassPathXmlApplicationContext("beanContainer.xml"); // ClassPath :  src/main/resources 
		
		Hello obj = (Hello)context.getBean("hello"); // getBean : id 구분자명으로 해당 bean 객체를 가져오는 함수 // return 타입 : Object
		Hello obj2 = (Hello)context.getBean("hello");
		
		System.out.println(obj);
		System.out.println(obj2); // 주소값은 동일 // 싱글톤 패턴으로 생성됨(?)
		
		obj.printMsg();
		
		
		// 명시적 형변환을 안하기 위해서는?
		Hello obj3 = context.getBean("hello2",Hello.class); // 제너릭처럼 getBean메소드 실행시 타입을 설정해줄 수 있음 
		obj3.printMsg();
		
		
		
		
		/*
		Hello obj = new Hello(); // 기존 객체 생성 방식
		obj.printMsg();
		 */
	}
}

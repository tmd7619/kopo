package di.anno03.component;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("myCar") // getBean시, myCar 이름으로 불러들임
public class Car2 { // AutoWired로 사용할 경우

	@Autowired(required = false) // 자동으로 주입할 대상이 없으면, null값으로 정의 // error가 나지 않는다
	@Qualifier("kumhoTire")
	private Tire tire;
	
	
	public Car2() {  // 기본생성자 // setter 주입 시 반드시 필요 
		
		System.out.println("Car().....");
		
	}
	
		
	/*
	@Autowired
	public Car(@Qualifier("hankookTire") Tire tire) { // 생성자일경우, @Qualifier를 매개변수에 설정해줘야함
		this.tire = tire;
		System.out.println("Car(Tire).......");
	}
	*/
	
//	@Autowired
//	@Qualifier("hankookTire") 
	public void setTire(Tire tire) {
		
		this.tire = tire;
		System.out.println( " set tire....");
	}
	
	
	
	public void prnTireBrand()	{
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}

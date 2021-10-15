package di.anno03.component;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component  //설정값이 없는 경우 클래스이름의 첫자를 소문자로 적용한 빈으로 등록
public class Car { // resource를 쓸 경우 

	/*
	@Resource()  // error -> NexonTire의 이름을 찾게 됨
	@Qualifier("kumhoTire")
	*/
	
	@Resource(name="hankookTire") // Resource는 이름매칭이 우선이기때문에, @Qualifier보다 우선시 됨
	@Qualifier("kumhoTire")
	private Tire tire;
	
	
	public Car() {  // 기본생성자 // setter 주입 시 반드시 필요 
		
		System.out.println("Car().....");
		
	}
	
	//@Resource(name="hankookTire")
	public void setTire(Tire tire) {
		
		this.tire = tire;
		System.out.println( " set tire....");
	}
	
	
	
	public void prnTireBrand()	{
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}

package di.anno03.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class KumhoTire implements Tire {
	
	public String getBrand() {
		
		return "금호타이어";
	}

}

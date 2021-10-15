package di.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"di.java"}) // 2. @ComponentScan 어노테이션 방법
@Configuration
public class Config { // xml 파일을 대신해주는 역할 // xml파일 설정처리를 java 단에서 처리하기 위해 
	
	
	/* 1. @Bean 어노테이션 방법
	@Bean
	public Car car() {
		return new Car();
	}
	
	@Bean // bean 어노테이션을 통해 객체 생성이 이루어짐
	@Qualifier("hankook")
	public HankookTire hankookTire() {
		return new HankookTire();
	}
	
	@Bean
	@Qualifier("kumho")
	public KumhoTire kumhoTire() {
		return new KumhoTire();
	}
	*/

}

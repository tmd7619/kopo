package di.exam04;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"di.exam04"}) // 베이스 패키지 등록 // 패키지 내 @Component를 통하여 빈 객체 생성이 가능함
@Configuration
public class Config {

}

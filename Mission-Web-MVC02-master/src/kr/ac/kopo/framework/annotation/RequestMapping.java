package kr.ac.kopo.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Target을 통해 어노테이션의 위치를 지정할 수 있음 // 이 어노테이션은 method에다 붙이겠다
@Retention(RetentionPolicy.RUNTIME)  // 어노테이션의 정보를 언제까지 유지시키는지 설정을 하는 어노테이션 // 런타임 시점까지 ~
public @interface RequestMapping { // RequestMapping 어노테이션으로 인해 bean.properties 역할을 대신하게 됨

	String value(); // @RequestMapping(value= "" )에서  " "값을 추출할 수 있게 해주는 메소드
//	String uri(); // @RequestMapping(uri = "" )
	
	
}

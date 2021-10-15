package kr.ac.kopo.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 클래스 위에 붙게 하기 위해 TYPE으로 지정
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {

}

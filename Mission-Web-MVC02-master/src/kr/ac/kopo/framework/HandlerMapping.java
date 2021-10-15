package kr.ac.kopo.framework;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.framework.annotation.RequestMapping;

public class HandlerMapping { // 서블릿에서 받은 요청 url을 컨트롤러와 매핑시켜, servlet 단으로 다시 재전달 하는 클래스
							  // 서블릿 init 시에 한번만 실행된다.
	
	private Map<String, CtrlAndMethod> mappings;
	
	public HandlerMapping(String ctrlNames) throws Exception{
		// ctrlNames => kr.ac.kopo.board.controller.BoardController|kr.ac.kopo.login.controller.LoginController
		
		mappings = new HashMap<>(); //  uri와 컨트롤러 메서드를 담기 위한 mappings 생성
		
		
		System.out.println("HandlerMapping 클래스로 넘어온 ctrlNames : "  + ctrlNames);
		String[] ctrls = ctrlNames.split("\\|");
		for(String ctrl : ctrls) {
			Class<?> clz = Class.forName(ctrl.trim());  // 인스턴스 로딩 // trim으로 공백 제거
			
			Object target = clz.getDeclaredConstructor().newInstance(); // ctrlNames로 동적 객체 생성
			System.out.println("target  : "+ target);
			
			//Method[] methods = clz.getMethods(); // 모든 메소드 이름을 불러와 저장
			Method[] methods = clz.getDeclaredMethods(); // 불러온 클래스에 정의되어있는 메소드만 호출함
			for(Method method : methods) {
				System.out.println("method  : "  +method);
				RequestMapping reqAnno = method.getAnnotation(RequestMapping.class);
			System.out.println("reqAnno : "  + reqAnno);
				
				if(reqAnno != null) {
					
					String uri = reqAnno.value(); //  value=" " 의  " "값 추출
//					System.out.println("uri : " + uri);
					
					CtrlAndMethod cam = new CtrlAndMethod(target, method);
					mappings.put(uri, cam);
					
				}
				
				
			}
			System.out.println();
		}
		
	}
	
	public CtrlAndMethod getCtrlAndMethod(String uri) {
		
		return mappings.get(uri); //uri 키값으로 value 값(컨트롤러명과 그 컨트롤러의 메서드) 불러오기
	}
	
	
	
}

package kr.co.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/method/method.do") // 클래스에도 RequestMapping을 붙일 수 있음
@Controller
public class MethodController { // 같은 uri이 들어와도, 응답 방식에 따라(post/get) 분리시킬 수 있음.
	
	@RequestMapping(method=RequestMethod.GET) // get방식으로 응답
	public String callGet()	{
		
		return "method/methodForm";
	}
	
	@RequestMapping(method=RequestMethod.POST) 
	public String callPost() {
		
		return "method/methodProcess";
	}

}

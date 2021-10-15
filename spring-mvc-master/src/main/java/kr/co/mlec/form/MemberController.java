package kr.co.mlec.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form") // 공통적으로 사용하는 uri를 컨트롤러 클래스에 어노테이션 정의를 하자
public class MemberController {
	
	@RequestMapping("/joinForm.do") // uri -> "/form/joinForm.do"
	public String joinForm() {
		
		return "form/joinForm";
	}
	
	// 가장 편한 방법
	// 방법 3  파라미터로 model를 가져와서, model 객체에 직접 등록시켜주는 경우
	@RequestMapping("/join.do")		
	public String join( MemberVO member , Model model){ 
		
		model.addAttribute("member", member); 
		
		return "form/memberInfo";
	}
	
	
	// 방법 2 ModelAndView 객체에 view와 model 설정을 해주고, mav값을 리턴시킴
	/*
	@RequestMapping("/join.do")		
	public ModelAndView join( MemberVO member){ 
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form/memberInfo"); // 응답 jsp 설정 
		mav.addObject("member" , member); // 공유영역에 등록
		return mav;
	}
	*/
	
	
	// requet 객체를 파라미터로 받지 않고 @ModelAttribute  사용
	/*
	@RequestMapping("/join.do")								      // 파라미터로 VO객체를 받을 수 있다. -> set설정 + request 공유영역에 등록
	public String join(@ModelAttribute("member") MemberVO member) // @ModelAttribute은 생략이 가능함
																  // @ModelAttribute("객체등록명")으로 공유영역 객체명 설정 가능
	
	{  // @RequestParam에 의해 id값 추출 -> String id에 주입
		
		
		System.out.println(member);
		
		return "form/memberInfo";
	}
	
	*/
	
	// @RequestParam 방법
	/*
	@RequestMapping("/join.do")
	public String join(@RequestParam("id") String id ,@RequestParam("password") String password 
			, @RequestParam("name") String name , HttpServletRequest request ) 
	
	{  // @RequestParam에 의해 id값 추출 -> String id에 주입
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		request.setAttribute("member", member);
		
		System.out.println(member);
		
		
		return "form/memberInfo";
	}
	*/
	
	// 방법 1 request.setAttribute로 직접 request 공유영역에 객체를 등록시키기
/*	
	@RequestMapping("/join.do")
	public String join(HttpServletRequest request ) { 
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		request.setAttribute("member", member); // mav로 안해도 바로 객체 등록 가능 // request 객체를 알고 있기 때문에
		
		
		return "form/memberInfo";
	}
*/	
}

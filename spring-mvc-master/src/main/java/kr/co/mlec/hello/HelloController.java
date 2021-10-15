package kr.co.mlec.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
   
   @RequestMapping("/hello/hello.do")
   public ModelAndView hello() {
   
      ModelAndView mav = new ModelAndView("hello/hello"); // 매개변수 : forward 시킬 jsp 주소
      mav.addObject("msg", "hi 스프링 MVC~~"); // 공유영역에 객체 등록  // msg란 이름으로 hi~  내용 등록
      return mav; // 포워드 + 공유영역 객체 등록
   }
}
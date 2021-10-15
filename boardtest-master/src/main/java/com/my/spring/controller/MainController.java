package com.my.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.spring.domain.BoardVO;
import com.my.spring.service.BoardService;

@Controller
@RequestMapping("/")  //이 어노테이션의 역할은 ()안에 있는 경로와 컨트롤러를 이어주는것(매핑)이다.
					  //“루트/”경로로 접속을 시도하면 MainController가 담당을 하고 아래 메소드에 있는 경로들은 “루트/” 뒤에 붙는 값이 된다.
public class MainController {

	@RequestMapping("/Main")	// localhost ~ /Main
	public String main() {
		return "index";	//이 “home”값은 리턴이 되면 스프링이 알아서 분석하고 자동으로 
						//src/main/webapp/WEB-INF/views 안에 있는 home.jsp와 연결해준다. 
	}
	
	@Autowired // 의존성주입
	private BoardService boardService;

	@RequestMapping("test")		// 실제 도메인상에 주소
	public String test(Model model) { //해당 메소드의 인자로 Model타입 객체를 받는다.
//									    Model객체는 컨트롤러(Controller) -> 뷰(View)로 넘어가 데이터를 전달해주는 역할을 한다.
//	  model.addAttribute("속성의 Key값", 속성에 저장할 데이터(Object 타입)); : 기본적인 model 사용법
		
	  model.addAttribute("viewAll", boardService.viewAll());
	  return "board/test";	//board 폴더 안에 있는 test.jsp로 연결됨
	}
	
	@RequestMapping("board")
	public String board(Model model) {
		model.addAttribute("viewAll", boardService.viewAll());
		return "board/boardList";	// views board/boardList.jsp
	}
		
	@GetMapping("detail") // @GetMapping어노테이션은 GET방식의 url요청만 매핑해주는 어노테이션이다.
	public String viewDetail(Model model, @RequestParam("seq")int seq) { // @RequestParam어노테이션은 View단에서 seq라는 이름으로 넘긴 파라미터를 받아준다.
	  model.addAttribute("board", boardService.viewDetail(seq)); 
	  
	  //조회수 +1
	  boardService.plusCnt(seq);
	  
	  return "board/viewDetail";
	}
	
	@GetMapping("write")
	public String boardWrite() {
	  return "board/boardWrite";
	}
	
	@PostMapping("write")
	public String write(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect: /board";	// board domain으로 redirect
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("seq")int seq) {
		boardService.deleteBoard(seq);
		return "redirect: /board";
	}
	
	@GetMapping("modify")
	public String modify(@RequestParam("seq")int seq, Model model) {
		model.addAttribute("board", boardService.viewDetail(seq));
		return "board/boardModify";
	}

	@PostMapping("modify")
	public String modify(BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect: /detail?seq="+ vo.getSeq();
	}
}

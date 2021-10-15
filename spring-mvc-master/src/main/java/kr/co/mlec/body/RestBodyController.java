package kr.co.mlec.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mlec.form.MemberVO;

@RestController // 클래스에 붙임(responseBody와의 차이점) // 이 클래스 밑에 있는 모든 메소드는 메세지기반의 형태로 바뀐다.
@RequestMapping("/ajax")
public class RestBodyController {
	
	@RequestMapping("/restBody.do")
	public String resStringBody() {
		
		return "OK, 성공"; // 메세지값 바로 응답 // 한글이 깨져서 보내기 때문에, 메세지 컨버터 필요
	}
	
	
	@RequestMapping("restBody.json")
	public Map<String, String> resJsonBdoy(){
		Map<String, String> result = new HashMap<String, String>();
		result.put("id", "hong");
		result.put("name", "홍길동");
		result.put("addr", "서울");
		
		return result; // Map -> JSON을 변환하기 위해서는 Json Maven이 필요 -> pom.xml에 등록 
	}
	
	@RequestMapping("/restVOBody.json")
	public MemberVO resJsonVOBody() {
		
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("홍길동");
		vo.setPassword("1234");
		
		return vo;
	}
	
	@RequestMapping("/restStringListBody.json")
	public List<String> resJsonStringListBody(){
		
		List<String> list = new ArrayList<String>();
		for(int i = 1 ; i <=4 ; i++) {
			list.add(String.valueOf(i));
		}
		return list;
	}
	
	@RequestMapping("/restVOListBody.json")
	public List<MemberVO> resVOListBody() {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		for(int i = 0 ; i < 4 ; i ++) {
			
			MemberVO vo = new MemberVO();
			vo.setId("hong");
			vo.setName("홍길동");
			vo.setPassword("1234");
			list.add(vo);
			
		}
		
		return list;
	}
	
	
	
	
	
}

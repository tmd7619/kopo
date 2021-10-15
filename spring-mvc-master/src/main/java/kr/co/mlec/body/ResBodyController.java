package kr.co.mlec.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.form.MemberVO;

@Controller
@RequestMapping("/ajax")
public class ResBodyController {
	
	@RequestMapping("/resBody.do")
	@ResponseBody // forward를 시키지 않고, 바로 String 타입으로 응답시켜주는 어노테이션
	public String resStringBody() {
		
		return "OK, 성공"; // 메세지값 바로 응답 // 한글이 깨져서 보내기 때문에, 메세지 컨버터 필요
	}
	
	
	@RequestMapping("resBody.json")
	@ResponseBody // json 타입으로 보내기  // web.xml에 mapping 설정 해야함
	public Map<String, String> resJsonBdoy(){
		Map<String, String> result = new HashMap<String, String>();
		result.put("id", "hong");
		result.put("name", "홍길동");
		result.put("addr", "서울");
		
		return result; // Map -> JSON을 변환하기 위해서는 Json Maven이 필요 -> pom.xml에 등록 
	}
	
	@RequestMapping("/resVOBody.json")
	@ResponseBody
	public MemberVO resJsonVOBody() {
		
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("홍길동");
		vo.setPassword("1234");
		
		return vo;
	}
	
	@RequestMapping("/resStringListBody.json")
	@ResponseBody
	public List<String> resJsonStringListBody(){
		
		List<String> list = new ArrayList<String>();
		for(int i = 1 ; i <=4 ; i++) {
			list.add(String.valueOf(i));
		}
		return list;
	}
	
	@RequestMapping("/resVOListBody.json")
	@ResponseBody
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

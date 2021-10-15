package kr.ac.kopo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		
		this("C:\\\\Users\\\\HP\\\\Lecture\\\\web-workspace\\\\Mission-Web-MVC-Account\\\\bean.properties");
	}
	
	public HandlerMapping(String propLoc) {
		
		mappings  = new HashMap<>();
		Properties prop = new Properties();
		try {
			InputStream is = new FileInputStream(propLoc);
			prop.load(is); // 스트림으로 열린 Properties 파일 객체를 로드
			
		Set<Object> keys = prop.keySet();
		for(Object key : keys) {
			String className = prop.getProperty(key.toString()); //property 의 value 값 return
			System.out.println(className);
			
			Class<?> clz = Class.forName(className); // value 값을 메모리에 로드하여, clz에 저장
			mappings.put(key.toString(), (Controller)clz.newInstance());
			
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public Controller getController(String uri) {
		
		return mappings.get(uri);
		
	}
}

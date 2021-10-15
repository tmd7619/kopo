package kr.ac.kopo.day15;

import java.util.ArrayList;
import java.util.List;

/*
 프로그램에 따라 기본 타입의 데이터를 객체로 취급해야 하는 경우가 있습니다.
예를 들어, 메소드의 인수로 객체 타입만이 요구되면, 기본 타입의 데이터를 그대로 사용할 수는 없습니다.
이때에는 기본 타입의 데이터를 먼저 객체로 변환한 후 작업을 수행해야 합니다.
이렇게 8개의 기본 타입에 해당하는 데이터를 객체로 포장해 주는 클래스를 래퍼 클래스(Wrapper class)라고 합니다.
래퍼 클래스는 각각의 타입에 해당하는 데이터를 인수로 전달받아, 해당 값을 가지는 객체로 만들어 줍니다.
이러한 래퍼 클래스는 모두 java.lang 패키지에 포함되어 제공됩니다.

 	기본자료형		Wrapper  클래스
 	boolean			Boolean
 	char			Character
 	byte			Byte
 	short			Short
 	int				Integer
 	long			Long
 	float			Float
 	double			Double
 
 
 */


public class WrapperMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<>();
		list.add(1);	//	autu boxing으로 인해, 자동으로 기본타입을 랩클래스에 넣어짐 // int => integer
		list.add(2);
		list.add(3);

		int i = 123;
		Integer i2 = new Integer(123);		// Integer는 참조 자료형이기 때문에 new()로 생성
		Integer i3 = 123;					// auto boxing   // 기본타입을 랩클래스에 자동으로 Boxting 
		int i4 = new Integer(123); 			// auto unboxing // 객체형태로된 box에서 기본자료형만 빼내는 것 
				
		System.out.println("i : "+i);
		System.out.println("i2 : "+i2);
		System.out.println("i3: "+i3);
		
		String str = "10234";				// 자바는 똑같은 기능을 하는 메서드가 2개이상 존재하지 앟는다
		
		// String -> int or integer
		int num = Integer.parseInt(str);	// return 타입이 기본자료형 int
			num = Integer.valueOf(str);		// return타입이 wrapper클래스의 참조자료형
		
		// int or integer -> String
		String str2 = Integer.toString(num);
//		String str3 = Integer.valueOf(num);
		
		
		System.out.println(num + 100);
	}

}

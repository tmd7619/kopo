package kr.ac.kopo.day08;

public class StringMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String str = new String();
		char[] chars = {'A','B','C','D'};
		String str2 = new String(chars);
		String str3 = new String(chars,1,3);
		
		byte[] bytes = {97,98,99,100,101};
		String str4 = new String(bytes);
		
		//str5와 str6은 차이점이 있다.
		String str5 = new String("hello"); 		// str5 != str8
//		String str8 = new String("hello"); 		// 서로 다른 hello를 가르킴
		
		String str6 = "hello";					// str6 = str 7
//		String str7 = "hello";					// 같은 hello를 가르킴
		
		System.out.println("str : ["+str+"]");
		System.out.println("str2 : ["+str2+"]");
		System.out.println("str3 : ["+str3+"]");
		System.out.println("str4 : ["+str4+"]");
		System.out.println("str5 : ["+str5+"]");
		System.out.println("str6 : ["+str6+"]");
		
	}

}

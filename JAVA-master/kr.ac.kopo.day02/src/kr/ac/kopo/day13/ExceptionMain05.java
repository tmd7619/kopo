package kr.ac.kopo.day13;

import java.io.FileReader;


 abstract class parent{
	 public abstract void print();
	 public abstract void scan() throws Exception; // 스캔메소드는 예외가 날 수 있으니까, 반드시 예외처리를 해라
 }

 class Child extends parent{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan() throws Exception {	// 스캔메소드는 예외가 날 수 있으니까, 반드시 예외처리를 해라
		// TODO Auto-generated method stub
		
	}
	 
 }
 
 
public class ExceptionMain05 {

	public static void main(String[] args) /* throws Exception */ {	// main()에서도 throws를 통해 JVM으로 예외처리를 넘길 수 있다.
																// 하지만, 개발자입장에서 예외처리를 통제하는 것이 좋으므로, JVM까지 넘기는 건 효율적이지 못함
		Child obj = new Child();
		obj.print();
		try {
		obj.scan();		// throws Exception으로 인해, 반드시 예외처리를 하도록 되어있음.
		} catch(Exception e){
			
		}
//		b();
		
		/*
		try {
		b();
		} catch(Exception e ) {
			System.out.println("main() 예외처리");
			e.printStackTrace();
		}
		*/
//		a();
	}
	/*
	public static void b() throws Exception { //throws를 통해 main b()에서 예외처리를 하도록 넘기겠다.
		System.out.println("b() 메소드 호출 ....");
		String str = null;
		System.out.println(str.charAt(0));
		System.out.println( 1/0);
	}
	*/
	
	
	public static void a() {			// main이 static이라 static메소드로 생성
		System.out.println("a() 메소드 호출 ...;..");
		try {
		FileReader fr = new FileReader("a.txt");
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
}

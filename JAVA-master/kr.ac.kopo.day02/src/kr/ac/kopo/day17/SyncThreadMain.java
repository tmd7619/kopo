package kr.ac.kopo.day17;


/*
 *  Thread의 동기화 -> 하나의 작업이 끝날때까지 다른 작업이 수행될 수 없게 하는 것.
 *  메서드에 synchronized를 붙여 락(lock)을 걸 수 있게 함.
 */

class Sync{
	public synchronized void a() {
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.print('a'); // println 메서드는 메서드 자체에 동기화 블럭을 가지고 있기 때문에, 동기화가 정상적으로 실행되지 않음
		}
	}
	
	public synchronized void b() {
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.print('b');
		}
	}
	
	public synchronized void c() {
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.print('c');
		}
	}
	
	public void d() {    		// sysout 3 4 5 는 무조건 연속적으로 수행되게 하고 싶다?
		System.out.println(1);
		System.out.println(2);
		synchronized (this) {
			System.out.println(3);
			System.out.println(4);
			System.out.println(5);
		}
		System.out.println(6);
	}
	
	
}



class SyncThread extends Thread {
	
	private Sync sync;
	private int type;
	
	public SyncThread(Sync sync, int type) {
		this.sync = sync;
		this.type = type;
	}
	

	@Override
	public void run() {
		
		switch(type){
			case 1:
				sync.a();
				break;
			case 2:
				sync.b();
				break;
			case 3:
				sync.c();
				break;
		}	
	}
}


public class SyncThreadMain {
	public static void main(String[] args) {
		
		
		Sync sync = new Sync();
		SyncThread st = new SyncThread(sync,1);
		SyncThread st2 = new SyncThread(sync,2);
		SyncThread st3 = new SyncThread(sync,3);
		
		st.start();
		st2.start();
		st3.start();
		
		
	}
}

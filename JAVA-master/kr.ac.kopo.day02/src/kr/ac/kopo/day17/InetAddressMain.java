package kr.ac.kopo.day17;

import java.net.InetAddress;

public class InetAddressMain {
	
	public static void main(String[] args) {
		
		// 내 컴퓨터 정보 가져오기
		try {
		InetAddress localhost = InetAddress.getLocalHost();
		
		System.out.println("내 컴퓨터의 네트워크 이름 : "+ localhost.getHostName() );
		System.out.println("내 컴퓨터의 IP 주소 : "+localhost.getHostAddress());
		System.out.println(localhost.toString());
	
		InetAddress addr = InetAddress.getByName("www.hanati.co.kr");
		System.out.println("하나금융티아이 IP : " + addr.getHostAddress());
		
		InetAddress[]  addrs = InetAddress.getAllByName("www.naver.com"); // 해당 도메인의 모든 ip주소를 가져옴 / 리턴타입은 배열
		System.out.println("----------------------------------------------------");
		System.out.println("----------------------네이버 아이피 주소 ------------");
		System.out.println("--------------------------------------------");
		for(InetAddress address : addrs) {
			System.out.println(address);
		}
		System.out.println("----------------------------------");
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
}

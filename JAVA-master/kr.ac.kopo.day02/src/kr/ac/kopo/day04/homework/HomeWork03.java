package kr.ac.kopo.day04.homework;

/*
 *  3. 달팽이가 100m 깊이의 우물에 빠졌습니다.
    달팽이는 3M/hour 우물을 기어오릅니다.
    달팽이도 힘들어서 미끌어 질 수 있으므로 올라간 높이가 50m미만일 때 -1M/hour
                                  50m이상일 때 -2M/hour
    달팽이는 몇시간만에 우물을 탈출할까요?
    
    [1시간후] 달팽이가 올라간 총 높이 : 2M 
    [2시간후] 달팽이가 올라간 총 높이 : 4M
 * 
 */


public class HomeWork03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int height = 0, hour = 0;
		while(height!=100) {
			hour++;
			if(height<50) {
				height += 2;
				System.out.println("["+hour+"시간후] 달팽이가 올라간 총 높이 :" +height+"M");
			} else {
				height += 1;
				System.out.println("["+hour+"시간후] 달팽이가 올라간 총 높이 :" +height+"M");
			}
			
		}
		
		
		
	}

}

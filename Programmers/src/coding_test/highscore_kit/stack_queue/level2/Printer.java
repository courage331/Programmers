package coding_test.highscore_kit.stack_queue.level2;

import java.util.*;

/*
 * 
 * 테스트명 : 프린터
 * 
 * @ 김지민
 * 
 */
//인쇄 클래스
class Paper{
    int pos;
    int chk;
    
    public Paper(int pos, int chk){
        this.pos=pos;
        this.chk=chk;
    }
    

}

public class Printer {

class Solution {
    public int solution(int[] priorities, int location) {
 		
		Queue<Paper> waiter = new LinkedList();
		Queue<Paper> temp = new LinkedList();
		Queue<Paper> complete = new LinkedList();
		int answer = 0;
		boolean flag =false;
		
		for (int i = 0; i < priorities.length; i++) {
			int chk = 0;
			if (i == location)
				chk = 1;
			waiter.add(new Paper(priorities[i], chk));
		}
		//가장 앞에있는값
		while(true) {
			int current = waiter.peek().pos;
			int checker = waiter.peek().chk;
			temp.add(waiter.poll());

			while (!waiter.isEmpty()) {
				if (current >= waiter.peek().pos) { // 맨앞값이 대기목록보가 크다면 일단 temp에 담음
					temp.add(waiter.poll());
				} else { // 맨앞값이 대기목록보다 작다면 temp 담긴것 모두 뒤로 보낸다.
					while (!temp.isEmpty()) {
						waiter.add(temp.poll());
					}
					break;
				}
			}
			if(!waiter.isEmpty()) {
				continue;
			}
			
			//전부다 통과되었다면 맨 앞에 있는 값을 complete로
			if(waiter.isEmpty()) {
				answer++;
				if(temp.element().chk==1) {
					flag=true;
				}
				complete.add(temp.poll());
				while(!temp.isEmpty()) {
					waiter.add(temp.poll());
				}
			}
			
			if(flag)
				break;
			
		}//큰 while문        
        return answer;
    }
}
}

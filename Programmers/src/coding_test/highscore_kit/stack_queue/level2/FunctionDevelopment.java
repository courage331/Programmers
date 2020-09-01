package coding_test.highscore_kit.stack_queue.level2;

import java.util.*;

/*
 * 
 * 테스트명 : 기능개발
 * 
 * @ 김지민
 * 
 */

public class FunctionDevelopment {

	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
			int [] times = new int[speeds.length];
			ArrayList<Integer> arr = new ArrayList();
			int cnt=0;
			Stack<Integer>day = new <Integer>Stack();
			
			for (int i = 0; i < times.length; i++) {
				times[i]=(int) Math.ceil((double)(100-progresses[i])/speeds[i]);
				if(i==0) {
					day.push(times[i]);
					arr.add(1);
	                
				}else if(i!=0 &&day.peek()<times[i]) {
					day.push(times[i]);
					arr.add(1);
	                cnt++;
	                
				}else {
					int a = arr.get(cnt);
					arr.set(cnt, ++a);
				}
			}
			int [] answer = new int[arr.size()];
			for (int i = 0; i < answer.length; i++) {
				answer[i]=arr.get(i);
			}
	    return answer;
	    }
	}
}

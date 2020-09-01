package coding_test.highscore_kit.stack_queue.level2;
import java.util.*;
/*
 * 
 * 테스트명 : 주식가
 * 
 * @ 김지민
 * 
 */
public class StockPrice {
	class Solution {
	    public int[] solution(int[] prices) {
			int [] answer = new int[prices.length];
			int cnt = prices.length-1;
			Stack<Integer>stock = new Stack<Integer>();
			ArrayList<Integer>save = new ArrayList();
			
			for (int i = 0; i < prices.length; i++) {
				stock.push(prices[i]);
			}
			while(!stock.isEmpty()) {
				int value = stock.pop();
				save.add(value);
				answer[cnt]=-1;
				for (int i = save.size()-1; i >=0; i--) {
					if(save.get(i)<value) {
						answer[cnt]=((save.size()-1)-i);
						break;
					}
					answer[cnt]++;
				}
				cnt--;	
				
			}

	        return answer;
	    }
	}
}

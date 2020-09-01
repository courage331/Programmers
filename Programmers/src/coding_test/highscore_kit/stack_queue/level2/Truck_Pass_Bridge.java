package coding_test.highscore_kit.stack_queue.level2;

import java.util.*;

/*
 * 
 * 테스트명 : 다리를 지나는 트럭
 * 
 * @ 김지민
 * 
 */

class Truck {
	int weight;
	int pos;

	public Truck(int weight, int pos) {
		this.weight = weight;
		this.pos = pos;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return weight + "," + pos;
	}
}

public class Truck_Pass_Bridge {


	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int t_sum = 0;
			int t_weight=0;
			int position=0;
			int answer =1;
	        
			Queue<Truck> passed = new LinkedList();
			Queue<Truck> going = new LinkedList();
			Queue<Truck> waiter = new LinkedList();
			

			for (int i = 0; i < truck_weights.length; i++) {
				waiter.add(new Truck(truck_weights[i], 0));
			}
			while (true) {
				if(!waiter.isEmpty()) {
					t_weight = waiter.peek().weight;
					position = waiter.peek().pos;
				}
				
				if (t_weight + t_sum <= weight) {// 무게가 적을 경우 다리에 들어와도 된다.
					waiter.poll();
					going.add(new Truck(t_weight, position));
					t_sum += t_weight; // 현재 다리위의 무게에 더해준다.
//					System.out.println("시작");
				} 
				int count = going.size();
				for(int i=0; i<count; i++) {
					int a = going.peek().weight;
					int b = going.peek().pos;
					going.add(new Truck(a,b+1));
					going.poll();
//					System.out.println(answer+","+going);
				}
				answer++;
				
				if (going.peek().pos >= bridge_length) {
					t_sum -= going.peek().weight;
					passed.add(going.poll());
				}

				if (passed.size() == truck_weights.length) {
					break;
				}
//				System.out.println("끝");
			}
			return answer;
		}
	}

}

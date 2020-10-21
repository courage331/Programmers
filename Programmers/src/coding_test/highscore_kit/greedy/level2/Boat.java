package coding_test.highscore_kit.greedy.level2;

import java.util.*;

/*
 * 
 * 테스트명 : 구명보트
 * 
 * @ 김지민
 * 
 */

public class Boat {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people); //오름차순으로 정렬...
	        Deque<Integer>dq = new ArrayDeque<>();
	        for(int i=people.length-1; i>=0;i--){ //내림차순으로  deque에 담아준다. 
	            dq.add(people[i]);
	        }
	        //가장 무거운 사람과 가장 가벼운 사람을 엮어준다. (맨앞 가장무거운사람, 맨뒤 가장 가벼운 사람)
	        while(!dq.isEmpty()){
	            int weight = dq.poll(); 
	            while(!dq.isEmpty()){
	               if(dq.peekLast()+weight<=limit){ 
	            	   //가장 가벼운 사람을 더했는데도 무게가 남는다면 그 다음 사람도 탈수있는지 찾아본다.
	                   weight+=dq.pollLast();
	               }else{
	                   break;
	                   //무게를 초과하면 break 
	               }
	            }
	            answer++;
	        }
	        
	        return answer;
	}
}

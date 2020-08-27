package coding_test.highscore_kit.hash.level2;
/*
 * 
 * 테스트명 : 위장
 * 
 * @ 김지민
 * 
 * 옷입는 경우의 수 
 * ex) a:3개, b:4개, c:3개
 * 경우의 수 = (3+1)*(4+1)*(3+1)-1
 * 
 */
import java.util.*;
public class Camouflage {
	class Solution {
		    public int solution(String[][] clothes) {
		        int answer = 1;
		        HashMap<String, Integer>category = new HashMap(); //의상의 종류, 종류의 수
		        for(int i=0; i<clothes.length; i++){
		            int count = category.containsKey(clothes[i][1])? category.get(clothes[i][1]) : 1;
		            category.put(clothes[i][1], count+1);
		        }
		        
		     
	            Iterator<Integer> sum = category.values().iterator();
	            while(sum.hasNext()){
	                int value = sum.next();
	                answer*=value;
	            }	        
		        answer-=1;
		        return answer;
		    }
		}
}

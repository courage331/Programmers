package coding_test.kakao_blind_recruitment_2019;
import java.util.*;
/*
 * 
 * 테스트명 : 실패 
 * 
 * @ 김지민
 * 
 */

public class FailureRate {

	class Score implements Comparable<Score>{
	    int idx;
	    float percent;
	    
	    public Score(int idx, float percent){
	        this.idx = idx;
	        this.percent = percent;
	    }
	    
	    public int compareTo(Score o){
	        if(this.percent>o.percent){
	            return -1;
	        }else if(this.percent<o.percent){
	            return 1;
	        }else{
	            if(this.idx>o.idx){
	                return 1;
	            }else{
	                return -1;
	            }
	        }
	    }
	    
	    public String toString(){
	        return idx+"";
	    }
	}


	class Solution {
	    public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N]; //결과 
	        PriorityQueue<Score>pq = new PriorityQueue<>(); //스테이지번호, 실패율을 담을 큐
	        int [] success = new int[N+1]; // success[0] 의 값은 1번 스테이지를 못깬사람
	        for(int i =0; i<stages.length; i++){
	            success[stages[i]-1]++;
	        } 
	        
	        float [] percent = new float[N];
	       
	        int sum=0;
	        for(int i=0; i<percent.length;i++){
	            percent[i]=(float)success[i]/(stages.length-sum);
	            sum+=success[i];
	            pq.add(new Score(i+1,percent[i]));
	        }

	        for(int i=0; i<answer.length;i++){
	            answer[i] = pq.peek().idx;
	            pq.remove();
	        }
	        return answer;
	    }
	}
}

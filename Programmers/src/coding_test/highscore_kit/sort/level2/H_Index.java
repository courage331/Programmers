package coding_test.highscore_kit.sort.level2;
/*
 * 
 * 테스트명 : H-Index
 * 
 * @ 김지민
 * 
 */
public class H_Index {
	    public int solution(int[] citations) {    
	        int answer = 0;
	        int max_count = 0;

	        for(int i =0; i<=citations.length; i++){
	            max_count =0;
	            for(int j=0; j<citations.length; j++){
	                if(citations[j]>=i){
	                    max_count++;
	                }
	            }
	            if(max_count>=i){
	                answer=Math.max(answer,i);
	            }
	        }
	        
	        return answer;
	    }
}

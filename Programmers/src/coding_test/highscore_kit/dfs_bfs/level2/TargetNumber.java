package coding_test.highscore_kit.dfs_bfs.level2;
/*
 * 
 * 테스트명 : 타겟 넘버
 * 
 * @ 김지민
 */

public class TargetNumber {

	    static int answer=0;
	    
	    public static void dfs(int idx, int sum, int target, int [] numbers){
	                       
	        
	        if(idx==numbers.length){
	            
	            if(sum == target){
	                answer++;
	                return;
	            }
	            return;
	        }

	            dfs(idx+1,sum+numbers[idx], target, numbers);
	            dfs(idx+1,sum-numbers[idx], target, numbers);  
	        
	    }
	    
	    public int solution(int[] numbers, int target) {
	        int sum = 0;
	        
	        dfs(1,numbers[0],target,  numbers);
	        dfs(1,-numbers[0],target, numbers);
	        
	        return answer;
	}
}

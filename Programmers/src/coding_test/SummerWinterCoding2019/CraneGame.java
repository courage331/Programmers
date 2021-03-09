package coding_test.SummerWinterCoding2019;
import java.util.*;

/*
 * 
 * 테스트명 : 크레인 인형뽑기 게임  
 * 
 * @ 김지민
 * 
 */

public class CraneGame {

	class Solution {
	    public int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        Stack<Integer>res = new Stack();
	        
	        int  [] height = new int[board.length];
	        Arrays.fill(height,0);
	        for(int i=0; i<board.length;i++){
	            for(int j=0; j<board[i].length; j++){
	                if(board[i][j]!=0 && height[j]==0){
	                    height[j]=board.length-i;
	                }
	            }
	        }
	        System.out.println(Arrays.toString(height));
	        
	        
	        for(int i=0; i<moves.length; i++){
	            if(height[moves[i]-1]==0){
	                continue;
	            }
	            
	            if(board[board.length-height[moves[i]-1]][moves[i]-1]!=0){
	                if(res.size()==0){
	                     res.push(board[board.length-height[moves[i]-1]][moves[i]-1]);
	                    
	                }else{
	                    if(res.peek()==board[board.length-height[moves[i]-1]][moves[i]-1]){
	                        res.pop();
	                        answer+=2;
	                    }else{
	                        res.push(board[board.length-height[moves[i]-1]][moves[i]-1]);
	                    }
	                }
	                 height[moves[i]-1]--;

	            }
	        }
	        System.out.println(res.toString());
	        return answer;
	    }
	}
}

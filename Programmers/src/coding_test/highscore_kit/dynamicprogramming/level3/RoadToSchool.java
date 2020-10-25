package coding_test.highscore_kit.dynamicprogramming.level3;

import java.util.*;
/*
 * 
 * 테스트명 : 등굣길
 * 
 * @ 김지민
 * 
 
 * 
 */
public class RoadToSchool {

	    public long solution(int m, int n, int[][] puddles) {
	        long answer=0;
	        long [][] arr= new long[n][m];
	        for(long []a : arr){
	            Arrays.fill(a,1);
	        }

	        
	        for(int i=0; i<puddles.length;i++){
	            arr[ puddles[i][1]-1 ][ puddles[i][0]-1 ] =0;
	            
	            //arr[1][0] == 0
	            if(puddles[i][0]-1 == 0){
	                for(int j=puddles[i][1]; j<n; j++){
	                    arr[j][0]=0;
	                }
	            }
	            //arr[0][1]==0
	            if(puddles[i][1]-1 == 0){
	                for(int j=puddles[i][0]; j<m; j++){
	                    arr[0][j]=0;
	                }
	            }
	            
	        }
	        
	        for(int i=1; i<arr.length; i++){
	            
	            for(int j=1; j<arr[i].length; j++){

	                if(arr[i][j]==0){
	                    continue;
	                }
	                arr[i][j] = (arr[i-1][j] +arr[i][j-1])%1_000_000_007;

	            }
	        }

	        
	        // answer = arr[n-1][m-1];
	        return arr[n-1][m-1];
	    }
	}

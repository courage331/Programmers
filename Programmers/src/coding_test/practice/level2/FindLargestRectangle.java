package coding_test.practice.level2;

import java.util.*;

import java.util.*;

/*
 *
 * 테스트명 : 가장 큰 정사각형 찾
 *
 * @ 김지민
 *
 */

public class FindLargestRectangle {

    class Solution{
        public int solution(int [][]board){
            int answer = 0;
            int sum = 0;
            int [][] dp = new int[board.length][board[0].length];

            for(int i=0; i<board.length; i++){
                dp[i][0] = board[i][0];
                sum+=dp[i][0];
            }

            for(int i=0; i<board[0].length; i++){
                dp[0][i]=board[0][i];
                sum+=dp[0][i];
            }

            if(sum>0){
                answer=1;
            }

            //System.out.println(Arrays.deepToString(dp));
            for(int i=1; i<dp.length;i++){
                for(int j=1; j<dp[0].length; j++){

                    if(board[i][j]==0){
                        // System.out.println("if문 : "+i+" "+j);
                        dp[i][j]=0;
                    }else if(dp[i-1][j-1]==0 || dp[i-1][j]==0 || dp[i][j-1]==0){
                        // System.out.println("else if문1 : "+i+" "+j);
                        dp[i][j]=1;
                        //System.out.println(Arrays.deepToString(dp));
                    }else if(dp[i-1][j-1]==dp[i-1][j] && dp[i-1][j]==dp[i][j-1]){
                        // System.out.println("else if문2 : "+i+" "+j);
                        dp[i][j]= ((int)(Math.sqrt(dp[i-1][j-1]))+1 )*((int)(Math.sqrt(dp[i-1][j-1]))+1);
                    }else{
                        // System.out.println("else 문 : "+i+" "+j);
                        int min = Math.min(dp[i-1][j-1],dp[i-1][j]);
                        dp[i][j]= (int)(Math.sqrt(Math.min(min,dp[i][j-1])))+1;
                        dp[i][j] = dp[i][j]*dp[i][j];

                    }
                    answer=Math.max(answer,dp[i][j]);
                    //System.out.println(Arrays.deepToString(dp));
                }

            }
            // System.out.println(Arrays.deepToString(dp));

            return answer;
        }


    }

}

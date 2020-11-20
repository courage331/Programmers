package coding_test.SummerWinterCoding2018;

import java.util.*;

/*
 * 
 * 테스트명 : 숫자 게임
 * 
 * @ 김지민
 * 
 */

class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int right=B.length-1;
        for(int i =A.length-1; i>=0; i--){
            if(A[i]<B[right]){
                right--;
                answer++;
            }
        }
        return answer;
    }
}
package coding_test.SummerWinterCoding2018;

import java.util.*;
/*
 * 
 * 테스트명 : 소수 만들기
 * 
 * @ 김지민
 * 
 */
public class JumpAndTeleport {
    public int solution(int n) {
        int ans = 0;

        while(true){
            if(n%2==0){
                n = n/2;
            }else{
                n=n-1;
                ans++;
            }
            
            if(n==0){
                break;
            }
        }

        return ans;
    }
}
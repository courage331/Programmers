package coding_test.practice.level2;

import java.util.*;

/*
 * 
 * 테스트명 : 124 나라의 숫자
 * 
 * @ 김지민
 * 
 */

class OnetwoFourCountry {
    public String solution(int n) {
        String answer = "";
        int temp=n;
        if(n==1){return "1";}
        if(n==2){return "2";}
        if(n==3){return "4";}
        
        int divider=0;
        while(temp>0){
            divider = temp/3;
            if(temp%3==0){
                divider--;
                answer+="4";
            }else if(temp%3==1){
                answer+="1";
            }else{
                answer+="2";
            }
            temp=divider;
            
            if(divider<=0){
                answer = reverseString(answer);
                break;
            }
            
        }
        return answer;
    }
    
      public static String reverseString(String s) {
        return ( new StringBuffer(s) ).reverse().toString();
      }
}

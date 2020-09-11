package coding_test.highscore_kit.bruteforce.level2;

import java.util.*;

/*
 * 
 * 테스트명 : 카펫
 * 
 * @ 김지민
 * 
 
 * 
 */

class Num implements Comparable<Num>{
    
    int a;
    int b;
    
    public Num(int a, int b){
        this.a=a;
        this.b=b;
    }
    
    public int compareTo(Num o){
        if(a-o.a>0)
            return 1;
        else
            return -1;
    }
}

class Carpet {
    public int[] solution(int brown, int yellow) {
        PriorityQueue<Num>res = new PriorityQueue<>();
        int count=1;
        int minumum =2_000_000;
        while(true){
            if(count>=minumum){
                break;
            }
            if(yellow%count==0){
                minumum=yellow/count;
                res.offer(new Num(count, yellow/count));
                count++;
            }
            else{
                count++;
                continue;
            }
            
        }
        while(!res.isEmpty()){
           int weigth = res.peek().b;
           int height = res.peek().a;
           int border= (height + weigth)*2+4;
            res.poll();
            if(border==brown){
                return new int[] {weigth+2,height+2};
            }
        }        
        
        
        return null;
    }
}
/* 간단하게 줄인 버전
 *
 java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i=1; i<=yellow; i++){
            if(yellow%i==0){ 
                if(brown == ((i+yellow/i)*2+4) ) {
                    return new int[]{yellow/i+2, i+2};
                }
           }
        }     
        return null;
    }
} 
 * 
 */


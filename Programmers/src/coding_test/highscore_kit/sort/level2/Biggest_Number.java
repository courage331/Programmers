package coding_test.highscore_kit.sort.level2;


import java.util.*;

/*
 * 
 * 테스트명 : 가장 큰 수
 * 
 * @ 김지민
 * 
 */

class Num implements Comparable<Num>{
    
    String number;
    public Num(String number){
        this.number = number;
    }
    
    public int compareTo(Num o){
        String temp1 = number+o.number;
        String temp2 = o.number+number;
        
        
        
        if(temp2.compareTo(temp1)>=0){
            return 1;
        }
            
        else{
            return -1;
        }
    }
    public String toString(){
        String ttt = number+"";
        return ttt;
    }
    
    
}
public class Biggest_Number {
    public String solution(int[] numbers) {
        PriorityQueue<Num> pq = new PriorityQueue<Num>();
         String answer = "";
        for(int i =0; i<numbers.length; i++){
            String ttt= Integer.toString(numbers[i]);
            pq.offer(new Num(ttt));
        }
       for(int i =0; i<numbers.length; i++){
            //System.out.println(pq.poll());
            //0일떄 해결하기
            answer+=pq.poll(); 
        }
        
        if(answer.charAt(0)=='0'){
            answer="0";
        }

        
       
        return answer;
    }
}

package coding_test.highscore_kit.heap.level3;

import java.util.*;


/*
 * 
 * 테스트명 : 이중 우선 순위 큐  
 * 
 * @ 김지민
 * 
 */


class Num implements Comparable<Num>{ 

    int number;
    
    public Num (String num){
        this.number = Integer.parseInt(num);
    }
    
    public int compareTo(Num o){

        if(this.number>o.number){
            return 1;
        }else if(this.number < o.number){
            return  -1;
        }else 
            return 0;
    }
    
    public String toString(){
        String res = Integer.toString(number);
        return res;
    }
    
}


class Double_Priority_Queue {
    public int[] solution(String[] operations) {
         PriorityQueue<Num> pq = new PriorityQueue<Num>(); //오름차순으로 정렬한다.   
         Stack<Num>st = new Stack<Num>(); //오름차순으로 정렬한것이 stack에 담기므로 stack의 peek는 최댓값이다.

        for(int i = 0; i <operations.length; i ++){
            if(operations[i].split(" ")[0].equals("I")){
                pq.offer(new Num(operations[i].split(" ")[1]));
            }
            else if(operations[i].split(" ")[0].equals("D"))
            {
                if(operations[i].split(" ")[1].equals("-1")){
                    pq.poll();
                }else{
                    while(!pq.isEmpty()){
                        st.push(pq.poll());
                    }
                    if(!st.isEmpty()){
                        st.pop();
                    }
                    while(!st.isEmpty()){
                        pq.offer(st.pop());
                    }

                }
 
            }  
        }
        //answer =[최댓값, 최솟값]
        int[] answer = new int[2];
        if(pq.isEmpty()){
           
        }else{
            answer[1]=pq.peek().number;
            while(!pq.isEmpty()){
                st.push(pq.poll());
            }
            answer[0]=st.peek().number;
        }
     return answer;
    }
}

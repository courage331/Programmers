package coding_test.highscore_kit.dfs_bfs.level3;

import java.util.*;
/*
 *  테스트명 : 여행경로
 * 
 * @ 김지민
 * 
 * 
 * 
 * */

class Info implements Comparable<Info>{
    
    String city;
    int idx;
    public Info(String city, int idx){
        this.city=city;
        this.idx=idx;
    }
    
    public int compareTo(Info o){

        return city.compareTo(o.city);
    } 
    
    public String toString(){
        return city+" "+idx;
    }
    
}

class TravelRoute {
    static String [] answer;
    static ArrayList<String> arr = new ArrayList();
    static boolean chk_f = false; //완전히 경로를 찾았는지 체크...
    
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        boolean [] checker = new boolean[tickets.length];
        //기본값 false
        
        answer[0]="ICN";
        dfs("ICN",checker,tickets,1); 
        
        return answer;
    }
    
    public static void dfs(String airport,boolean[] checker, String[][] tickets,int num){
        PriorityQueue<Info>info = new PriorityQueue();
        if(chk_f){ //경로를 이미 다 찾은 경우 무조건 return 시킨다.
            return;
        }
        
        if(num==tickets.length+1){
            chk_f=true; //최종경로에 도착한 경우 true로 바꿔준다.
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(airport) && !checker[i]){
                info.add(new Info(tickets[i][1],i));
            }
        }
        //해당 dfs에서 갈수있는 경우가 없는경우 return 시켜준다.
        if(info.isEmpty()){
            return;
        }
        
        while(!info.isEmpty()){   
            String city=info.peek().city;
            int idx = info.peek().idx;
            info.poll();
            
            checker[idx]=true;
            answer[num]=city;
            dfs(answer[num],checker,tickets,++num);
            if(chk_f){ //이미 경로를 다 찾은 경우 return 시켜준다.
                return;
            }
            checker[idx]=false;
            num--;
        }

    }//dfs 끝
}
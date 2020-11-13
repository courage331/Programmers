package coding_test.SummerWinterCoding2018;

import java.util.*;

/*
 * 
 * 테스트명 : 방문길이
 * 
 * @ 김지민
 * 
 */
class VisitLength {
    static int start_x=5;
    static int start_y=5;
    static ArrayList<String>list = new ArrayList<String>();
    static int answer=0;
    
    public int solution(String dirs) {
        
        for(int i = 0; i<dirs.length(); i++){
            move(dirs.substring(i,i+1));
        }
        
        return answer;
    }
    public static void move(String dir){
        String loca =start_y+""+start_x;
        switch(dir){
            case "U":
                if(start_y==0) //더 이상 올라갈 수 없다.
                    break;
                start_y--;
                if(list.contains((loca+""+(start_y)+""+start_x))){
                    //이미 지났던 길
                }else{
                    //지나지 않은 길
                    list.add(loca+""+(start_y)+""+start_x);
                    list.add((start_y)+""+start_x+""+loca);
                    answer++;
                }
                break;
                
             case "D":
                if(start_y==10) //더 이상 올라갈 수 없다.
                    break;
                start_y++;
                if(list.contains((loca+""+(start_y)+""+start_x))){
                    //이미 지났던 길
                }else{
                    //지나지 않은 길
                    list.add(loca+""+(start_y)+""+start_x);
                    list.add((start_y)+""+start_x+""+loca);
                    answer++;
                }
                break;
                
            case "L":
                if(start_x==0) //더 이상 올라갈 수 없다.
                    break;
                start_x--;
                if(list.contains((loca+""+(start_y)+""+start_x))){
                    //이미 지났던 길
                }else{
                    //지나지 않은 길
                    list.add(loca+""+(start_y)+""+start_x);
                    list.add((start_y)+""+start_x+""+loca);
                    answer++;
                }
                break;
                
            case "R":
                if(start_x==10) //더 이상 올라갈 수 없다.
                    break;
                start_x++;
                if(list.contains((loca+""+(start_y)+""+start_x))){
                    //이미 지났던 길
                }else{
                    //지나지 않은 길
                    list.add(loca+""+(start_y)+""+start_x);
                    list.add((start_y)+""+start_x+""+loca);
                    answer++;
                }
                break;
                
             default :
                break;
                
        }//switch
     
    }//move
    
}
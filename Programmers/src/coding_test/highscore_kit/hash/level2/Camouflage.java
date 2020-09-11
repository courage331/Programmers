package coding_test.highscore_kit.hash.level2;
/*
 * 
 * 테스트명 : 위장
 * 
 * @ 김지민
 * 
 
 * 
 */
import java.util.*;

class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1; 
        HashMap<String,Integer>category = new HashMap(); //<옷의 종류, 개수>
        for(int i=0; i<clothes.length;i++){
            int count = category.containsKey(clothes[i][1])?  category.get(clothes[i][1]) : 0;
            //만약 해당 key값을 가지고 있다면 count는 그것의 value를가지거나
            //해당 key값이 없다면 0으로 해준다.
            category.put(clothes[i][1],count+1); //hashmap에 넣을때는 count에 +1을 해준다.
        }
        
        /*
	            여러 종류의 옷을 입을때의 경우의 수
	            (각 옷의 종류+1)을 해주고 모든 종류의 옷을 곱한뒤 -1을 해준다.
	            ex) A:3가지, B:2가지, C:1가지인 경우
	            (3+1) * (2+1) * (1+1) -1 = 23
	            
	            1개만 입는 경우 : (a1),(a2),(a3),(b1),(b2),(c1)  ->6가지
	            2개만 입는 경우 : ((a1,b1),(a1,b2),(a1,c1)) *3 ,(b1,c1),(b2,c2)  ->11가지
	            3개만 입는 경우 (a1,b1,c1),(a1,b2,c1),(a2,b1,c2),(a2,b2,c1).(a3,b1,c1),(a3,b2,c1)->6가지
	            총 23가지 경우
        */
        Iterator<Integer>sum = category.values().iterator(); //category value들을 담아주고
        while(sum.hasNext()){
               int value = sum.next()+1;
               answer*=value; //각 value들에다가 1을 더해주고 answer에다가 곱해준다.
            //answer는 0으로 해둘경우 곱셈에서 0이 되므로 1로 초기선언
        }
        return (answer-1); //결과값에서 -1을 해주고 return 한다.
    }
}

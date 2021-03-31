package coding_test.kakao_blind_recruitment_2018;

import java.util.*;

/*
 *
 * 테스트명 : 캐시
 *
 * @ 김지민
 *
 */

public class Cache {

        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            List<String>arr = new ArrayList<>();

            if(cacheSize==0){
                return cities.length * 5;
            }else{
                arr.add(cities[0].toLowerCase());
                answer+=5;
            }


            for(int i=1; i<cities.length; i++){
                cities[i] = cities[i].toLowerCase();

                if(arr.size()<cacheSize){
                    if(arr.contains(cities[i])){
                        arr.remove(cities[i]);
                        arr.add(cities[i]);
                        answer+=1;
                    }else{
                        arr.add(cities[i]);
                        answer+=5;
                    }


                }else{
                    if(arr.contains(cities[i])){
                        arr.remove(cities[i]);
                        arr.add(cities[i]);
                        answer+=1;
                    }else{
                        arr.remove(0);
                        arr.add(cities[i]);
                        answer+=5;
                    }
                }
            }

            return answer;
        }

}

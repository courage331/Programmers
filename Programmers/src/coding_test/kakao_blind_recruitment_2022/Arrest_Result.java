import java.util.*;

/*
 *
 * 테스트명 : 신고 결과 받기
 *
 * @ 김지민
 *
 */

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer>idx = new HashMap();
        for(int i=0; i<id_list.length; i++){
            idx.put(id_list[i],i);
        }
        Map<String,String> map = new HashMap();
        Set<String> set = new HashSet();
        for(int i=0; i<report.length; i++){
            set.add(report[i]);
        }

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            String data = iter.next();
            String [] arr = data.split(" ");
            if(!map.containsKey(arr[1])){
                map.put(arr[1],arr[0]+",");
            }else{
                String value = map.get(arr[1]);
                map.put(arr[1],value+arr[0]+",");
            }
        }
        Set<String>keys = map.keySet();
        Iterator<String> iter2 = keys.iterator();
        while(iter2.hasNext()){
            String [] data = map.get(iter2.next()).split(",");
            if(data.length>=k){
                for(int i=0; i<data.length; i++){
                    answer[idx.get(data[i])]++;
                }
            }

        }

        return answer;
    }
}
package coding_test.highscore_kit.hash.level3;

/*
 *  
 * 테스트명 : 베스트 앨범
 *
 * @김지민
 * 
 * 
 */

import java.util.*;

class PlayTime{ //장르, 재생횟수, 고유번호를 담아줄 class 
    String genre; 
    int play;
    int num;
    public PlayTime(String genre, int play, int num) {
        super();
        this.genre = genre;
        this.play = play;
        this.num=num;
    }
    @Override
    public String toString() {
        return genre+","+Integer.toString(play)+","+Integer.toString(num);
    }
}

class BestAlbum {
    public static <K, V> K getKey(Map<K, V> map, V value) {//value 값으로 key를 찾는 method
	 
		for (K key : map.keySet()) {
			if (value.equals(map.get(key))) {
				return key;
			}
		}
		return null;
	}
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer>category = new HashMap();//제일 많이 담긴것을 찾기 위함
        HashMap<Integer, Integer>playsC = new HashMap(); //<고유번호, 재생횟수>
        List<PlayTime>playtime = new ArrayList<>(); 
        ArrayList<Integer>answer_array = new ArrayList<>(); //제일 많이들은것, 그 다음으로 들은것을 담아줌
        
        for(int i=0; i<genres.length; i++){ 
            int count = category.containsKey(genres[i])? category.get(genres[i])+plays[i] : plays[i]; 
            category.put(genres[i], count); 
            playsC.put(i,plays[i]);
            playtime.add(new PlayTime(genres[i],plays[i],i));              
        }
        
        while(true){
            int max=Collections.max(category.values()); //가장 많이 들은 값을 찾음(value)
            String max_genre = getKey(category,max); //가장 많이 들은값(value)로 장르(key)값을 찾음
            int top1=0; //제일 많이 들은것
            int top2=0; //두번째로 많이 들은것 
            for(int i=0; i<playtime.size(); i++){
                if(String.valueOf(playtime.get(i)).contains(max_genre)){
                   if(Integer.parseInt(String.valueOf(playtime.get(i)).split(",")[1])>top1){
                       top2=top1;
                       top1=Integer.parseInt(String.valueOf(playtime.get(i)).split(",")[1]);
                   }else if(Integer.parseInt(String.valueOf(playtime.get(i)).split(",")[1])<=top1 
                            && Integer.parseInt(String.valueOf(playtime.get(i)).split(",")[1])>top2){
                       top2=Integer.parseInt(String.valueOf(playtime.get(i)).split(",")[1]);
                   }else{
                       continue;
                   }   
                }
                    
            }
            answer_array.add(getKey(playsC,top1));
            playsC.remove(getKey(playsC,top1)); //top1에 해당하는 값을 지워야 top2의 고유번호를 찾을 수 있다...
            if(top2!=0){
                answer_array.add(getKey(playsC,top2));
            }
            category.remove(max_genre); //가장 많이 들은 장르를 제거함

            if(category.size()==0)//모든 genre가 다 나오면 while문 탈출
                break;
        }
      int [] answer = new int[answer_array.size()];
      for(int i=0; i<answer.length;i++){
          answer[i]=answer_array.get(i);
      }
        
    return answer;  
    }
}
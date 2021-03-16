package coding_test.kakao_blind_recruitment_2018;
import java.util.*;

/*
 * 
 * 테스트명 : 다트 게임  
 * 
 * @ 김지민
 * 
 */
public class Dart_Game {

	    class Score{
	        
	        int num;
	        String bonus;
	        String option;
	        
	        //각 기회의 점수, 보너스영역(제곱), 옵션(#,*) 
	        public Score(int num, String bonus, String option){
	            this.num=num;
	            this.bonus=bonus;
	            this.option=option;
	        }
	        
	    }
	    
	    public int solution(String dartResult) {
	        int answer = 0;
	        List<Score> arr = new ArrayList<>();
	        
	        String num="";
	        String bonus="";
	        String option="";
	        int len = dartResult.length();
	        int cnt =0;
	        
	        for(int i=0; i<len; i++){
	            String temp = dartResult.substring(i,i+1);
	            if(dartResult.charAt(i)<=57 && dartResult.charAt(i)>=48){
	                num+=temp;
	            }else {
	                if(i==(len-1)){
	                     if(temp.equals("S")||temp.equals("D")||temp.equals("T")){
	                            bonus=temp;
	                        }else{
	                            option=temp;
	                        }
	                     arr.add(new Score(Integer.parseInt(num),bonus,option));
	                }else{
	                     if(temp.equals("S")||temp.equals("D")||temp.equals("T")){
	                            bonus=temp;
	                        }else{
	                            option=temp;
	                        }
	                    
	                    if(dartResult.charAt(i+1)<=57 && dartResult.charAt(i+1)>=48){
	                        arr.add(new Score(Integer.parseInt(num),bonus,option));
	                        num="";
	                        bonus="";
	                        option="";
	                    }
	                }
	            }
	        }    
	 
	        int [] score = new int[3];
	        
	        for(int i=0; i<score.length; i++){
	            if(arr.get(i).option.equals("*")){
	                score[i]=calc(arr.get(i).num,arr.get(i).bonus,arr.get(i).option);
	                if(i!=0){
	                   score[i-1]*=2;
	                }
	            }else{
	                score[i]=calc(arr.get(i).num,arr.get(i).bonus,arr.get(i).option);
	            }
	        }
	        
	        for(int i=0; i<score.length; i++){
	            answer += score[i];
	        }
	        
	        return answer;
	    }
	    
	    public int calc(int num, String bonus, String option){
	        int res=0;
	        if(bonus.equals("S")){
	            res = num;
	        }else if(bonus.equals("D")){
	            res = num*num;
	        }else{
	            res = num*num*num;
	        }
	        
	        if(option.equals("*")){
	            res *=2;
	        }else if(option.equals("#")){
	            res *=-1;
	        }else{
	            
	        }
	        
	        
	        return res;
	    }
	
}

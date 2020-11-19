package coding_test.SummerWinterCoding2018;

import java.util.*;
/*
 * 
 * 테스트명 : 영어 끝말잇기
 * 
 * @ 김지민
 * 
 */
public class WordChain {

	    static ArrayList<String>arr = new ArrayList();
	    
	    public int[] solution(int n, String[] words) {
	        int[] answer = new int[]{0,0};

	        arr.add(words[0]);
	        for(int i =1; i<words.length;i++){
	 
	            if(!same(words[i]) || !link(words[i-1],words[i])){
	                System.out.println(i);
	                answer[0]=i%n +1;
	                answer[1]=i/n +1;
	                break;
	            }
	        }
	       

	        return answer;
	    }
	    
	    public static boolean same(String s){
	        
	        if(arr.contains(s)){
	            return false;
	        }else{
	            arr.add(s);
	            return true;
	        }
	    }
	    
	    public static boolean link(String s1, String s2){
	        System.out.println(s1.substring(s1.length()-1,s1.length()));
	        if(s1.substring(s1.length()-1,s1.length()).equals(s2.substring(0,1))){
	            return true;
	        }else{
	            return false;
	        }
	}
}

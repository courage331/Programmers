package coding_test.practice.level2;

/*
 * 
 * 테스트명 : 문자열 다루기 기본 
 * 
 * @ 김지민
 * 
 */

public class PracticeString {
	    public boolean solution(String s) {
	        
	        if(s.length()==4 || s.length()==6){
	            for(int i=0; i<s.length(); i++){
	                
	                if(s.charAt(i)<48 || s.charAt(i)>57)
	                    return false;
	            }
	            return true;
	        }else{
	            return false;
	        }
	        
	        
	       
	}
}

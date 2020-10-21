package coding_test.highscore_kit.greedy.level2;

import java.util.*;

/*
 * 
 * 테스트명 : 조이스틱
 * 
 * @ 김지민
 * 
 */

public class JoyStick {
	    public int solution(String name) {
			int answer = 0;
	        StringBuilder sb= new StringBuilder(name);
	        String init="";
	        for(int i=0; i<name.length(); i++){
	            init+="A";
	        }
	        int value =0;
	        int idx=0;
	        int cnt=1;
	        String pos="R"; 
	        while(true){
	            value = sb.charAt(idx)-'A';
	            if(value>13){ //이전 알파벳
	                sb.setCharAt(idx, 'A');
	                answer+=Math.abs(26-value);
	            }else{//다음 알파벳
	                sb.setCharAt(idx, 'A');
	                answer+=value;
	            }
	            //종료조건
	            if(sb.toString().equals(init)){
	                break;
	            }
	            cnt = 1;
	            while(true){
	            	if(pos.equals("R")) {
	            		int len=0;
	            		if(idx<cnt) {
	            			len = sb.length()-(cnt-idx);
	            		}else {
	            			len = idx-cnt;
	            		}
	                    if(sb.charAt(idx+cnt)!='A' && sb.charAt(len) =='A'){ //오른쪽 커서
	                        idx=(idx+1);
	                        answer+=1;
	                        break;
	                    }else if(sb.charAt(idx+cnt)=='A' && sb.charAt(len) !='A'){ //왼쪽커서
	                    	if(idx==0)
	                    		idx=(len);
	                    	else
	                    		idx=(idx-1);
	                        answer+=1;
	                        pos="L";
	                        break;
	                    }else if(sb.charAt(idx+cnt)=='A' && sb.charAt(len) =='A'){// 그 다음것을 봐야함
	                    	cnt++;
	                    }else{ //둘다
	                        idx++;
	                        answer++;
	                        break;
	                    }
	            	}else{//(pos.equals("L")) 
	                        idx--;
	                        if(idx<0) {
	                        	idx=sb.length()-1;
	                        }
	                        answer++;
	                        break;
	            	}

	            }//좌우 while
	            
	        }//큰 while
	        return answer;
	    }
}

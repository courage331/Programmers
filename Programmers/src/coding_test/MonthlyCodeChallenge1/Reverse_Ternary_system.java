package coding_test.MonthlyCodeChallenge1;

/*
 * 
 * 테스트명 : 3진법 뒤집기  
 * 
 * @ 김지민
 * 
 */

public class Reverse_Ternary_system {
	    public int solution(int n) {
	        int answer = 0;
	        String res = changeNum(n,3);
	        //10진법으로 변환
	        for(int i=0; i<res.length(); i++){
	            answer+= Integer.parseInt(res.substring(i,i+1))*Math.pow(3,res.length()-(i+1));
	        }
	        
	        //System.out.println(res);
	        return answer;
	    }
	    
	    public String changeNum(int n, int m){
	        String result = "";
	        int temp=n;
	        
	        while(true){
	            if(temp/3>0){
	                result+=temp%3;
	                temp= temp/3; 
	                //15  0    //24   0   
	                //5   0    //8    0
	                //1   2    //2    2
	            }else{
	                result+=temp;
	                break;
	            }
	        }           
	        return result;
	    }
}

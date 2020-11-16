package coding_test.SummerWinterCoding2018;

import java.util.*;

/*
 * 
 * 테스트명 : 소수 만들기
 * 
 * @ 김지민
 * 
 */

class MakePrimeNumber {

    static int [] arr = new int [3001];
    
    
    public static void arith(){
        arr[0]=0;
        arr[1]=0;
        
        for(int i=2; i<arr.length;i++){
            arr[i]=i;
        }
        
        for(int i=0; i<arr.length; i++){
            
            if(arr[i]==0) continue;
            
            for(int j=i*2; j<arr.length; j+=i){
                arr[j]=0;
            }
        }
        
        
        
    }    

    
    
    public int solution(int[] nums) {
        int answer = 0;
        arith();
        //System.out.println(Arrays.toString(arr));
        for(int i=0; i<nums.length-2;i++){
            for(int j =i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(arr[nums[i]+nums[j]+nums[k]]!=0){
                        //System.out.println(i+" "+j+" "+k);
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
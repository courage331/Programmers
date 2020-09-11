package coding_test.highscore_kit.bruteforce.level2;
/*
 * 
 * 테스트명 : 소수 찾기
 * 
 * @ 김지민
 * 
 
 * 
 */
import java.util.*;

class Solution {
    
    static TreeSet<String> trr = new TreeSet<String>();
    static String[] number;
    static boolean [] check;
    static int answer = 0;
    
    public static void dfs(String num){
        for(int i=0; i <number.length; i++){
            if(!check[i]){
                
                if(num.equals("") && number[i].equals("0")){
                    check[i]=true;
                    dfs("");
                    check[i]=false;
                }else{
                    check[i]=true;
                    trr.add(num+number[i]);
                    dfs(num+number[i]);
                    check[i]=false;
                   
                }
            }
            
        }
        return;
    }   
    
    public static void arithmatic(String value){
        int val = Integer.parseInt(value);
        long [] arr = new long[val+1];
        arr[0]=1;
        arr[1]=1;
        
        for(int i =2; i<arr.length; i++){
            if(arr[i]==0){
                for(int j=i+i;j<arr.length; j+=i){
                    arr[j]=1;
                }
            }else{
                continue;
            }
        }
        for(String str : trr){
            if(arr[Integer.parseInt(str)]==0){
                System.out.println(str);
                answer++;
            }
        }

        
    }
    
    public int solution(String numbers) {
        
        number = numbers.split("");
        check = new boolean[number.length];
        Arrays.fill(check, false);
        
        
        for(int i =0; i<number.length; i++){
            check[i] = true;
            if(number[i].equals("0")){
                dfs("");
            }
            else{
                trr.add(number[i]);
                dfs(number[i]);
            }
            check[i]=false;   
        }
        
        arithmatic(trr.last());
        
        return answer;
    }
}
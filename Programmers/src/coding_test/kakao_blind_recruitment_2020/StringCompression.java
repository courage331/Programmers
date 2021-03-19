package coding_test.kakao_blind_recruitment_2020;
import java.util.*;

/*
 *
 * 테스트명 : 문자열 압축
 *
 * @ 김지민
 *
 */

public class StringCompression {

        public int solution(String s) {
            int answer = s.length();

            for(int i =1; i<s.length(); i++){
                String word="";
                int cnt=1;
                String [] arr;
                if(s.length()%i==0){
                    arr = new String[s.length()/i];
                }else{
                    arr = new String[(s.length()/i)+1];
                }

                //배열에 값 넣기
                String temp = s;
                for(int j=0; j<arr.length; j++){
                    if(temp.length()>i){
                        arr[j]=temp.substring(0,i);
                        temp = temp.substring(i,temp.length());
                    }else{
                        arr[j]=temp.substring(0);
                    }

                }

                for(int j=0; j<arr.length; j++){
                    //마지막
                    if(j==arr.length-1){
                        if(arr[j].equals(arr[j-1])){
                            word+=cnt+arr[j];
                        }else{
                            if(cnt==1){
                                word+=arr[j];
                            }else{
                                word+=cnt+arr[j-1]+arr[j];
                            }
                        }
                    }else{
                        if(arr[j].equals(arr[j+1])){
                            cnt++;
                        }else{
                            if(cnt==1){
                                word+=arr[j];
                            }else{
                                word+=cnt+arr[j];
                                cnt=1;
                            }

                        }
                    }


                }
                // System.out.println(word);
                // System.out.println(Arrays.toString(arr));
                if(answer>word.length()){
                    answer=word.length();
                }
            }


            return answer;
        }

}

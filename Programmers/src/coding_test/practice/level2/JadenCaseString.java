package coding_test.practice.level2;

/*
 *
 * 테스트명 : JadenCase 문자열
 *
 * @ 김지민
 *
 */

public class JadenCaseString {
        public String solution(String s) {
            String answer = "";
            boolean chk = true;
            for(int i=0; i<s.length(); i++){
                if(" ".equals(s.substring(i,i+1))){
                    chk = true;
                    answer+=" ";
                }else{
                    if(chk){
                        answer+=s.substring(i,i+1).toUpperCase();
                        chk = false;
                    }else{
                        answer+=s.substring(i,i+1).toLowerCase();

                    }
                }

            }

            return answer;
    }
}

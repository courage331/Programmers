package coding_test.SummerWinterCoding2018;

import java.util.*;

/*
 * 
 * 테스트명 : 스킬트리
 * 
 * @ 김지민
 * 
 */

class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int pos;
        StringBuffer sb = new StringBuffer();
        
        
        for(int i=0; i<skill_trees.length; i++){
            for(int j=0; j<skill_trees[i].length(); j++){
                if(skill.contains(skill_trees[i].substring(j,j+1))){
                    sb.append(skill_trees[i].charAt(j));
                }
                
            }
            answer+=skillcheck(sb, skill);
            sb.setLength(0); 
        }
        return answer;
    }
    
    public static int skillcheck(StringBuffer sb, String skill){
        int cnt=0;
        if(sb.length() == skill.length()){
            for(int i=0; i<skill.length();i++){
                if(!sb.substring(i,i+1).equals(skill.substring(i,i+1))){
                    return 0;
                }
            }
            return 1;
        }else{
            for(int i=0; i<sb.length(); i++){
                if(!sb.substring(i,i+1).equals(skill.substring(i,i+1))){
                   return 0;
                }
            }
            return 1;
        }
    }

    
}

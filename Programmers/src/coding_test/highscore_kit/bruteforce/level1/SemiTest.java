package coding_test.highscore_kit.bruteforce.level1;

import java.util.*;

/*
 * 
 * 테스트명 : 모의고사
 * 
 * @ 김지민
 * 
 */

class Student implements Comparable<Student>{
    int correct;
    int num;
    
    public Student(int correct, int num){
        this.correct = correct;
        this.num=num;
    }
    
    public int compareTo(Student o){
        if(o.correct>=correct){
            return -1;
        }else{
            return 1;
        }
        
    }
    
    public String toString(){
        
        String ttt= num+"번 : "+correct;
        
        return ttt;
    }
    
    
}

class Solution {
    public int[] solution(int[] answers) {
        int length=1;
        
        int [] first={1,2,3,4,5};
        int [] second={2,1,2,3,2,4,2,5};
        int [] third={3,3,1,1,2,2,4,4,5,5};
        
        int [] correct = new int[3];
        ArrayList<Student> rank = new ArrayList<>();
        for(int i = 0; i<answers.length; i++){
            if(answers[i]==(first[i%5]))
                correct[0]++;
            if(answers[i]==(second[i%8]))
                correct[1]++;
            if(answers[i]==(third[i%10]))
                correct[2]++;
        }
        for(int i=0; i<correct.length; i++){
            rank.add(new Student(correct[i], (i+1)));
        }
        Collections.sort(rank);
        if(rank.get(2).correct==rank.get(1).correct){
            length=2;
            if(rank.get(1).correct==rank.get(0).correct){
                length=3;
            }
        }

        int [] answer =new int[length];
        for(int i=0; i<answer.length; i++){
            answer[i]=rank.get(2-i).num;
        }
        Arrays.sort(answer);
        
        return answer;
    }
}
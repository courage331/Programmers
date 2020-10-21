package coding_test.highscore_kit.greedy.level3;

import java.util.*;
/*
 * 
 * 테스트명 : 단속 카메라
 * 
 * @ 김지민
 * 
 */
class Car implements Comparable<Car>{
    int depar;
    int dest;
    
    public Car(int depar, int dest){
        this.depar= depar;
        this.dest = dest;
    }
    
    public int compareTo(Car o){
        
        return depar-o.depar;
    }
    
    public String toString(){
        
        return depar+" "+dest;
    }
    
    public void setDepar(int depar){
        this.depar = depar;
        
    }
    
    public void setDest(int dest){
        this.dest = dest;
        
    }
    
    
}

class Camera {
    public int solution(int[][] routes) {
        int answer = 0;
        boolean chk = false;
        PriorityQueue<Car>car = new PriorityQueue();
        for(int i = 0; i<routes.length; i++){
            car.add(new Car(routes[i][0],routes[i][1]));
        }

        //System.out.println(car);

        ArrayList<Car>cameraRange = new ArrayList();
        
        int start =  car.element().depar;
        int end = car.element().dest;
        cameraRange.add(new Car(start,end));
        car.poll();
        //System.out.println(car);
        int idx=0;
        
       while(!car.isEmpty()){
           start = car.element().depar;
           end = car.element().dest;
           car.poll();
           
            if(start<cameraRange.get(idx).dest){
                cameraRange.get(idx).setDepar(start);
                
                if(end< cameraRange.get(idx).dest){
                    cameraRange.get(idx).setDest(end);
                }else{
                    
                }
            
            
            }else if(start>cameraRange.get(idx).dest){
                cameraRange.add(new Car(start, end));
                idx++;
            } 
       } 
    return cameraRange.size();
    }
}
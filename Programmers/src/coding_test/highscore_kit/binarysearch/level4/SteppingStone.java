package coding_test.highscore_kit.binarysearch.level4;

import java.util.*;

/*
 * 
 * 테스트명 : 징검다리
 * 
 * @ 김지민
 * 
 */


/*
문제에서 묻는 바를 다르게 생각할 수 있어야하는 것 같다. 
문제에서는 돌을 n개 만큼 없앴을 때 시작점, 끝점, 돌 사이에 거리 중 최솟값 중에 최댓값을 구하라고 한다.
묻는 바를 반대로 생각하여 n개의 돌을 없애서 돌 사이 거리의 최솟값이 x로 만들 수 있는가? 로 바꾼다면 이분탐색을 생각하볼 수 있다.
*/
class SteppingStone {
    public int solution(int distance, int[] rocks, int n) {
    	// 이분탐색은 오름차순으로 정렬되어있는 경우를 전제로한다.
        Arrays.sort(rocks);
        return binarySearch(distance, rocks, n);
    }
    
    int binarySearch(int distance, int[] rocks, int n){
        long ans = 0;
        long left = 1, right = distance, mid = 0;
    
        while(left <= right){
            int cnt = 0;
            int prev = 0;
            mid = (left + right) / 2;
            
            for(int i = 0 ; i < rocks.length ; ++i){
                if(rocks[i] - prev < mid){
                	// mid보다 작은 값이 존재한다는 뜻으로
                    // 해당 돌을 제거한다.
                    cnt++;
                } else {
           			// mid보다 크거나 같은 값이 존재하므로
                    // prev를 현재 돌로 초기화한다.
                    prev = rocks[i];
                }
            }
            
            // 마지막 돌과 도착점 사이의 거리도 확인한다.
            if(distance - prev < mid) cnt++;
            
            if(cnt <= n){
            	// 주어진 n 보다 작거나 같은 만큼 돌을 없애서
                // 최솟값 x를 만들 수 있다.
                ans = mid > ans ? mid : ans;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }
}

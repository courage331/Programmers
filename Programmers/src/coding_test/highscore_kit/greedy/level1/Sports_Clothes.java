package coding_test.highscore_kit.greedy.level1;

import java.util.*;

/*
 * 
 * 테스트명 : 체육복
 * 
 * @ 김지민
 * 
 */

public class Sports_Clothes {

	class Solution 
	{
	    public int solution(int n, int[] lost, int[] reserve) 
	    {
	        int answer = 0;
			int[] cnt = new int[n + 2];
			Arrays.fill(cnt, 1);
			cnt[0] = -1;
			cnt[n + 1] = -1;

			for (int i = 0; i<reserve.length; i++) {
				cnt[reserve[i]]++;
			}
			
			for (int i = 0; i<lost.length; i++) {
				cnt[lost[i]]--;
			}

			for (int i = 1; i <= n; i++) {
				if (cnt[i] == 0) {
					if (cnt[i - 1] == 2) {
						cnt[i]++;
						cnt[i - 1]--;
					} else if (cnt[i + 1] == 2) {
						cnt[i]++;
						cnt[i + 1]--;
					}else {
						answer--;
					}
				}
			}
	        return (n+answer);
	    }
	}
}

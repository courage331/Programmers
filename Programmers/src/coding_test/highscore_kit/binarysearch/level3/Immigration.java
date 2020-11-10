package coding_test.highscore_kit.binarysearch.level3;

import java.util.*;
/*
 * 
 * 테스트명 : 입국심사
 * 
 * @ 김지민
 * 
 */

public class Immigration {

	public long solution(int n, int[] times) {
		Arrays.sort(times);
		return binarySearch(times, n, times[times.length - 1]);
	}

	long binarySearch(int[] times, int n, long max) {
		long left = 1, right = max * n; //left 최저시간, right는 최대시간
		long mid = 0; //평균시간
		long ans = Long.MAX_VALUE; //구해야하는 시간(최소시간)

		while (left <= right) {
			mid = (left + right) / 2;
			System.out.println(left+" "+right+" "+mid+" "+ans);
			
			if (isPassed(times, n, mid)) {
				ans = ans > mid ? mid : ans;
				right = mid - 1;
			} else { 
				left = mid + 1;
			}
		}
		return ans;
	}

	boolean isPassed(int[] times, int n, long mid) {
		long amount = 0; //검사관이 검사한 사람의 수

		for (int i = 0; i < times.length; ++i) {
			amount += mid / times[i]; //각 검사관 마다 검사한 인원체크
		}
		//amount >=n은  검사한 인원이 검사해야한 사람수보다 많은 경우 
		if (amount >= n)
			return true;
		//amount < n 검사한 인원이 검사한 사람수보다 적은 경우 -> 실패
		else 
			return false;
	}
}

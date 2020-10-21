package coding_test.highscore_kit.greedy.level2;

import java.util.*;

/*
 * 
 * 테스트명 : 체육복
 * 
 * @ 김지민
 * 
 */
public class Make_BigNumber {
	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int idx = -1; // 가장 최근 고른 idx
		char mch = '0';

		// 차례로 탐색
		for (int i = 0; i < number.length() - k; i++) {
			mch = '0';
			// 범위 내에서 가장 큰 숫자
			for (int j = idx + 1; j <= i + k; j++) {
				// 더 큰 숫자 있으면
				if (mch < number.charAt(j)) {
					mch = number.charAt(j);
					idx = j;
				}
			}
			// 추가
			answer.append(mch);
		}
		return answer.toString();
	}
}

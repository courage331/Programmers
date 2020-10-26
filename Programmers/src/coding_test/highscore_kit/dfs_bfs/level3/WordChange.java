package coding_test.highscore_kit.dfs_bfs.level3;

import java.util.*;
/*
 * 
 * 테스트명 : 단어 변환
 * 
 * @ 김지민
 */

public class WordChange {

	static boolean[] checker;
	static int answer;

	public int solution(String begin, String target, String[] words) {
		answer = words.length + 1;
		checker = new boolean[words.length];
		dfs(begin, target, words, 0);

		return answer;
	}

	public static void dfs(String begin, String target, String[] words, int num) {

		if (begin.equals(target)) {
			if (answer == 0) {
				answer = num;
			} else {
				answer = Math.min(answer, num);
			}
			return;
		}
		int cnt = 0;
		for (int i = 0; i < words.length; i++) {
			cnt = 0;
			if (checker[i]) {
				// 이미 체크한 단어
				continue;
			}

			for (int j = 0; j < words[i].length(); j++) {
				if (begin.charAt(j) != words[i].charAt(j)) {
					cnt++;
					if (cnt >= 2) {
						break;
					}
				}
			}

			if (cnt == 1) {
				checker[i] = true;
				dfs(words[i], target, words, num + 1);
				checker[i] = false;
			}
		}

		if (answer == words.length + 1 || answer == 0) {
			answer = 0;
			return;
		} else {
			return;
		}

	}
}

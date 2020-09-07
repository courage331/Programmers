package coding_test.highscore_kit.sort.level1;

import java.util.*;

/*
 * 
 * 테스트명 : K번째수
 * 
 * @ 김지민
 * 
 */

public class Kth_Number {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int[] temp = new int[commands[i][1] - commands[i][0] + 1];
			int cnt = 0;
			for (int j = commands[i][0]; j <= commands[i][1]; j++) {
				temp[cnt] = array[j - 1];
				cnt++;
			}
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2] - 1];
		}

		return answer;
	}
}

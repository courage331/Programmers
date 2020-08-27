package coding_test.highscore_kit.hash.level1;

/*
 * 
 * 테스트명 : 완주하지 못한 선수
 * 
 * @ 김지민
 * 
 */
import java.util.*;

public class UnsucessfulPlayer {

	class Solution {
		public String solution(String[] participant, String[] completion) {
			String answer = ""; // 결과값
			HashMap<String, Integer> player = new HashMap(); // <참가자이름, 이름 수(중복된값 포함)>
			for (int i = 0; i < participant.length; i++) {
				int count = player.containsKey(participant[i]) ? player.get(participant[i]) : 0;
				//중복된 이름이 있으면 value값을 증가시켜서 넣어준다.
				player.put(participant[i], count + 1);
			}

			for (int i = 0; i < completion.length; i++) { // 완수한 사람들의 integer를 감소시킨다.
				int count = player.get(completion[i]);
				player.put(completion[i], count - 1);
			}

			Iterator<String> keys = player.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				if (player.get(key) == 1) {
					answer = key;
					break;
				}
			}

			return answer;
		}
	}
}

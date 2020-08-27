package coding_test.highscore_kit.hash.level2;
/*
 * 
 * 테스트명 : 전화번호 목록
 * 
 * @ 김지민
 * 
 */
import java.util.*;

public class PhonenumberList {

	class Solution {
		public boolean solution(String[] phone_book) {
			boolean answer = true;
			HashMap<String, Integer> number = new HashMap();
			Arrays.sort(phone_book, Collections.reverseOrder());
			for (int i = 0; i < phone_book.length; i++) {
				number.put(phone_book[i], 0);
				int count = 0;
				for (Map.Entry<String, Integer> entry : number.entrySet()) {
					if (entry.getKey().contains(phone_book[i])) {
						count = number.get(phone_book[i]) + 1;
						number.put(phone_book[i], count);
					}
				}
				if (count >= 2) {
					answer = false;
					break;
				}
			} // 큰 for문

			if (phone_book.length == 1)
				answer = false;

			return answer;
		}
	}
}

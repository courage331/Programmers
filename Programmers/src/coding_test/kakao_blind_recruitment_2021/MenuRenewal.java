package coding_test.kakao_blind_recruitment_2021;

import java.util.*;

/*
 *
 * 테스트명 : 메뉴 리뉴얼
 *
 * @ 김지민
 *
 */

public class MenuRenewal {

    static List<String> arr = new ArrayList();

    public String[] solution(String[] orders, int[] course) {

        Map<String, Integer> cookMap = new HashMap<>();
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                String[] order = orders[j].split("");
                Arrays.sort(order);
                int[] chk = new int[order.length];
                makeCourse(order, chk, course[i], "", 0);
            }
        }
        for (int k = 0; k < arr.size(); k++) {
            String temp = arr.get(k);
            int count = cookMap.containsKey(temp) ? cookMap.get(temp) + 1 : 1;
            cookMap.put(temp, count);
        }
        // System.out.println(arr.toString());
        // System.out.println(cookMap.toString());
        List<String> result = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            int max = -1;
            List<String> temp = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : cookMap.entrySet()) {
                //System.out.println("key : " + entry.getKey() + "length"+entry.getKey().length() +", value : " + entry.getValue());
                if (entry.getKey().length() == course[i] && entry.getValue() >= 2) {
                    if (max < entry.getValue()) {
                        max = entry.getValue();
                        temp.clear();
                        temp.add(entry.getKey());
                    } else if (max == entry.getValue()) {
                        temp.add(entry.getKey());
                    } else {

                    }
                }
            }
            for (int k = 0; k < temp.size(); k++) {
                result.add(temp.get(k));
            }

        }
        Collections.sort(result);

        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }

    public void makeCourse(String[] order, int[] chk, int course, String word, int idx) {

        if (course > order.length) {
            return;
        }

        if (word.length() == course) {
            arr.add(word);
            return;
        }


        for (int i = idx; i < order.length; i++) {
            if (chk[idx] != 0) {
                continue;
            }
            word += order[i];
            chk[idx] = 1;
            makeCourse(order, chk, course, word, i + 1);
            chk[idx] = 0;
            word = word.substring(0, word.length() - 1);
        }

    }
}


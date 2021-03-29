package coding_test.practice.level2;

/*
 *
 * 테스트명 : 숫자의 표현
 *
 * @ 김지민
 *
 */

public class NumberExpression {
    public int solution(int n) {
        int answer = 0;
        //짝수 2n+1  4n+2  6n+3 ->   k x n + k/2

        //홀수 k x n 의 형태로 표현 가능

        //n의 약수 구하기
        for (int i = 1; i < n; i++) {
            int temp = n / i;
            int rest = n % i;
            //홀수
            if (i % 2 == 1) {
                if (rest == 0) {
                    if (temp > i / 2) {
                        // System.out.println(i);
                        answer++;
                    }

                } else {
                    //해당x
                }
                //찍수
            } else {
                if (temp * i + i / 2 == n) {
                    if (temp > (i / 2) - 1) {
                        // System.out.println(i);
                        answer++;
                    }

                }
            }

        }

        return answer;
    }
}

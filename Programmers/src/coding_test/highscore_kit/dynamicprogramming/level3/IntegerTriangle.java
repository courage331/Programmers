package coding_test.highscore_kit.dynamicprogramming.level3;
/*
 * 
 * 테스트명 : 정수 삼각형
 * 
 * @ 김지민
 * 
 
 * 
 */
public class IntegerTriangle {

	public int solution(int[][] triangle) {
		int answer = 0; // 결과
		int[][] dp = new int[triangle.length][];// 최댓값들을 저장할 배열

		for (int j = 1; j <= triangle.length; j++) {// 가변 배열 내의 배열 설정
			dp[j - 1] = new int[j];
		}

		// 초기값

		dp[0][0] = triangle[0][0];

		dp[1][0] = dp[0][0] + triangle[1][0];

		dp[1][1] = dp[0][0] + triangle[1][1];

		// 값을 저장하면서 구해나감

		for (int i = 2; i < triangle.length; i++) {

			dp[i][0] = Math.max(dp[i - 1][0] + triangle[i][0], 0);

			dp[i][i] = Math.max(dp[i - 1][i - 1] + triangle[i][i], 0);

			for (int j = 1; j < i; j++) {

				dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);

			}

		}

		// 최댓값 구하기

		for (int i = 0; i < dp.length; i++) {
			answer = Math.max(dp[triangle.length - 1][i], answer);
		}

		return answer;
	}
}

package coding_test.highscore_kit.graph.level3;

/*
 * 
 * 테스트명 : 순위
 * 
 * @ 김지민
 * 
 */

public class Ranking {
	public int solution(int n, int[][] results) {
        int answer = 0;
        int maxValue= 1000000;
        //플루이드 워셜 알고리즘 사용
        int[][] FW = new int[n+1][n+1];
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j<=n; j++) {
                FW[i][j] = maxValue;
            }
        }
        
        for(int[] e : results) {
            FW[e[0]][e[1]] = 1;
        }
        //거치는 노드
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <=n; i++) {            //시작 노드
                for(int j = 1; j <= n; j++) {
                    if(FW[i][j] > FW[i][k]+FW[k][j]) {    //종료(도착)노드
                        FW[i][j] = FW[i][k] + FW[k][j];
                    }
                }
            }
        }
        
        
        for(int i = 1; i <= n; i++){
            boolean flag = true;
            for(int j = 1; j <=n; j++) {
                if(i == j) continue;
                if(FW[i][j] == maxValue && FW[j][i] == maxValue) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}

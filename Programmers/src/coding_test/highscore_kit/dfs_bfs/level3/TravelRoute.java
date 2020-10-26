package coding_test.highscore_kit.dfs_bfs.level3;
/*
 *  테스트명 : 네트워크
 * 
 * @ 김지민
 * 
 * 
 * 
 * */

public class TravelRoute {
	public int solution(int n, int[][] computers) {
		int answer = 0;

		boolean[] visited = new boolean[computers.length];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < computers.length; i++) {
			if (visited[i] == false) {
				answer++;
				dfs(i, visited, computers);
			}
		}

		return answer;
	}

	public static void dfs(int node, boolean[] visited, int[][] computers) {
		visited[node] = true;

		for (int i = 0; i < computers.length; i++) {
			if (visited[i] == false && computers[node][i] == 1) {
				dfs(i, visited, computers);
			}
		}

	}
}

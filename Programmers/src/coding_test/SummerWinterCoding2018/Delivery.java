package coding_test.SummerWinterCoding2018;

import java.util.*;

/*
 * 
 * 테스트명 : 배달
 * 
 * @ 김지민
 * 
 */

class Graph {
	int n;
	int maps[][];

	public Graph(int n) {
		this.n = n;
		maps = new int[n + 1][n + 1];
	}

	public void input(int i, int j, int w) {
		if (maps[i][j] != 0) {
			maps[i][j] = Math.min(maps[i][j], w);
			maps[j][i] = maps[i][j];
		} else {
			maps[i][j] = w;
			maps[j][i] = w;
		}
	}

	public int dijkstra(int v, int K) {
		int distance[] = new int[n + 1];
		boolean[] check = new boolean[n + 1];
		int answer = 0;

		for (int i = 1; i < n + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		distance[v] = 0;
		check[v] = true;

		for (int i = 1; i < n + 1; i++) {
			if (!check[i] && maps[v][i] != 0) {
				distance[i] = maps[v][i];
			}
		}

		for (int a = 0; a < n - 1; a++) {
			// 원래는 모든 노드가 true될때까지 인데
			// 노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
			// 원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
			int min = Integer.MAX_VALUE;
			int min_index = -1;

			// 최소값 찾기
			for (int i = 1; i < n + 1; i++) {
				if (!check[i] && distance[i] != Integer.MAX_VALUE) {
					if (distance[i] < min) {
						min = distance[i];
						min_index = i;
					}
				}
			}

			check[min_index] = true;
			for (int i = 1; i < n + 1; i++) {
				if (!check[i] && maps[min_index][i] != 0) {
					if (distance[i] > distance[min_index] + maps[min_index][i]) {
						distance[i] = distance[min_index] + maps[min_index][i];
					}
				}
			}

		}

		// 결과값 출력
		for (int i = 1; i < n + 1; i++) {
			System.out.print(distance[i] + " ");
			if (distance[i] <= K) {
				answer++;
			}
		}
		System.out.println("");
		return answer;
	}
}

class Delivery {
	public int solution(int N, int[][] road, int K) {
		Graph g = new Graph(N);
		for (int i = 0; i < road.length; i++) {
			g.input(road[i][0], road[i][1], road[i][2]);
		}

		return g.dijkstra(1, K);
	}
}

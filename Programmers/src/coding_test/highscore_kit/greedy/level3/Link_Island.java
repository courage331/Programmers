package coding_test.highscore_kit.greedy.level3;

import java.util.*;

/*
 * 
 * 테스트명 : 섬 연결하기
 * 
 * @ 김지민
 * 
 */

class Link_Island {
    class Edge implements Comparable<Edge> {
        int from, to, cost;
        
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    
    static int[] parent;
    static PriorityQueue<Edge> adj;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        adj = new PriorityQueue<>();
        //크루스칼 알고리즘 : 가장작은 연결값 가진 다리순으로 정렬함(오름차순)
        
        for(int i = 0 ; i < costs.length ; ++i){
            Edge edge = new Edge(costs[i][0], costs[i][1], costs[i][2]);
            adj.offer(edge);
        }
        
        for(int i = 0 ; i < n ; ++i) {
        	parent[i] = i;
        }
       
        while(!adj.isEmpty()) {
        	Edge edge = adj.poll();
        	//조상 edge가 같은 것은 continue
        	//조상 edge가 다른것들은 연결시켜준다.
            if(find(edge.from) == find(edge.to)) {
            	continue;
            }
            else {
                union(edge.from, edge.to);
                answer += edge.cost;    
            }
        }
        
        return answer;
    }
    //조상 edge일때 본인값으로 return
    //union-find 알고리즘
    public int find(int n){
        if(parent[n] == n) {
        	return n;
        }
        
        return parent[n] = find(parent[n]);
    }
    
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        //조상이 서로 다르다면 큰번호를 작은 번호에 연결한다.
       if(rootA != rootB) {
    	   parent[rootB] = rootA;
       }
    }
}

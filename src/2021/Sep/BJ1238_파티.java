package Sep;
/*******************************************************************************
 * BaekJoon 1238 번 
 * 
 * 예시 input 
 * 4 8 2
 * 1 2 4
 * 1 3 2
 * 1 4 7
 * 2 1 1
 * 2 3 5
 * 3 1 2
 * 3 4 4
 * 4 2 3
 * 결과 값 
 * 10
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1238_파티 {
	static int N, M, X;
	static int[][] from;
	static ArrayList<ArrayList<Node>> graph;
	
	static class Node implements Comparable<Node>{
		int des;
		int w;
		
		public Node(int des, int w) {
			super();
			this.des = des;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 학생 수 
		M = Integer.parseInt(st.nextToken()); // 도로 연결 수 
		X = Integer.parseInt(st.nextToken()); // 파티를 하는 마을 
		
		graph = new ArrayList<ArrayList<Node>>(); // 연결된 마을들을 저장할 graph 
		
		from = new int[N+1][N+1]; // 최단 거리를 갱신할 배열 
		
		for (int i = 0; i < from.length; i++) {
			Arrays.fill(from[i], Integer.MAX_VALUE); // max 값으로 초기화 
		}
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int x, y, z;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(new Node(y, z)); // 연결 정보 입력 
			
		}
		
		for (int i = 1; i <= N; i++) {
			Dijkstra(i);
		}
		
		int max = 0;
		for (int i = 1; i <=N; i++) { 
			max = Math.max(max, from[i][X] + from[X][i]); // 왕복 거리 기준 최댓값 갱신 
		}
		System.out.println(max);
	}
	
	static void Dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0)); // 시작위치의 거리 0으로 초기화 
		
		boolean[] visited = new boolean[N+1];
		
		from[start][start] = 0; // 본인 시작은 0 
		
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll(); // 가장 짧은 거리 추출 
			visited[temp.des] = true; // 방문 처리 
			for (Node n : graph.get(temp.des)) { // 가장 짧은 마을과 연결된 다른 마을 순회 
				if(visited[n.des]) continue;
				
				if(from[start][n.des] > from[start][temp.des] + n.w) {
					int dist = from[start][temp.des] + n.w;
					from[start][n.des] = dist;
					pq.add(new Node(n.des, dist));
				}
			}
		}
		
		
	}

}

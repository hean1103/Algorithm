package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1389_케빈베이컨 {
	final static int INF = 9999999;
	static class Node implements Comparable<Node>{
		int v;
		int w;
		
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) { 
			if(o.w == this.w) return this.v - o.v; // 가중치가 같다면 작은 번호 순 
			return this.w-o.w; // 가중치가 큰 순 으로 정렬 
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		int[][] dist = new int[N+1][N+1]; // 거리 정보 
		
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(dist[i], INF);
		} // 최댓값으로 초기화 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j) dist[i][j] = 0;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
			dist[x][y] = 1;
			dist[y][x] = 1;
		} // graph 연결 
		
		floyd(graph, N, dist);
		
		
	}
	
	static void floyd(ArrayList<ArrayList<Integer>> graph, int N, int[][] dist) {
		
		for (int i = 1; i < N+1; i++) { // 꼭짓점 
			for (int j = 1; j < N+1; j++) { // 출발점 
				for (int k = 1; k < N+1; k++) { // 도착점 
					if(dist[j][i] + dist[i][k] < dist[j][k]) {
						dist[j][k] = dist[j][i] + dist[i][k];
					}
				}
			}
		}
		findMin(dist, N);
	}
	
	static void findMin(int[][] dist, int N ) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(); // 제일 작은 케빈베이컨을 저장할 pq
		
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += dist[i][j]; // 각 정점에서 모든 정점까지의 케빈베이컨 저장 
			}
			pq.add(new Node(i, sum)); // pq에 삽입 
		}
		
		System.out.println(pq.peek().v); // 제일 앞쪽의 node번호 프린트 
	}

}

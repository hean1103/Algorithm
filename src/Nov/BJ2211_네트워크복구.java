package Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2211_네트워크복구 {
	static int[][] cost;
	static ArrayList<ArrayList<Integer>> node;
	static ArrayList<int[]> ans;
	static class Node implements Comparable<Node> {
		int edge, dist;

		public Node(int edge, int dist) {
			super();
			this.edge = edge;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		node = new ArrayList<ArrayList<Integer>>();
		cost = new int[N+1][N+1];
		ans = new ArrayList<int[]>();
		for (int i = 0; i <= N; i++) {
			node.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x, y, c;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			node.get(x).add(y);
			node.get(y).add(x);
			cost[x][y] = cost[y][x] = c;
		}
		Dijkstra(1, N);
		
		System.out.println(ans.size());
		for (int[] answer : ans) {
			System.out.println(answer[0] + " " + answer[1]);
		}
	}
	
	static void Dijkstra(int start, int N) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int[] dist = new int[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			for (int next : node.get(cur.edge)) {
				int d = cost[cur.edge][next] + cur.dist;
				if(dist[next] > d) {
					pq.offer(new Node(next, d));
					dist[next] = d;
				}
			}
		}
		BFS(1, N, dist);

	}
	
	static void BFS(int start, int N, int[] dist) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {start, 0});
		
	
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for (int next : node.get(cur[0])) {
				if(!visited[next] && dist[next] == cost[cur[0]][next] + cur[1]) {
					ans.add(new int[] {cur[0], next});
					visited[next] = true;
					que.offer(new int[] {next, cost[cur[0]][next] + cur[1]});
				}
			}
		}

	}
}

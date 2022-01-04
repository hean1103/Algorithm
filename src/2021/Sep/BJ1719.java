package Sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1719 {
	
	static int[] dist;
	static int n;
	static ArrayList<ArrayList<Edge>> arr;
	static StringBuilder sb = new StringBuilder();
	
	static class Edge implements Comparable<Edge> {
		int des;
		int w;
		
		public Edge(int des, int w) {
			this.des = des;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {

			return this.w-o.w;
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		
		
		arr = new ArrayList<ArrayList<Edge>>();
		
		
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<Edge>());
		}
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(), y = sc.nextInt(), d = sc.nextInt();
			
			arr.get(x).add(new Edge(y, d));
			arr.get(y).add(new Edge(x, d));
		}
		
		for (int i = 1; i <= n ; i++) {
			Dijkstra(i);
		}
		
		System.out.println(sb);
		sc.close();
	}
	
	static void Dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0)); // 시작 정점 거리 0으로 초기화 
		
		boolean[] visited = new boolean[n+1];
		int[] path = new int[n+1];
		
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE); // 거리
		
		dist[start] = 0;
		path[start] = start;
		
		while(!pq.isEmpty()) {
			
			Edge e = pq.poll();
			
			int now = e.des;
			
			if(visited[now]) continue;
			
			visited[now] = true;
			
			for (Edge edge : arr.get(now)) {
				int cost = dist[now] + edge.w;
				
				if(cost < dist[edge.des]) {
					dist[edge.des] = cost;
					path[edge.des] = now;
					pq.add(new Edge(edge.des, cost));
				}
			}
		}
		
		setPath(start, path);
		
	}
	
	// path [1, 1, 1, 2, 3 ]
	static void setPath(int start, int[] path) {
		for (int i = 1; i <= n; i++) {
			if(start == i) {
				sb.append("- ");
				continue;
			}
			
			if(path[i] == start) {
				sb.append(i+" ");
				continue;
			} 
			int index = i;
			while(path[index] != start) {
				index = path[index];
			}
			sb.append(index+" ");
		}
		sb.append("\n");
	}

}

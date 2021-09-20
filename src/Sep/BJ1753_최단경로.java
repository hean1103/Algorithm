package Sep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753_최단경로 {
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
			
			return this.w - o.w;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int V, E, S;
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<Node>());
		}
		st = new StringTokenizer(bf.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
		}
		
		int[] d = Dijkstra(S, V, graph);
		
		for (int i = 1; i <= V; i++) {
			if(d[i] == Integer.MAX_VALUE) bw.write("INF\n");
			else {
				bw.write(String.valueOf(d[i]) + "\n");
			}
		}
		bw.flush();
	}
	
	static int[] Dijkstra(int start, int V, ArrayList<ArrayList<Node>> graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[V+1];
		boolean[] v = new boolean[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		pq.add(new Node(start, 0)); // 시작점 거리를 0으로 값 넣기 
		
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			v[cur.v] = true;
			
			for (Node n : graph.get(cur.v)) {
				if(!v[n.v]) {
					int d = dist[cur.v] + n.w;
					if(dist[n.v] > d) {
						dist[n.v] = d;
						pq.add(new Node(n.v, d));
					}
				}
			}
		}
		
	
		return dist;
		
		
	}

}

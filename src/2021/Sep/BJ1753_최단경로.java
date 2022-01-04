package Sep;
/*******************************************************************************
 * BaekJoon 1753 번 
 * 
 * 예시 input 
 * 5 6
 * 1
 * 5 1 1
 * 1 2 2
 * 1 3 3
 * 2 3 4
 * 2 4 5
 * 3 4 6
 * 결과 값 
 * 0
 * 2
 * 3
 * 7
 * INF
 */
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
		public int compareTo(Node o) { //가중치 내림차순 
			
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
			graph.add(new ArrayList<Node>()); // 초기화 
		}
		st = new StringTokenizer(bf.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w)); // 노드 연결 
		}
		
		int[] d = Dijkstra(S, V, graph); // 다익스트라 실행  
		
		for (int i = 1; i <= V; i++) {
			if(d[i] == Integer.MAX_VALUE) bw.write("INF\n"); // 최대값이 저장되어 있으면 연결 안됨을 표시 
			else {
				bw.write(String.valueOf(d[i]) + "\n");
			}
		}
		bw.flush();
	}
	
	static int[] Dijkstra(int start, int V, ArrayList<ArrayList<Node>> graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>(); // 최단거리를 구하기 위한 Priority Queue
		int[] dist = new int[V+1]; // 거리 갱신 배열 
		boolean[] v = new boolean[V+1]; // 방문 체크 
		Arrays.fill(dist, Integer.MAX_VALUE); // 모든 거리를 최댓값으로 초기화 
		
		pq.add(new Node(start, 0)); // 시작점 거리를 0으로 값 넣기 
		
		dist[start] = 0; // 시작 위치의 거리는 0 (자기 자신으로 가는 가중치)
		
		while(!pq.isEmpty()) { // Queue가 빌 때까지 
			Node cur = pq.poll(); // Queue에 들어간 거리 중 가장 최단거리 노드 추출 
			
			v[cur.v] = true; // 방문 처리 
			
			for (Node n : graph.get(cur.v)) { // 연결된 노드들 확인 
				if(!v[n.v]) { // 방문 하지 않은 노드라면 
					int d = dist[cur.v] + n.w; //현재 노드의 최단거리 + 연결 노드까지의 가중치 
					if(dist[n.v] > d) { // 현재 연결 노드의 거리보다현재 노드의 최단거리 + 연결 노드까지의 가중치 가 더 짧다면 
						dist[n.v] = d; // dist 거리 갱신 
						pq.add(new Node(n.v, d)); // queue에 넣어주기 
					}
				}
			}
		}
		
	
		return dist;
		
		
	}

}

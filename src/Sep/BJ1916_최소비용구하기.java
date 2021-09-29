package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916_최소비용구하기 {
	static ArrayList<ArrayList<Info>> city;
	static class Info implements Comparable<Info>{
		int city;
		int cost;
		
		public Info(int city, int cost) {
			super();
			this.city = city;
			this.cost = cost;
		}
		
		public int compareTo(Info o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M;
		
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		
		city = new ArrayList<ArrayList<Info>>();
		for (int i = 0; i <= N; i++) {
			city.add(new ArrayList<Info>());
			
		}// 리스트 초기화 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int from  = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			city.get(from).add(new Info(to, cost));
		}
		
		int start, end;
		st = new StringTokenizer(bf.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int ans = Dijkstra(start, end, N);
		System.out.println(ans);
	}
	
	static int Dijkstra(int start, int end , int N) {
		PriorityQueue<Info> pq = new PriorityQueue<>(); // 최솟값을 위한 우선순위 큐 선언 
		int[] dist = new int[N+1]; // 거리 갱신을 위한 배열 
		
		Arrays.fill(dist, Integer.MAX_VALUE); // dist배열을 최댓값으로 초기화 
		dist[start] = 0; // 시작점은 거리를 0으로 설정 
		pq.add(new Info(start, 0));
		
		while(!pq.isEmpty()) {
			Info now = pq.poll(); // 제일 작은 값을 찾아서 poll 
			if(now.city == end) break;
			for (Info c : city.get(now.city)) { // now의 도시와 연결된 다른 도시들을 돌며 
				if(dist[c.city] > dist[now.city] + c.cost) { // 값 비교 
					dist[c.city] = dist[now.city] + c.cost; // 더 작은 값으로 갱신 
					pq.add(new Info(c.city , dist[c.city])); // pq에 추가 
				}
			}
		}
		
		return dist[end];
	}

}

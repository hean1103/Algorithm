package Oct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ14938_서강그라운드 {
	static int[][] map;
	static int ans ;
	static int[] items;
	
	static class Node implements Comparable<Node>{
		int idx;
		int dist;
		
		public Node(int idx, int dist) {
			super();
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			
			return this.dist - o.dist;
		}
		
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n, m, r; // n = 지역의 갯수, m = 수색 거리 , r = 길의 갯수 
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		items = new int[n+1]; // 아이템 갯수 
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		map = new int[n+1][n+1];
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(bf.readLine());
			int from, to, dist;
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			
			map[from][to] = map[to][from] =dist;
			
		}
		
		ans = Integer.MIN_VALUE;
		
		for (int i = 1; i <= n; i++) {
			dijk(i, n, m);
		}
		
		bw.write(ans + "\n");
		bw.flush();
	}
	
	static void dijk(int start, int n, int m) {
		PriorityQueue<Node> pri = new PriorityQueue<Node>();
		pri.offer(new Node (start, 0)); // 최소 거리 넣기 
		
		int[] dijks = new int[n+1];
		Arrays.fill(dijks, Integer.MAX_VALUE);
		dijks[start] = 0;
		while(!pri.isEmpty()) {
			Node cur = pri.poll();
			
			for (int i = 1; i <= n; i++) {
				
				if(map[cur.idx][i] != 0 && dijks[i] > cur.dist + map[cur.idx][i]) {
					int dist = cur.dist + map[cur.idx][i];
					dijks[i] = dist;
					pri.offer(new Node(i, dist));
				}
			}
			
		}
		
		
		cntItem(dijks, m, n);
		
	}
	
	static void cntItem(int[] dijks, int m, int n) {
		int ret = 0;
		for (int i = 1; i <= n; i++) {
			
			if(dijks[i] <= m) {
				ret += items[i];
			}
		}
		ans = Integer.max(ans, ret);
	}

}

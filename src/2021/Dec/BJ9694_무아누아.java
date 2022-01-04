package Dec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ9694_무아누아 {
	static class Pos implements Comparable<Pos>{
		int pos, dist;
		
		public Pos(int pos, int dist) {
			this.pos = pos;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pos o) {
			
			return o.dist - this.dist;
		}

		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= T; i++) {
			bw.write("Case #" + i + ": ");
			
			st = new StringTokenizer(bf.readLine());
			int n, m;
			n = Integer.parseInt(st.nextToken()); // 관계의 수 
			m = Integer.parseInt(st.nextToken()); // 정치인의 수 
			
			ArrayList<ArrayList<Pos>> graph = new ArrayList<ArrayList<Pos>>();
			
			for (int j = 0; j < m; j++) {
				graph.add(new ArrayList<Pos>());
			}
			
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), close = Integer.parseInt(st.nextToken());
				graph.get(from).add(new Pos(to, close));
				graph.get(to).add(new Pos(from, close));
			}
			
			
			int[] dijk = new int[m];
			int[] visited = new int[m];
			PriorityQueue<Pos> pq = new PriorityQueue<Pos>();
			Arrays.fill(dijk, Integer.MAX_VALUE);
			
			dijk[0] = 0;
			pq.add(new Pos(0, 0));
			
			while(!pq.isEmpty()) {
				Pos cur = pq.poll();
				
				for (Pos pos : graph.get(cur.pos)) {
					int total = cur.dist + pos.dist;
					if(dijk[pos.pos] > total) {
						dijk[pos.pos] = total;
						visited[pos.pos] = cur.pos;
						pq.add(new Pos(pos.pos, total));
					}
				}
			}
			
			if(dijk[m-1] == Integer.MAX_VALUE) {
				bw.write(-1 + "\n");
			} else {
				bw.write(0 + " ");
				Stack<Integer> stack = new Stack<Integer>();
				
				int pos = m-1;
				while(pos != 0) {
					stack.push(pos);
					pos = visited[pos];
				}
				
				while(!stack.isEmpty()) {
					bw.write(stack.pop() + " ");
				}
				bw.write("\n");
			}
			

			
			bw.flush();
			
			
		}

	}

}

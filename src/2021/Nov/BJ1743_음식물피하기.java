package Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1743_음식물피하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N, M, K; 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		boolean[][] room = new boolean[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1];
		ArrayList<int[]> pos = new ArrayList<int[]>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int x, y;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			room[x][y] = true;
			pos.add(new int[] {x, y});
		}
		
		int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
		int ans = Integer.MIN_VALUE;
		for (int[] p : pos) {
			if(!visited[p[0]][p[1]]) {
				int size = 1; 
				Queue<int[]> que = new LinkedList<int[]>();
				que.offer(p);
				visited[p[0]][p[1]] = true;
				
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					
					for (int i = 0; i < 4; i++) {
						int x = cur[0] + dx[i];
						int y = cur[1] + dy[i];
						
						if(x > 0 && x <= N && y > 0 && y <= M && !visited[x][y] && room[x][y]) {
							que.offer(new int[] {x, y});
							visited[x][y] = true;
							size++;
							
						}
					}
				}
				ans = Math.max(ans, size);
			}
		}
		System.out.println(ans);

	}

}

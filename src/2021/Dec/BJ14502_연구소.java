package Dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502_연구소 {
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] lab = new int[n][m];
		ArrayList<Pos> empty = new ArrayList<Pos>();
		ArrayList<Pos> virus = new ArrayList<Pos>();
		int safe = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 0) {
					empty.add(new Pos(i, j));
					safe++;
				}
				if(temp == 2) virus.add(new Pos(i, j));
				lab[i][j] = temp;
			}
		} // input end 

		int size = empty.size(), max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				for (int l = j+1; l < size; l++) {
					lab[empty.get(i).x][empty.get(i).y] = 1;
					lab[empty.get(j).x][empty.get(j).y] = 1;
					lab[empty.get(l).x][empty.get(l).y] = 1;
					int cnt = 0;
					boolean[][] visited = new boolean[n][m];
					for(Pos v : virus) {
						cnt += spread(v, visited, lab);
					}

					max = Math.max(max, safe-cnt);
					lab[empty.get(i).x][empty.get(i).y] = 0;
					lab[empty.get(j).x][empty.get(j).y] = 0;
					lab[empty.get(l).x][empty.get(l).y] = 0;
				}
			}
		}
		System.out.println(max-3);
	}
	
	
	
	static int spread(Pos start, boolean[][] visited, int[][] lab) {
		Queue<Pos> que = new LinkedList<Pos>();
		que.add(start);
		visited[start.x][start.y] = true;
		int cnt  = 0;
		while(!que.isEmpty()) {
			Pos cur = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				if(x >= 0 && x < n && y >= 0 && y < m  && lab[x][y] == 0 && !visited[x][y]) {
					visited[x][y] = true;
					que.add(new Pos(x, y));
					cnt++;
				}
			}
		}
		return cnt;
	}

}

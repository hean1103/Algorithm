package Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ21610_마법사상어와비바라기 {
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n, m ; 
	static int[][] water;
	static Queue<Pos> clouds;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		water = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				water[i][j] = Integer.parseInt(st.nextToken());
			}
		} // water input 
		
		
		clouds = new LinkedList<Pos>();
		
		clouds.offer(new Pos(n, 1));
		clouds.offer(new Pos(n, 2));
		clouds.offer(new Pos(n-1, 1));
		clouds.offer(new Pos(n-1, 2));
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			moveCloud(d, s);
			
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n; j++) {
				sum += water[i][j];
			}
		}
		
		System.out.println(sum);
		

	}
	
	static void moveCloud(int d, int s) {
		int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
		int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
		
		Queue<Pos> newCloud = new LinkedList<Pos>();
		boolean[][] isCloud = new boolean[n+1][n+1];
		int x, y;
		while (!clouds.isEmpty()) {
			Pos c = clouds.poll();
			
			x = calc(c.x +(dx[d] * s));
			y = calc(c.y + (dy[d] * s));

			water[x][y] += 1;
			isCloud[x][y] = true;
			newCloud.offer(new Pos(x, y));
			
		}
		
		magic(newCloud);
		makeCloud(isCloud);
		
		
	}
	static void makeCloud(boolean[][] isCloud) {
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n; j++) {
				if(water[i][j] >= 2 && !isCloud[i][j]) {
					water[i][j] -= 2;
					clouds.offer(new Pos(i, j));
				}
			}
		}
	}
	static void magic(Queue<Pos> newCloud) {
		int[] dx = {-1, -1, 1, 1};
		int[] dy = {-1, 1, 1, -1};
		while(!newCloud.isEmpty()) {
			Pos c = newCloud.poll();
			int cnt = 0; 
			for (int i = 0; i < 4; i++) {
				int x = c.x + dx[i];
				int y = c.y + dy[i];
				
				if(x > 0 && x <= n && y <= n && y > 0 && water[x][y] > 0) cnt++;
				
			}
			
			water[c.x][c.y] += cnt;
		}
	}
	
	static int calc(int x) {
		if(x > n) return x%n == 0 ? n : x%n;
		else if(x > 0) return x;
		else {
			while(x < 1) {
				x = n+x;
			}
			return x;
		}
	}

}

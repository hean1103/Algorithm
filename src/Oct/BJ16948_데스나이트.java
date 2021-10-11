package Oct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ16948_데스나이트 {
	static int N;
	static class Pos {
		int x, y, d;

		public Pos(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
	}
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 격자판 크기 저장 
		
		int r, c, er, ec; // r = 시작 row , c = 시작 col , er = 끝 row , ec = 끝 col 
		r = sc.nextInt();
		c = sc.nextInt();
		er = sc.nextInt();
		ec = sc.nextInt();
		
		BFS(r,c, er, ec);
		
	}
	
	static void BFS(int r, int c, int er, int ec ) {
		int[] dx = {-2, -2, 0, 0, 2, 2};
		int[] dy = {-1, 1, -2, 2, -1, 1};
		
		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(r, c, 0));
		
		boolean[][] visited = new boolean[N][N];
		
		visited[r][c] = true;
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			if(now.x == er && now.y == ec) {
				System.out.println(now.d);
				return;
			}
			for (int i = 0; i < 6; i++) {
				int x = now.x + dx[i];
				int y = now.y + dy[i];
				
				if(isValid(x, y) && !visited[x][y]) {
					que.add(new Pos(x, y, now.d+1));
					visited[x][y] = true;
				}
			}
		}
		
		System.out.println(-1);
		
	}
	
	static boolean isValid(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < N) return true;
		return false;
	}

}

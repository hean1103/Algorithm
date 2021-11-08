package Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1189_컴백홈 {
	static int ans, R, C, K;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = bf.readLine().toCharArray();
		}
		ans = 0;
		boolean[][] visited = new boolean[R][C];
		visited[R-1][0] = true;
		DFS(1, R-1, 0, visited);
		
		System.out.println(ans);
	}
	
	static void DFS(int d, int x, int y, boolean[][] visited) {
		if(x == 0 && y == C-1 && d == K) {
			ans++;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int r = x + dx[i];
			int c = y + dy[i];
			
			if(r >= 0 && r < R && c >= 0 && c < C && !visited[r][c] && map[r][c] == '.') {
				visited[r][c] = true;
				DFS(d+1, r, c, visited);
				visited[r][c] = false;
			}
		}
		
	}

}

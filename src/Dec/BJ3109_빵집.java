package Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3109_빵집 {
	static int[] dx = {-1, 0, 1};
	static int n, m, ans = 0;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = bf.readLine().toCharArray();
		} // input end 
		
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			DFS(i, 0, visited);
		}
		System.out.println(ans);
	}
	
	static boolean DFS(int x, int y,  boolean[][] visited) {
		if(y == m-1) { // 빵집 열에 도착했다면 
			ans++;
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int tx = x + dx[i];
			int ty = y + 1;
			if(tx >= 0 && tx < n && ty < m && map[tx][ty] != 'x' && !visited[tx][ty]) {
				visited[tx][ty] = true;
				if(DFS(tx, ty, visited)) {
					return true;
				}
			}
		}
		return false;
	}

}

package Dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1194_달이차오른다가자 {
	static int n, m;
	static class Info {
		int x, y, move, key;
		public Info(int x, int y, int move, int key) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.key = key;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bf.readLine().split(" ");
		
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		char[][] maze = new char[n][m];
		int init[] = new int[2];
		for (int i = 0; i < n; i++) {
			char[] input = bf.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if(input[j] == '0') {
					init[0] = i; 
					init[1] = j;
				}
				maze[i][j] = input[j];
			}
		} // input end 
		
		escape(init[0], init[1], maze);
		
//		System.out.println((int)'a' + " "+ (int)'A'); 97 65 
	}
	
	static void escape(int x, int y, char[][] maze) {
		int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
		
		boolean[][][] visited = new boolean[n][m][64];
		Queue<Info> que = new LinkedList<Info>();
		que.add(new Info(x, y, 0, 0));
		visited[x][y][0] = true;
		
		while(!que.isEmpty()) {
			Info cur = que.poll();
			if(maze[cur.x][cur.y]-'0' == 1) {
				System.out.println(cur.move);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int tx = cur.x + dx[i];
				int ty = cur.y + dy[i];
				
				if(isMovable(tx, ty) && maze[tx][ty] != '#' && !visited[tx][ty][cur.key]) {
					int ref = (int)maze[tx][ty];
					// A ...F
					if(ref >= 65 && ref <= 70) {
						int temp = (1 << (ref-65)) & cur.key;
						if(temp > 0) {
							visited[tx][ty][cur.key] = true;
							que.offer(new Info(tx, ty, cur.move+1, cur.key));
						}
					} else if (ref >= 97 && ref <= 102) { // a...f
						
						int temp = (1 << (ref-97)) | cur.key;
						if(!visited[tx][ty][temp]) {
							visited[tx][ty][temp] = true;
							visited[tx][ty][cur.key] = true;
							que.offer(new Info(tx, ty, cur.move+1, temp));
						}
					} else {
						visited[tx][ty][cur.key] = true;
						que.offer(new Info(tx, ty, cur.move+1, cur.key));
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	static boolean isMovable(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < m) return true;
		return false;
	}

}

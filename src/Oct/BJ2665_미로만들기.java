package Oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ2665_미로만들기 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(bf.readLine());
		char[][] map = new char[N][N]; // 정보 저장 
		
		for (int i = 0; i < N; i++) {
			map[i] = bf.readLine().toCharArray();
		} // 입력 , 0 = 검은방 , 1 = 흰방 
		
		DFS(map);
		
		
		
		
		
	}
	static void DFS(char[][] map) {
		Stack<int[]> st = new Stack<>();
		Stack<int[]> sec = new Stack<>();
		boolean[][] visited = new boolean[N][N];
		int[] dx = {-1 , 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		st.push(new int[] {0, 0});
		visited[0][0] = true;
		int cnt = 0;
		while(true) {
			while(!st.isEmpty()) {
				int[] now = st.pop();
				if(now[0] == N-1 && now[1] == N-1) {
					System.out.println(cnt);
					return;
				}
				for (int i = 0; i < 4; i++) {
					int x = now[0] + dx[i];
					int y = now[1] + dy[i];
					
					if(isValid(x, y) && !visited[x][y] && map[x][y] == '1') { // 방문전이고 흰방이라면 
						st.push(new int[] {x, y});
						visited[x][y] = true;
					}else if(isValid(x, y) && map[x][y] == '0') { // 검정방이라면 
						sec.push(new int[] {x, y});
					}
					
				}
				
			}
			if(!sec.isEmpty()) {
				cnt += 1;
				st.addAll(sec);
				sec = new Stack<>();
			}else {
				break;
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < N) return true;
		return false;
	}

}



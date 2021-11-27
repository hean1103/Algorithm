package Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ14248_점프점프 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		
		int[] bridge = new int[N+1];
		st = new StringTokenizer(bf.readLine());
		
		for (int i = 1; i <= N; i++) {
			bridge[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = Integer.parseInt(bf.readLine());
		
		int ans = DFS(start, N, bridge);
		System.out.println(ans);

	}
	
	static int DFS(int start, int N, int[] bridge) {
		Stack<Integer> st = new Stack<>();
		st.push(start);
		
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		int ans = 1;
		while(!st.isEmpty()) {
			int cur = st.pop();
			int posR = cur + bridge[cur];
			int posL = cur - bridge[cur];
			if(posR <= N && !visited[posR]) {
				ans++;
				st.push(posR);
				visited[posR] = true;
			}
			if(posL > 0 && !visited[posL]) {
				ans++;
				st.push(posL);
				visited[posL] = true;
			}
		}
		
		return ans;
	}

}

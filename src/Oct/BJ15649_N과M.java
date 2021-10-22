package Oct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ15649_N과M {
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N+1];
		
		
		subJoin(N, M, 0, visited, 1 , "");
		
		bw.flush();
	}
	
	static void subJoin(int N, int M, int d, boolean[] visited, int s, String str) throws IOException {
		
		if(s > N) {
			if(d == M) {
				
				bw.write(str + "\n");
			}
			return;
		}
		
		if(!visited[s]) {
			visited[s] = true;
			subJoin(N, M, d+1, visited, 1, str + s + " ");
			visited[s] = false;
		}
		
		subJoin(N, M, d, visited, s+1, str);
		
		
	}

}

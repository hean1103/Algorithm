package Oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1182_부분수열의합 {
	static int ans, N, S;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		
		
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0; //정답 초기화 
		subJoin(0, 0, num);
		ans = S == 0 ? ans -1 : ans;
		System.out.println(ans);
	}
	
	static void subJoin(int start, int sum, int[] num) {
		if(start == N) {
			if(sum == S) ans++;
			return;
		}
		
		subJoin(start+1, sum+num[start], num);
		subJoin(start+1, sum, num);
	}
	

}

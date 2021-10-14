package Oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2056_작업 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(bf.readLine());
		int[] dp = new int[N+1];
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int time = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			dp[i] = time;
			
			for (int j = 0; j < cnt; j++) {
				int before = Integer.parseInt(st.nextToken());
				if(dp[before] + time > dp[i]) {
					dp[i] = dp[before] + time;
				}
			}
			
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
		
		
	}

}

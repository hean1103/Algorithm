package Oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2688_줄어들지않아 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(bf.readLine());
			
			long[][] dp = new long[N+1][10];
			for (int j = 0; j < 10; j++) {
				dp[1][j] = j+1;
			} // 초기화 
			
			for (int j = 2; j <= N; j++) {
				long sum = 0;
				for (int k = 0; k < 10; k++) {
					dp[j][k] = dp[j-1][k] + sum;
					sum += dp[j-1][k];
				}
			}
	
			System.out.println(dp[N][9]);
		}
		

	}

}

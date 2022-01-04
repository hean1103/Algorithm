package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932_정삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		
		int[][] number = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= i; j++) {
				number[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료 
		
		int[][] dp = new int[N+1][N+1];
		
		dp[1][1] = number[1][1];
		int max = 0;
		if(N == 1) {
			System.out.println(dp[1][1]);
			return;
		}
		for (int i = 2; i <= N; i++) {
			max = 0;
			for (int j = 1; j <= i; j++) {
				dp[i][j] = number[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]); // 자신 값 + 전단계 2개중 큰 값 
				if(max < dp[i][j]) max = dp[i][j];
			}
		} 
		
		System.out.println(max);
		
		
	}

}

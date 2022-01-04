package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16493_최대페이지수 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N, M; // N = 남은 기간, M = 챕터의 수 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[M+1][N+1]; // 최댓값 갱신을 위한 배열 
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(bf.readLine());
			int day = Integer.parseInt(st.nextToken()); // 챕터당 걸리는 날짜 
			int page = Integer.parseInt(st.nextToken()); // 챕터당 페이지 수 
			
			for (int j = 1; j <= N; j++) {
				if(day > j) dp[i][j] = dp[i-1][j]; // 날짜가 적다면 전까지의 최댓값 저장 
				else { // 날짜가 크거나 같다면 
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-day] + page);
				}
			}
		}
		
		System.out.println(dp[M][N]);
		

	}

}

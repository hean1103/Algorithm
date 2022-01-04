package Dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1451_직사각형으로나누기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long ans = Integer.MIN_VALUE;
		String in[] = bf.readLine().split(" ");
		int n, m;
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		
		long[][] arr = new long[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			char[] input = bf.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				arr[i][j+1] = input[j] - '0';
			}
		} // inut end 
		
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		} // 누적합 end 

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				long a = arr[i][j] * (arr[i][m] - arr[i][j]) * (arr[n][m] - arr[i][m]);
				long b = arr[i][j] * (arr[n][j] - arr[i][j]) * (arr[n][m] - arr[n][j]);
				
				long temp = Math.max(a, b);
				ans = Math.max(temp, ans);
			}
		} // 1차 분리 (작은 조각일경우) 

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=m; j++) {
				
				long a = arr[i][m];
				long b = (arr[n][j] - arr[i][j]);
				long c = arr[n][m] - (a + b);
				long temp = a * b * c;
				
				ans = Math.max(temp, ans);
			}
		} // 가로 전체일 경우 - 쪼개 갖기 (열)

		for (int i = 1; i <= n; i++) {
			for (int j = i+1; j <= n; j++) {
				long a = arr[i][m];
				long b = (arr[j][m] - a);
				long c = arr[n][m] - (a + b);
				long temp = a * b * c;
				
				ans = Math.max(temp, ans);
			}
		} // 가로 전체일 경우 - 쪼개 갖기 (행)

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				long a = arr[n][j];
				long b = (arr[i][m] - arr[i][j]);
				long c = arr[n][m] - (a + b);
				long temp = a * b * c;
				
				ans = Math.max(temp, ans);
			}
		} // 세로 전체일 경우 - 쪼개 갖기 (행)

		for (int i = 1; i <= m; i++) {
			for (int j = i+1; j <= m; j++) {
				long a = arr[n][i];
				long b = (arr[n][j] - a);
				long c = arr[n][m] - (a + b);
				long temp = a * b * c;
				
				ans = Math.max(temp, ans);
			}
		} // 세로 전체일 경우 - 쪼개 갖기 (열)
		System.out.println(ans);
	}


}

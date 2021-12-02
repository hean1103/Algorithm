package Dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2167_2차원배열의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n, m, k; 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1 ;  j <= m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end 
		
		int[][] sum = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for(int j = 1 ;  j <= m ; j++) {
				sum[i][j] = sum[i][j-1] + arr[i][j];
			}
		}

		k = Integer.parseInt(bf.readLine());
		int sx, sy, ex, ey; 
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bf.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			int ans = 0;
			for (int j = sx; j <= ex; j++) {
				ans += sum[j][ey]- sum[j][sy-1];
			}
			System.out.println(ans);
		}
		
	}

}

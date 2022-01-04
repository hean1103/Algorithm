package Dec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 누적합 구하기 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] += arr[i][j-1];
			}
		}
		int sx, sy, ex, ey, sum;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			sum = 0;
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			for (int j = sx; j <= ex; j++) {
				sum += arr[j][ey] - arr[j][sy-1];
			}
			bw.write(sum + "\n");
		}
		bw.flush();

	}

}

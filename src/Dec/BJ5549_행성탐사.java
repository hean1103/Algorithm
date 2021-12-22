package Dec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ5549_행성탐사 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n, m, k;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(bf.readLine());
		
		char[][] map = new char[n+1][m+1];
		int[][] jungle = new int[n+1][m+1];
		int[][] ocean = new int[n+1][m+1];
		int[][] ice = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			String str = bf.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = str.charAt(j-1);
			}
		} // input end
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				ocean[i][j] = ocean[i-1][j] + ocean[i][j-1] - ocean[i-1][j-1];
				jungle[i][j] = jungle[i-1][j] + jungle[i][j-1] - jungle[i-1][j-1];
				ice[i][j] = ice[i-1][j] + ice[i][j-1] - ice[i-1][j-1];
				switch(map[i][j]) {
				case 'O' :
					ocean[i][j]++;
					break;
				case 'J' :
					jungle[i][j]++;
					break;
				case 'I' :
					ice[i][j]++;
					break;
				}
			}
		} // 누적합 배열 완성
		int a, b, c, d, j, o, i;
		for (int l = 0; l < k; l++) {
			st = new StringTokenizer(bf.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			j = jungle[c][d] - jungle[a-1][d] - jungle[c][b-1] + jungle[a-1][b-1];
			o = ocean[c][d] - ocean[a-1][d] - ocean[c][b-1] + ocean[a-1][b-1];
			i = ice[c][d] - ice[a-1][d] - ice[c][b-1] + ice[a-1][b-1];
			bw.write(j + " " + o + " " + i + "\n");
		} 
		bw.flush();
	}
	
}

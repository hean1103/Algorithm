package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ9084_동전 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < T; i++) {
			
			int N = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine(), " ");
			int[] coin = new int[N];
			for (int j = 0; j < N; j++) {
				coin[j] = Integer.parseInt(st.nextToken());
			}
			int sum = Integer.parseInt(bf.readLine());
			
			int[] memo = new int[sum+1];
			memo[0] = 1;
			for (int j = 1; j <= N; j++) {
				for (int k = coin[j-1]; k <= sum; k++) {
					memo[k] += memo[k-coin[j-1]];
				}
			}
		
			System.out.println(memo[sum]);
		}
	}

}

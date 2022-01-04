package Dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 2; i <= n; i++) {
			arr[i] += arr[i-1] ;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int from, to;
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			System.out.println(arr[to] - arr[from-1]);
		}

	}

}

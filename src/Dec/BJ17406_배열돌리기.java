package Dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BJ17406_배열돌리기 {
	static int n, m, k, ans;
	static ArrayList<int[]> ref;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		ans = Integer.MAX_VALUE;
		
		int[][] arr = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ref = new ArrayList<int[]>();
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bf.readLine());
			int r, c, s;
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			ref.add(new int[] {r, c, s});
		}
		
		boolean[] visited = new boolean[k];
		
		for (int i = 0; i < k; i++) {
			int[][] temp = new int[n+1][m+1];
			for(int j = 1 ; j <=n ; j++) temp[j] = arr[j].clone();
			
			visited[i] = true;
			comb(1, i, temp, visited);
			visited[i] = false;
		}
		System.out.println(ans);

	}
	static void comb(int d, int order, int[][] arr, boolean[] visited) {
		int[] cur = ref.get(order);
		rotate(cur[0], cur[1], cur[2], arr);
		if(d == k) ans = Math.min(ans,  findMin(arr));
		
		for (int i = 0; i < k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int[][] temp = new int[n+1][m+1];
				for(int j = 1 ; j <=n ; j++) temp[j] = arr[j].clone();
				
				comb(d+1, i, temp, visited);
				visited[i] = false;
			}
		}
	}
	static int findMin(int[][] arr) {
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <=n; i++) {
			int sum = 0;
			for (int j = 1; j <= m; j++) {
				sum += arr[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}
	static void rotate(int r, int c, int s, int[][] arr) {
		int tx, ty, bx, by, head;
		tx = r-s;
		ty = c-s;
		bx = r+s;
		by = c+s;
		
		
		
		while(tx != bx && ty != by) {
			// right
			head = arr[tx][by];
			for (int i = by-1; i >= ty; i--) arr[tx][i+1] = arr[tx][i];
			
			// up 
			for (int i = tx; i < bx; i++) arr[i][ty] = arr[i+1][ty];
			
			// left
			for (int i = ty; i < by; i++) arr[bx][i] = arr[bx][i+1];
			
			// bottom 
			for (int i = bx; i > tx; i--) arr[i][by] = arr[i-1][by];
			arr[tx+1][by] = head;
			
			tx = tx+1;
			ty = ty+1;
			bx = bx-1;
			by = by-1;
		}
		
	}

}


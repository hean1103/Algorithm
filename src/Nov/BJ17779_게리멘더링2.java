package Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17779_게리멘더링2 {
	static int[][] popul;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(bf.readLine());
		
		popul = new int[n+1][n+1];
		
		int total = 0, num;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				num = Integer.parseInt(st.nextToken());
				total += num;
				popul[i][j] = num;
			}
		} // input end
		boolean[][] five = new boolean[n+1][n+1];
		int answer = Integer.MAX_VALUE;
		for (int x = 1; x <= n-2; x++) {
			for (int y = 2; y < n; y++) {
				for (int d1 = 1; d1 <= n-2; d1++) {
					for (int d2 = 1; d2 <= n-2; d2++) {
						if(isValid(x, y, d1, d2)) {
							five = distric5(x, y, d1, d2);
							answer = Math.min(city(x, y, d1, d2, total, five), answer);
						} else break;
					}
				}
			}
		}
		System.out.println(answer);

	}
	static boolean[][] distric5(int x, int y, int d1, int d2) {
		boolean[][] temp = new boolean[n+1][n+1];
		// 1 line 
		int j = y;
		for (int i = x; i <= x+d1; i++) {
			temp[i][j] = true;
			j--;
			
		}
		
		// 2 line 
		j = y;
		for (int i = x; i <= x+d2; i++) {
			temp[i][j] = true;
			j++;
		}

		// 3 line 
		j = y-d1;
		for (int i = x+d1; i <= x+d1+d2; i++) {
			temp[i][j] = true;
			j++;
		}

		j = y+d2;
		for (int i = x+d2; i <= x+d1+d2; i++) {				
			temp[i][j] = true;
			j--;
		}

		return temp;
	}
	static boolean isValid(int x, int y, int d1, int d2) {
		if(x+d1+d2 <= n && y-d1 >= 1 && y+d2 <= n) return true;
		return false;
	}
	
	static int city(int x, int y, int d1, int d2, int total, boolean[][] five) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		// 1번 선거구 
		for (int i = 1; i < x+d1; i++) {
			for (int j = 1; j <= y; j++) {
				if(!five[i][j]) {
					sum += popul[i][j];
				}else break;
			}
		}
		
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		total -= sum;
		sum = 0; 
		// 2번 선거구 
		for (int i = 1; i <= x+d2; i++) {
			for (int j = n; j >= y+1; j--) {
				if(!five[i][j]) {
					sum += popul[i][j];
				}else break;
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		total -= sum;
		sum = 0;
		
		// 3번 선거구 
		for (int i = x+d1; i <= n; i++) {
			for (int j = 1; j < y-d1+d2; j++) {
				if(!five[i][j]) {
					sum += popul[i][j];
				}else break;
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		total -= sum;
		sum = 0;
		
		// 4번 선거구 
		for (int i = x+d2+1; i <= n; i++) {
			for (int j = n ; j >= y-d1+d2; j--) {
				if(!five[i][j]) {
					sum += popul[i][j];
				}else break;
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		total -= sum;
		
		max = Math.max(max, total);
		min = Math.min(min, total);
		

		return max - min;
		
	}

}

package Jan;

import java.util.Scanner;

public class BJ16438_원숭이스포츠 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		boolean[][] ans = new boolean[7][n];
		recur(0, n-1, 0, true, ans);
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ans[i][j] ? "A" : "B");
			}
			System.out.println();
		}
	}
	
	static void recur(int start, int end, int day, boolean a, boolean[][] ans) {
		if(day == 7) {
			return;
		}
		
		int mid = (start + end) /2;
		
		for (int i = start; i <= end; i++) {
			ans[day][i] = i <= mid ? a : !a;
		}
		recur(start, mid, day+1, !a, ans);
		recur(mid+1, end, day+1, a, ans);
	}

}

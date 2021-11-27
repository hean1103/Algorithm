package Nov;

import java.util.Scanner;

public class BJ2302_극장좌석 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[] seat = new int[N+1];
		
		fibo(seat, N);
		
		int idx = 0, ans = 1;
		
		for (int i = 0; i < M; i++) {
			int vip = sc.nextInt();
			
			ans *= seat[vip - idx - 1];
			idx = vip;
		}
		
		System.out.println(ans * seat[N-idx]);
	}
	
	static void fibo(int[] seat, int N) {
		seat[0] = 1;
		seat[1] = 1;
		seat[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			seat[i] = seat[i-1] + seat[i-2];
		}
	}

}

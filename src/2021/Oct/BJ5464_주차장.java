package Oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5464_주차장 {
	static class PL {
		int car;
		int lot;
		public PL(int car, int lot) {
			super();
			this.car = car;
			this.lot = lot;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M;
		
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] cost = new int[N+1]; // 주차 공간의 요금 
		
		
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(bf.readLine());
		}
		
		int[] w = new int[M+1];
		
		for (int i = 1; i <= M; i++) {
			w[i] = Integer.parseInt(bf.readLine());
		}
		
		
		boolean[] used = new boolean[N+1];
		int sum = 0 , cnt = 0;
		Queue<Integer> wait = new LinkedList<Integer>();
		int[] park = new int[M+1];
		
		for (int i = 0; i < M*2; i++) {
			int num = Integer.parseInt(bf.readLine());
			if(num > 0) {
				if(cnt < N) {
					for (int j = 1; j <= N; j++) {
						if(!used[j]) {
							park[num] = j;
							used[j] = true;
							cnt++;
							break;
						}
					}
				} else {
					wait.offer(num);
				}
				
			} else {
				int abs = Math.abs(num);
				int place = park[abs];
				sum += cost[place] * w[abs];
				
				if(!wait.isEmpty()) {
					int cur = wait.poll();
					park[cur] = place;
					continue;
				}
				used[place] = false;
				cnt--;
			}
		}
		System.out.println(sum);
	}

}

package Dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2075_N번째큰수 {
	public static class Num implements Comparable<Num>{
		int num;
		
		public Num (int num) {
			
			this.num = num;
		}
		
		public int compareTo(Num o) {
			return o.num - this.num;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		PriorityQueue<Num> pq = new PriorityQueue<Num>();
		
		for (int i = 0; i < n ; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				pq.add(new Num(num));
			}
		}
		
		for (int i = 1; i < n; i++) {
			pq.poll();
		}
		
		System.out.println(pq.poll().num);
	}

}

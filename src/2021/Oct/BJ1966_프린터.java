package Oct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966_프린터 {
	static class Job implements Comparable<Job>{
		int idx;
		int pri;
		
		public Job(int idx, int pri) {
			super();
			this.idx = idx;
			this.pri = pri;
		}
		
		public int compareTo(Job o) {
			return o.pri - this.pri;
		}

		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		int N, M;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			Queue<Job> printer = new LinkedList<Job>();
			PriorityQueue<Job> mPrinter = new PriorityQueue<Job>();
			
			st = new StringTokenizer(bf.readLine());
			
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				printer.offer(new Job(j, temp));
				mPrinter.offer(new Job(j, temp));
			} // 입력 완료
			
			int time = 1;
			boolean find = false;
			
			while(!find) {
				
				
				Job max = mPrinter.peek();
				for (int j = 0; j < printer.size(); j++) {
					Job cur = printer.peek();
					
					if(cur.pri == max.pri) { // 제일 큰 우선순위라면 
						if(cur.idx == M) {
							bw.write(time + "\n");
							find = true;
							break;
						} 
						
						printer.poll();
						mPrinter.poll();
						time += 1;
						break;
					} else { // 작다면 
						printer.offer(printer.poll());
					}
					
				}
			}
			bw.flush();
			
		}
	}
	
	

}

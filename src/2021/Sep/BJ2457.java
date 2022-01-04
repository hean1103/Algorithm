package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2457 {
	static class Flower implements Comparable<Flower> {
		int sm;
		int em;
		
		public Flower(int sm, int em) {
			super();
			this.sm = sm;
			this.em = em;
		}	
		
		@Override
		public int compareTo(Flower o) {
			if(this.sm == o.sm) {
				return this.em - o.em;
			}
			return this.sm - o.sm;
		}

		@Override
		public String toString() {
			return "Flower [sm=" + sm + ", em=" + em + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		Flower[] flower = new Flower[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			flower[i] = new Flower(Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken()));
		}
	
		Arrays.sort(flower);
		int start = 301;
		int ans = 0;
		int end = 0;
		
		while(start < 1201) {
			boolean flag = false;
			for(int i = 0 ; i < N ; i++) {
				Flower f = flower[i]; 
				if(f.sm > start) break; 
				
				if(f.em > end) { 
					end = f.em;
					flag = true;
				}
			}
			
			if(flag) {
				ans++;
				start = end;
			}else 
				break;
		}
		
		if(end < 1201) System.out.println(0);
		else System.out.println(ans);
		 
	}
	
	
}



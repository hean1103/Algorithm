package Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3020_개똥벌래 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n, h ; 
		String[] in =  bf.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		h = Integer.parseInt(in[1]);
		
		int[] bottom, top;
		bottom = new int[h+1];
		top = new int[h+1];

		
		for (int i = 0; i < n/2; i++) {
			bottom[Integer.parseInt(bf.readLine())]++;
			top[Integer.parseInt(bf.readLine())]++;
		} // input end 
		
		for (int i = 1; i < h+1; i++) {
			bottom[i] += bottom[i-1];
			top[i] += top[i-1];
		}
		
		int cnt = 0, min = Integer.MAX_VALUE, hit = 0;
		for (int i = 1; i < h+1; i++) {
			hit = 0;
			
			hit += bottom[h] - bottom[i-1]; // 전체 갯수 - 길이 미만 석순 
			hit += top[h] - top[h-i];
			
			if(min > hit) {
				cnt = 1;
				min = hit;
			} else if(hit == min) cnt++;
		}
		
		System.out.println(min + " " + cnt);
	}

}

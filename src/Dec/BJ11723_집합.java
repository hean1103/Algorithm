package Dec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11723_집합 {
	static int init = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int num =0;
			switch(st.nextToken()) {
			case "add" :
				num = Integer.parseInt(st.nextToken())-1;
				init |= (1 << num);
				break;
			case "remove" :
				num = Integer.parseInt(st.nextToken())-1;
				init &= ~(1 << num);
				break;
			case "check" :
				num = Integer.parseInt(st.nextToken())-1;
				if((init & (1 << num)) != 0) {
					bw.write(1 + "\n");
				} else bw.write(0 + "\n");
				break;
			case "toggle" :
				num = Integer.parseInt(st.nextToken())-1;
				init ^= (1 << num);
				break;
			case "all" :
				init |= (~0);
				break;
			case "empty" :
				init &= 0;
				break;
			}
			
		}
		
		bw.flush();
	}

}

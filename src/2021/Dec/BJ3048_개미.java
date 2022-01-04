package Dec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ3048_개미 {
	static class Word {
		char c;
		boolean left;
		
		public Word (char c, boolean left) {
			this.c = c;
			this.left = left;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n, m; 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Word[] str = new Word[n+m];
		String temp = bf.readLine();
		for (int i = 0; i < n; i++) {
			str[n-i-1] = new Word(temp.charAt(i), true);
		}
		
		temp = bf.readLine();
		for (int i = 0; i < m; i++) {
			str[i+n] = new Word(temp.charAt(i), false);
		} // input 
			
		int time = Integer.parseInt(bf.readLine());
		
		while(time > 0) {
			Word[] temps = str.clone();

			for(int i = 0 ; i < n+m ; i++) {
				 
				if(str[i].left) { //원래 진행 방향이라면 
					if(i+1 < n+m && (str[i].left ^ str[i+1].left)) {
						temps[i] = str[i+1];
						temps[i+1] = str[i];
						i += 1;
						
						
					} 
					
				} else {
					if(i-1 >= 0 && (str[i].left ^ str[i-1].left)) {
						temps[i] = str[i-1];
						temps[i-1] = str[i];
						i+= 1;
						
					} 
				}
			}
			str = temps.clone();
			
			time--;
		}
		
		for (int i = 0; i < n+m; i++) {
			bw.write(str[i].c);
		}
		bw.flush();
	}

}

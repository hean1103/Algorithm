package Oct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ14906_스러피 {
	static int len;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine());
		
		bw.write("SLURPYS OUTPUT \n");
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			len = str.length();
			if(str.length() < 5) {
				bw.write("NO \n");
				continue;
			}
			int next, result;

			if(str.charAt(0) == 'A') {
				next = slimp(str, 0);
				if(next == 0) {
					bw.write("NO \n");
					continue;
				} else {
					result = slump(str, next+1);
					
					if(result == len-1) {
						bw.write("YES \n");
					} else {
						bw.write("NO \n");
						continue;
					}
					
					
				}
			} else { // 전혀 아닌 경우 
				bw.write("NO \n");
				continue;
			}
		}
		
		bw.write("END OF OUTPUT \n");
		bw.flush();
				
	}
	
	static int slump(String str, int start) {
		if(start >= len) return 0;
		if(str.charAt(start) == 'D' || str.charAt(start) == 'E') {
			int idx = start + 1;
			
			while(idx < len && str.charAt(idx) == 'F') {
				idx++;
			}
			
			if(idx == start || idx == len) return 0; // 다음 글자가 F가  아니거나, F로 끝나는 경우 false;
			
			if(str.charAt(idx) == 'G') return idx;
			else {
				return slump(str, idx);
			}
		} 
		
		return 0;
		
	}
	
	static int slimp(String str, int start) {
		if(str.charAt(start) != 'A') return 0;
		
		int ret = 0;
		if(str.charAt(start+1) == 'H') {
			return start+1;
		}else {
			if(str.charAt(start+1) == 'B') {
				ret = slimp(str, start+2);
				if(ret != 0 && str.charAt(ret+1) == 'C') return ret+1; 
				else return 0;
			} else {
				ret = slump(str, start+1);
				if(ret != 0 && str.charAt(ret+1) == 'C') return ret+1;
				else return 0;
			}
		}
		
	}

}

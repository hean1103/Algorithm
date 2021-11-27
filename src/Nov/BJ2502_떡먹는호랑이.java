package Nov;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2502_떡먹는호랑이 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int day = Integer.parseInt(st.nextToken()); // the day 
		int rc = Integer.parseInt(st.nextToken()); // rice cake
		
		for (int i = 1; i < 100001 ; i++) {
			for (int j = 1; j <= i; j++) {
				if(DP(i, j, day) == rc) {
					bw.write(j + "\n" + i);
					bw.flush();
					return;
				}
			}
		}

	}
	
	static int DP(int i , int j , int day) {
		int A = j, B = i, C = 0;
		for (int k = 3; k <= day ; k++) {
			C = A + B;
			A = B;
			B = C;
		}
		
		return C;
	}

}

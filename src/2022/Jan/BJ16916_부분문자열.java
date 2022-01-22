package Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16916_부분문자열 {
	static int[] pi;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] S = bf.readLine().toCharArray();
		char[] P = bf.readLine().toCharArray();
		
		pi = new int[P.length];
		kmp( P.length,  P);
		
		int j = 0;
		for (int i = 0; i < S.length; i++) {
			while( j > 0 && S[i] != P[j]) {
				j = pi[j-1];
			}
			
			if(S[i] == P[j]) {
				j++;
				if(j == P.length) {
					System.out.println(1);
					return;
				}
			}
		}
		
		System.out.println(0);
		

	}
	
	static void kmp(int n, char[] P) {
		int j = 0;
		
		for (int i = 1; i < P.length; i++) {
			while(j > 0 && P[i] != P[j]) {
				j = pi[j-1];
			}
			
			if(P[i] == P[j]) {
				pi[i] = ++j;
			}
		}
	
	}

}

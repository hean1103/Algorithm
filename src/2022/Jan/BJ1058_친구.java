package Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class BJ1058_친구 {
	static int[] friends;
	static int n;
	static char[][] rel;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		friends = new int[n];
		
		rel = new char[n][n];
		for (int i = 0; i < n; i++) {
			rel[i] = bf.readLine().toCharArray();
		} // input end 
		
		boolean[][] isF = new boolean[n][n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				if(rel[i][j] == 'Y') {
					if(!isF[i][j]) {
						friends[i]++;
						isF[i][j] = true;
					}
					
					for (int k = 0; k < n; k++) {
						if(rel[j][k] == 'Y' && !isF[i][k] && i != k) {
							friends[i]++;
							isF[i][k] = true;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			max = Math.max(max, friends[i]);
		}
		System.out.println(max);
	}
	
	

}

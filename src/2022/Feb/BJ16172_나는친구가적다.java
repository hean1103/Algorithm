package Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16172_나는친구가적다 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String text = bf.readLine();
		String sample = bf.readLine();
		
		int result = 0;
		int[] lps = new int[sample.length()];
		findLPS(lps, sample);
		
		int s = 0;
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i)-'0' >= 0 && text.charAt(i)-'0' <= 9) continue;
			while(s > 0 && text.charAt(i) != sample.charAt(s)) {
				s = lps[s-1];
			}
			
			if(sample.charAt(s) == text.charAt(i)) {
				s++;
				if(s == sample.length()) {
					result = 1;
					break;
				}
			}
		}
		System.out.println(result);

	}
	
	static void findLPS(int[] array, String sample) {
		int i = 0; 
		int n = array.length;
		
		for (int j = 1; j < n; j++) {
			
			while(i > 0 && sample.charAt(i) != sample.charAt(j)) {
				i = array[i-1];
			}
			if(sample.charAt(i) == sample.charAt(j)) {
				array[j] = ++i;
			}
		}
	}

}

package Jan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ9324_진짜메세지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			if(check(str)) bw.write("OK" + "\n");
			else bw.write("FAKE\n");
		}
		bw.flush();
		
				

	}
	
	static boolean check(String str) {
		int[] alpha = new int[26];
		
		for (int i = 0 ; i < str.length(); i++) {
			int ref = str.charAt(i)-'A';
			alpha[ref]++;
			if(alpha[ref]%3 == 0) {
				if(i+1 < str.length() && str.charAt(i) != str.charAt(i+1) ) {
					return false;
				} else if (i+1 >= str.length()) return false;
				
				i++;
			}
		}
		return true;

	}

}

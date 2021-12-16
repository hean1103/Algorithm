package Dec;

import java.util.Scanner;

public class BJ1094_막대기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		String bin = Integer.toBinaryString(x);
		
		int cnt = 0; 
		
		for (char s : bin.toCharArray()) {
			if(s == '1') cnt++;
		}
		
		System.out.println(cnt);
	}

}

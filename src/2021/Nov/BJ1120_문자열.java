package Nov;

import java.util.Scanner;

public class BJ1120_문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int diff, ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < str[1].length()-str[0].length()+1; i++) {
			diff = 0;
			for (int j = 0; j < str[0].length(); j++) {
				if(str[0].charAt(j) != str[1].charAt(i+j)) diff++;
			}
			ans = Math.min(ans, diff);
		}
		System.out.println(ans);

	}

}

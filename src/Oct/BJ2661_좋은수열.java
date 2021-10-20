package Oct;

import java.util.Scanner;

public class BJ2661_좋은수열 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		String num = "";
		
		find(num);
		
		

	}
	
	static void find( String num) {
		if(num.length() == N) {
			System.out.println(num);
			System.exit(0);
		} 
		
		for (int i = 1; i <= 3; i++) {
			
			if(isGood(num + i)) {
				find(num + i);
			}
		}
		
		
	}
	
	static boolean isGood(String num) {
		int size = num.length();
		int len = size / 2;
		
		for (int i = 1; i <= len ; i++) {
			int begin = size - i;
			if(num.substring(begin).equals(num.substring(begin-i, begin))) {
				return false;
			}
		}
		return true;
	}

}

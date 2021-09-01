package Sep;

import java.util.Scanner;

public class BJ9046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		outer :for(int i = 0 ; i < T ; i++) {
			char[] str = sc.nextLine().toCharArray();
			int[] alpha = new int[26];
			
			for (int j = 0; j < str.length; j++) {
				if(str[j] != ' ') alpha[((int)str[j])-97]++;
			}
			
			int max = 0, index = 0;
			for (int j = 0; j < alpha.length; j++) {
				if(alpha[j] > max) {
					max = alpha[j];
					index = j;
				}
			}
			for (int j = 0; j < alpha.length; j++) {
				if(max == alpha[j] && j != index) {
					System.out.println("?");
					continue outer;
				}
			}
			
			System.out.println((char)(index+97));
			
			
		}
		
		sc.close();

	}

}

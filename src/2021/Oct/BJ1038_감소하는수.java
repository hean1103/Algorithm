package Oct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ1038_감소하는수 {
	static ArrayList<Long> lists;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		lists = new ArrayList<>();
		if(N <= 10 ) System.out.println(N);
		else if(N > 1022) System.out.println(-1);
		else {
			for (int i = 0; i < 10; i++) {
				cal(i, 1);
			}
			
			Collections.sort(lists);
			System.out.println(lists.get(N));
		}
		sc.close();
	}
	
	static void cal(long num, int d) {
		if(d > 10) return;
		
		lists.add(new Long(num));
		
		for (int i = 0; i < 10; i++) {
			if(num % 10 > i) {
				cal((num * 10) + i, d+1);
			}
		}
		return;
	}

}

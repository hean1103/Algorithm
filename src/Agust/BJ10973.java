package Agust;

import java.util.Scanner;

public class BJ10973 {
	static int N;
	static String s;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		visited = new boolean[N+1];
		s = sc.nextLine().replace(" ","");
		
		permutation(0);
		sc.close();
	}
	
	private static void permutation(int cnt) {
		if(cnt == N) {
			StringBuilder sb = new StringBuilder();
			for(int i = 1 ; i <= N ; i++) {
				if(visited[i]) {
					sb.append(i);
				}
			}
			if(Integer.parseInt(s) > Integer.parseInt(sb.toString())) {
				System.out.println(sb.toString());
			}
			return;
		}
		
		for(int i = 1; i <= N ; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			permutation(cnt+1);
			visited[i] = false;
		}
	}

}

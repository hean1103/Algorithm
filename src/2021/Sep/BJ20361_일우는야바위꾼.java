package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ20361_일우는야바위꾼 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N, X, K; // N = 컵의 총갯수 , X = 공이 숨겨져 있는 컵의 번호 , K = 섞은 횟수 
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] cup = new int[N+1];
		for (int i = 1; i <= N; i++) {
			cup[i] = i;
		} // 컵을 각 번호로 초기화 
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			swipe(x, y, cup); // 두 개의 컵 바꾸기 
			
		}
		
		for (int i = 1; i <= N; i++) {
			if(cup[i] == X) {
				System.out.println(i);
				return;
			}
		}
		
		

	}
	
	static void swipe(int x, int y , int[] cup) {
		int temp = cup[x];
		cup[x] = cup[y];
		cup[y] = temp;
	}

}



package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2643_색종이올려놓기 {
	static int N;
	static Paper[] paper; // 색종이 저장 배열 
	static int[] count; // 색종이 갯수 저장 배열 
	static class Paper implements Comparable<Paper> {
		int x;
		int y;
		public Paper(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Paper o) { // x와 y 모두 비교해서 작은 순으로 정렬 
			return (this.x - o.x) + (this.y - o.y);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		
		paper = new Paper[N];
		count = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			paper[i] = new Paper(Math.min(x, y), Math.max(x,  y)); // 작은값이 x, 큰 값이 y로 오도록 저장 
		} // paper 저장 완료 
		
		Arrays.sort(paper); // 정렬 
		DP();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if(count[i] > max) max = count[i];
		}
		System.out.println(max);
	}
	
	static void DP() {
		count[0] = 1; // 자기 시작은 1로 초기화 
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(isBig(paper[i].x, paper[i].y, paper[j].x , paper[j].y)) { // 안에 있다면 
					if(count[i]+1 > count[j]) count[j] = count[i]+1;
				} 
			}
		}
	}
	static boolean isBig(int x1, int y1, int x2, int y2) { // 색종이 위에 올라 갈 수 있는지 확인 
		if(x1 <= x2 && y1 <= y2) return true;
		return false;
	}

}

package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17143_낚시꾼 {
	static int R, C, M ; // R = row, C = col, M = 상어 수
	static Shark[][] shark;
	static class Shark{

		int s; // speed 
		int d; // direction
		int z; // size 
		
		public Shark(int s, int d, int z) {
			super();

			this.s = s;
			this.d = d;
			this.z = z;
		}

		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		 
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		shark = new Shark[R+1][C+1];
		
		for (int i = 0; i < M; i++) {
			int r, c, s, d, z;
			st = new StringTokenizer(bf.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			shark[r][c] = new Shark(s, d, z);

		} //상어 저장 완료 
		
		int fisher = 1; // 낚시꾼 위치 
		int gets = 0; // 잡은 상어 크기 저장 
		while(fisher <= C) {
			int ans = getShark(fisher);
			gets += ans; // 현재 열의 상어 먹기 
			shark = moveShark();
			fisher++;
			
		}
		System.out.println(gets);


	}
	
	static int getShark(int col) {
		int res = 0;
		for (int i = 1; i <= R; i++) {
			
			if(shark[i][col] != null) 
			{
				res = shark[i][col].z;
				shark[i][col] = null; // 상어 먹힘 
				return res;
			}
		}
		return res;
	}
	
	static Shark[][] moveShark() {
		Shark[][] temp = new Shark[R+1][C+1];
		int dx[] = {0, -1, 1, 0, 0};
		int dy[] = {0, 0, 0, 1, -1};
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(shark[i][j] != null) { // 상어가 존재한다면 
					Shark sh = shark[i][j];
					int move = 0;
					int x = i;
					int y = j;
					while(move < sh.s) { // 이동 
						x += dx[sh.d];
						y += dy[sh.d];
						if(!isValid(x, y)) { // 범위를 벗어났다면 
							if(sh.d == 1) { // 위 
								x = 2; 
								sh.d = 2;
								
							} else if (sh.d == 2) { // 아래 
								x = R-1;
								sh.d = 1;
			
							} else if(sh.d == 3) { // 오른쪽
								y = C-1;
								sh.d = 4;
					
							} else {
								y = 2;
								sh.d = 3;
						
							}
						}
						move++;
					}
					temp[x][y] = move(temp[x][y], sh);
				}
			}
		}
		return temp;
	}
	
	
	static Shark move(Shark temp, Shark shark) {
		if(temp != null && temp.z > shark.z) { //이미 상어가 있고, 그 상어가 크다면 변경되는것없음 
			return temp;
		} else {
			return shark; // 새롭게 상어 이동 
		}
	}
	
	static boolean isValid(int x, int y) {
		if (x >= 1 && x <= R && y >= 1 && y <= C) return true;
		return false;
	}
}

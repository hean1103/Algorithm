package Sep;

/*******************************************************************************
 * BaekJoon 3190 번 
 * 
 * 예시 input 
 *  6
 *	3
 *	3 4
 *	2 5
 *	5 3
 *	3
 *	3 D
 *	15 L
 *	17 D
 * 결과 값 
 * 9
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ3190_뱀 {
	static int time, n,ans ;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Deque<int[]> que;
	static int[][] map ; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		time = 0; // 0초 세팅 , 진행 시간 
		ans = 0; // 0정답 세팅 
		map = new int[n+1][n+1];
		
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = 9; // apple 
		}
				
		int l = sc.nextInt();
		sc.nextLine();
		que = new LinkedList<>();
		que.offer(new int[]{1, 1}); // 뱀의 첫 위치 저장 
		map[1][1] = 1; // snake
		int d = 1; // 처음 방향 오른쪽 
		
 		outer : for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			int sec = Integer.parseInt(st.nextToken()); // 뱀의 이동 방향이 바뀌는 시간 저장 
			String direc = st.nextToken(); // 다음 방향 저장 
			
			while (time < sec) { // 방향 이동 시간 전 까지 뱀 이동 
				time++; 
				if(move(d)) { // 뱀의 이동이 가능하다면 
					ans++; // 정답 시간 증가 
				} else { // 벽이나 자기 자신과 부힘  
					break outer;
				}
			}
			
			if(direc.equals("D")) { //오른쪽 
				d = (d+1)%4; 
			} else { //  왼쪽 
				d = d-1 < 0 ? 3 : (d-1); // 0보다 작으면 0으로 바꿔주고, 아니면 -1 
			}
		}
 		while(move(d)) { // 회전이 끝난 후, 뱀이 이동 가능할 때 까지 시간 check 
 			ans++;
 		}
 		System.out.println(ans+1); // 죽는 시간 포함 + 1
		sc.close();

	}
	static boolean move(int dir) {
		int[] temp = que.peek();
		int x = temp[0] + dx[dir];
		int y = temp[1] + dy[dir];
		
		if(x >= 1 && x < n+1 && y >= 1 && y < n+1) { // 범위 안
			
			if(map[x][y] == 1) { // 다음 칸에서 자기 몸과 부딪히면 false 
				return false;
			}else if (map[x][y] == 0) { // 다음 칸이 빈칸이라면 
				int[] delete = que.pollLast(); // 꼬리 수축 
				map[delete[0]][delete[1]] = 0; // 꼬리있던 부분을 빈칸으로 초기화 
			} 
			
			que.offerFirst(new int[] {x, y}); // 현 위치 (머리 부분)을 queue에 삽입 
			map[x][y] = 1; // 뱀으로 인식 
			
			return true;
		}
		return false; // 벽과 부딪히면 false
	}
	

}

package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17845_수강과목 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int time, count;
		time = Integer.parseInt(st.nextToken()); // 총 시간 입력 
		count = Integer.parseInt(st.nextToken()); // 총 과목 갯수 입력 
		
		int[][] times = new int[count+1][time+1]; // DP 배열을 저장할 배열 
		int[][] subjects = new int[count+1][2]; // 과목의 정보를 저장할 배열 
		for (int i = 1; i <= count; i++) { // 1부터 과목 수 만큼 반복 
			st = new StringTokenizer(bf.readLine(), " ");
			subjects[i][0] = Integer.parseInt(st.nextToken()); // 중요도 저장 
			subjects[i][1] = Integer.parseInt(st.nextToken()); // 시간 저장 
		} // 입력완료 
		
		for (int i = 1; i <= count; i++) { // 각 과목에 대하여 반복 
			for (int j = 0; j <= time; j++) { // 매분에 대하여 반복 
				if(j >= subjects[i][1]) { // 현재 과목의 시간보다 현재 시간이 더 크다면 
					times[i][j] = Math.max(times[i-1][j], times[i-1][j-subjects[i][1]] + subjects[i][0]);
					//그 전 단계까지의 값 vs 현재 중요도 + 현 시간 - 전단계의 현 과목 소요 시간 의 중요도 값  
				} else {
					times[i][j] = times[i-1][j]; // 전값으로 갱신 
				}
			}
		}
		
		System.out.println(times[count][time]);
	}

}

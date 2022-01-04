package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2846_오르막길 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N; // 수열의 크기 
		int ans = 0; // 정답을 저장할 변수 
		N = Integer.parseInt(bf.readLine());
		
		int[] LIS = new int[N]; // LIS를 저장할 배열 
		
		st = new StringTokenizer(bf.readLine());
		int size = 0; // 저장된 수열의 길이를 저장할 변수 
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(size > 0 && LIS[size-1] >= num) { // 맨 뒤의 숫자보다 현재 숫자가 작다면 갱신이 필요함 
				ans = Math.max(ans, LIS[size-1]-LIS[0]); // 현재 LIS배열에 저장된 맨 앞 숫자와 맨 뒤 숫자를 ans 에 저장 
				size = 0; // LIS 초기화 
				LIS = new int[N]; // LIS 초기화 
			}
			int index = Arrays.binarySearch(LIS, 0, size, num); // 저장 위치 찾음 

			LIS[Math.abs(index)-1] = num; // LIS배열에 정해진 위치에 값 넣기 
			size++; // 맨 뒤 사이즈 증가 
			
		}
		ans = Math.max(ans, LIS[size-1]-LIS[0]);
		System.out.println(ans);

	}

}

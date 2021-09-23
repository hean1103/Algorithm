package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1965_상자넣기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			int N = Integer.parseInt(bf.readLine());
			
			int[] boxes = new int[N];
			
			st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < N; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			// 입력 완료 
			
			int[] LIS = new int[N];
			Arrays.fill(LIS, Integer.MAX_VALUE); // 최댓값으로 채워넣기 
			
			for (int i = 0; i < N; i++) {
				int index = Math.abs(Arrays.binarySearch(LIS, boxes[i])); // 이진탐색을 통해 숫자의 위치 찾기 
				index = index == 0 ? 0 : index -1;
				if(LIS[index] > boxes[i]) LIS[index] = boxes[i]; // LIS 값 갱신 
			}
			int count = 0;
			for (int i = 0; i < N; i++) { // 값을 갖고 있는 LIS 찾기 
				if(LIS[i] != Integer.MAX_VALUE) count++;
				else break;
			}
			System.out.println(count);

	}

}

package Oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11053_증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(bf.readLine()); // 수열의 길이 저장 
		
		int[] LIS = new int[N]; // N의 길이만큼 LIS 배열 생성 
		int size = 0;
		
		st = new StringTokenizer(bf.readLine());
		int num, index; // num = 입력받은 숫자, index = LIS 배열 내의 위치 인덱스 
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			index = Arrays.binarySearch(LIS, 0, size, num); // num의 위치 찾기
			if(index < 0) { //배열 내에서 위치를 찾는다면 
				LIS[Math.abs(index)-1] = num;
				if(Math.abs(index)-1 == size) size++; // 뒤에 추가된것이라면 +1
			} 
		}
		
		System.out.println(size);


	}

}

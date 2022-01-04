package Oct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ14888_연산자끼워넣기 {
	static int min, max, N;
	static int[] number, op;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		number = new int[N]; // 숫자 저장 
		op = new int[4]; // 연산자 저장 
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		int[] cnt = new int[4];
		findValue(number[0], 1, cnt);
		
		bw.write(max + "\n" + min+"\n");
		bw.flush();
	}
	
	static void findValue( int sum, int index, int[] cnt) {

		if(index == N) {
			max = Integer.max(max, sum);
			min = Integer.min(min, sum);
			return;
		}
		
		if(cnt[0] < op[0]) {
			cnt[0] += 1;
			findValue(sum + number[index], index+1, cnt);
			cnt[0] -= 1;
		}
		if(cnt[1] < op[1]) {
			cnt[1] += 1;
			findValue(sum - number[index], index+1, cnt);
			cnt[1] -= 1;
		}
		if(cnt[2] < op[2]) {
			cnt[2] += 1;
			findValue(sum * number[index], index+1, cnt);
			cnt[2] -= 1;
		}
		if(cnt[3] < op[3]) {
			cnt[3] += 1;
			findValue(sum / number[index], index+1, cnt);
			cnt[3] -= 1;
		}
		
		
	}

}

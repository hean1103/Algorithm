package Dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14646_욱제는결정장애야 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		boolean[] rooler = new boolean[n+1];
		int cnt = 0, max = 0;
		for (int i = 0; i < 2*n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!rooler[num]) { // 아직 선택 전이라면 
				rooler[num] = true;
				cnt++;
			} else {
				rooler[num] = false;
				cnt--;
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}

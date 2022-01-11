package Jan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ8911_거북이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			
			bw.write(square(str)+"\n");
		}
		bw.flush();

	}
	
	static int square(String str) {
		int x = 0, max = 0, mix = 0; 
		int y = 0, may = 0, miy = 0;
		
		int dir = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for (char c : str.toCharArray()) {
			switch (c) {
			case 'L' :
				dir = dir-1 < 0 ? 3 : dir-1;
				break;
			case 'R' : 
				dir = (dir + 1) % 4;
				break;
			case 'F' :
				x += dx[dir];
				y += dy[dir];
				
				max = Math.max(max, x);
				may = Math.max(may, y);
				mix = Math.min(mix, x);
				miy = Math.min(miy, y);
				break;
			case 'B' : 
				x -= dx[dir];
				y -= dy[dir];
				
				max = Math.max(max, x);
				may = Math.max(may, y);
				mix = Math.min(mix, x);
				miy = Math.min(miy, y);
				break;
			
			}
		}
		return Math.abs(max-mix) * Math.abs(may-miy);
	}

}

//1
//FRFBFFF

package Oct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ1032_명령프롬프트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine()); //  문서 갯수 저장 
		
		
		
		char[] text = bf.readLine().toCharArray(); // 대상이 될 텍스트 저장 
		int len = text.length;
		boolean[] same = new boolean[len];
		for (int i = 0; i < N-1; i++) { // 첫번을 뺀 만큼 반복 
			char[] temp = bf.readLine().toCharArray();
			
			for (int j = 0; j < len; j++) {
			
				if(!same[j] && text[j] != temp[j]) same[j] = true;
			}
		}
		for (int j = 0; j < len; j++) {
			if(!same[j]) bw.append(text[j]);
			else bw.append("?");
		}
		bw.flush();
		
		

	}

}

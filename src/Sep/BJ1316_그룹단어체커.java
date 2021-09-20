package Sep;

/*******************************************************************************
 * BaekJoon 1316 번 
 * 
 * 예시 input 
 * 3
 * happy
 * new
 * year
 * 결과 값 
 * 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1316_그룹단어체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int ans = 0; // 정답 
		
		for (int i = 0; i < N; i++) {
			char[] word = bf.readLine().toCharArray(); // 단어 char[] 배열로 받기 
			boolean[] alpha = new boolean[26]; // 사용 알파벳 체크 배열 
			
			for (int j = 0; j < word.length; j++) {
				int num = (int)word[j]-97; // 배열에 들어갈 숫자 추출 ASCII a = 97
				
				if(!alpha[num]) { // 사용한 적이 없는 알파벳이고 
					if(j+1 < word.length && word[j] != word[j+1]) { // 다음 알파벳과 다르다면 
						alpha[num] = true; // 알파벳을 사용했다고 표시 
					} else if (j == word.length-1) { // 마지막 알파벳까지 도달했다면 정답 +1 
						ans++;
					}
				}else { // 이미 사용한 알파벳이라면 정답 갱신하지 않고 for문 벗어나기 
					break;
				}	
			}
		}
		System.out.println(ans);
	}

}

package Sep;


import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;


public class BJ20291 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		sc.nextLine(); // 버퍼 빼기 
		Map<String, Integer> f = new TreeMap<>();
		for (int i = 0; i < T; i++) {
			String[] str = sc.nextLine().split("\\.");
			String file = str[1];
			if(f.containsKey(file)) {
				f.put(file, f.get(file) + 1);
			} else {
				f.put(file, 1);
			}
			
		}
		
		for (String key : f.keySet()) {
			System.out.println(key + " " + f.get(key));
		}
		sc.close();
	}
}
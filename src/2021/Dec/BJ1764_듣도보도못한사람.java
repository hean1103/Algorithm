package Dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class BJ1764_듣도보도못한사람 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] in = bf.readLine().split(" ");
		
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);
		
		HashSet<String> Listen = new HashSet<String>();
		
		for (int i = 0; i < n; i++) {
			Listen.add(bf.readLine());
		}
		ArrayList<String> ans = new ArrayList<String>();
		for (int i = 0; i < m; i++) {
			String name = bf.readLine();
			if(Listen.contains(name)) {
				ans.add(name);
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for (String string : ans) {
			System.out.println(string);
		}
		

	}

}

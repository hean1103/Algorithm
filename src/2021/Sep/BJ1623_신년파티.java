package Sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1623_신년파티 {
	static int n;
	static int[] yang, dist;
	static ArrayList<Integer> ans, ansWith;
	static ArrayList<Integer> temp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		
		yang = new int[n+1];
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			yang[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 2; i <= n; i++) {
			int v = Integer.parseInt(st.nextToken());
			tree.get(v).add(i);
		}
		ansWith = new ArrayList<>();
		dist = yang.clone();
		ansWith.add(1);
		noBoss(tree, ansWith);
		int num = yang[1];
		for (int i = 2 ; i <= n ; i++) {
			if(yang[i] != dist[i]) {
				num += dist[i];
			}
		}
		
		ans = new ArrayList<>();
		dist = yang.clone();
		noBoss(tree, ans);
		dist[1] = findMax(tree.get(1));
		ans.addAll(temp);
		System.out.println(num + " " + dist[1]);
		Collections.sort(ansWith);
		for (int a : ansWith) {
			System.out.print(a + " ");
		}
		System.out.println(-1);
		
		Collections.sort(ans);
		for (int a : ans) {
			System.out.print(a + " ");
		}
		System.out.println(-1);
		
	}
	
	static void noBoss(ArrayList<ArrayList<Integer>> tree, ArrayList<Integer> answer) {
		for(int i = n ; i > 1 ; i--) {
			if(tree.get(i).size() > 0) {
				int max = findMax(tree.get(i));
				if (yang[i] < max) {
					answer.addAll(temp);
					dist[i] = max;
				} else {
					answer.add(i);
				}
				
			}
		}
		
	}
	
	static int findMax(ArrayList<Integer> t) {
		int max = 0;
		temp = new ArrayList<>();
		for (Integer i : t) {
			if(max < max+dist[i] && yang[i] == dist[i]) {
				temp.add(i);
			}
			max = Math.max(max, max+dist[i]);
		}
		return max;
		
		
	}

}



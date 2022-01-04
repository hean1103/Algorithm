package Sep;

import java.util.*;

public class BJ1260_DFS와BFS {
	
	static int N, M, V;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		boolean[] visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}
		DFS(V, visited);
		System.out.println();
		visited = new boolean[N+1];
		BFS(V, visited);
		sc.close();

	}
	
	static void DFS(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int t : graph.get(v)) {
			if(!visited[t]) {
				DFS(t, visited);
			}
		}
		
	}
	
	static void BFS(int v, boolean[] visited) {
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(v);
		visited[v] = true;
		while(!que.isEmpty()) {
			int now = que.poll();
			
			System.out.print(now + " ");
			for (int t : graph.get(now)) {
				if(!visited[t]) {
					que.offer(t);
					visited[t] = true;
				}
			}
		}
		
	}

}

import java.util.*;
import java.io.*;

public class Main {
	private static int n;
	private static List<List<Integer>> adjList;
	private static List<Integer> bridges;
	
	private static void dfs(int node, boolean[] visited) {
		visited[node] = true;
		for (int neighbor : adjList.get(node)) {
			if (!visited[neighbor]) {
				dfs(neighbor, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // number of cities
		int m = sc.nextInt(); // number of roads. 
		
		adjList = new ArrayList<>();
		bridges = new ArrayList<>();
		for (int i=0; i<=n; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for (int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		
		boolean[] visited = new boolean[n+1];
		for (int i=1; i <= n; i++) {
			if (!visited[i]) {
				bridges.add(i);
				dfs(i, visited);
			}	
		}
		
		System.out.println(bridges.size() - 1);
		for (int i=0; i<bridges.size() - 1; i++) {
			System.out.println(bridges.get(i) + " " + bridges.get(i+1));
		}
	} 
}
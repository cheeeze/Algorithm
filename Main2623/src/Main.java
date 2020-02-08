import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
 * BOJ #2623 음악프로그램
 * 시작일 : 2019-02-08
 * 완료일 : 2019-02-09
 * Topological Sort / DFS
 */
public class Main {
	static int n;
	static boolean[] visited;
	static boolean[] cycle;
	static boolean flagCycle;
	static LinkedList<Integer>[] adj;
	static Stack<Integer> answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		adj = new LinkedList[n+1];
		visited = new boolean[n+1];
		cycle = new boolean[n+1];
		flagCycle = false;
		answer = new Stack<>();
		for(int i=1;i<=n;i++) {
			adj[i] = new LinkedList<>();
		}
		for(int i=0;i<m;i++) {
			int x = sc.nextInt();
			int a = sc.nextInt();
			for(int j=0;j<x-1;j++) {
				int b = sc.nextInt();
				if(!adj[a].contains(b)) {
					adj[a].add(b);
				}
				a = b;
			}
		}
		
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
		if(flagCycle) {
			System.out.println("0");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		while(!answer.isEmpty()) {
			sb.append(answer.pop()+"\n");
		}
		System.out.print(sb.toString());
		
	}
	
	static void dfs(int x) {
		while(!adj[x].isEmpty()) {
			int t = adj[x].poll();
			if(!visited[t]) {
				visited[t] = true;
				dfs(t);
			}
			if(!cycle[t]) {
				flagCycle = true;
				return;
			}
		}
		cycle[x] = true;
		answer.add(x);
	}
}

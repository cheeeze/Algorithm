import java.util.Scanner;

/*
 * SWEA #2814. 최장 경로
 * 시작일 : 2020-03-02
 * 완료일 : ``
 */
public class Solution {
	static int n;
	static int m;
	static int[][] adj;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			adj = new int[n+1][n+1];
			visited = new boolean[n+1];
			answer = 0;
			
			for(int i=0;i<m;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a][b] = 1;
				adj[b][a] = 1;
			}
			
			for(int i=1;i<=n;i++) {
				visited[i] = true;
				dfs(i,1);
				visited[i] = false;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	static void dfs(int start, int cnt) {
		answer = Math.max(answer,  cnt);
		
		for(int i=1;i<=n;i++) {
			if(adj[start][i]==1 && !visited[i]) {
				visited[i] = true;
				dfs(i,cnt+1);
				visited[i] = false;
			}
		}
	}

}

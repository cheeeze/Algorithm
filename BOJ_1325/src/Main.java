import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * BOJ #1325 효율적인 해킹
 * 시작일 : 2020-09-17
 * 완료일 : 2020-09-18 
 * DFS
 */
public class Main {

	static ArrayList<Integer>[] adj;
	static int[] degree;
    static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		adj = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new ArrayList<>();
		}
		degree = new int[n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
		}

		for(int i=1;i<=n;i++) {
			visited = new boolean[n+1];
			visited[i] = true;
			degree[i]++;
			dfs(i);		
		}
		
		int max = -1;
		for(int i=1;i<=n;i++) {
			if(max<degree[i]) {
				max = degree[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			if(max==degree[i]) {				
				sb.append(i);
				sb.append(' ');
			}
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int k) {
		int size = adj[k].size();
		for(int i=0;i<size;i++) {
			int t = adj[k].get(i);
			if(!visited[t]) {
				visited[t] = true;
				degree[t]++;
				dfs(t);
			}
		}
	}
}

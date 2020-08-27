import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #14620 꽃길
 * 시작일 : 2020-08-27
 * 완료일 : ``
 * DFS
 */
public class Main {

	static int n;
	static int min;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0,0};
	static int[] dc = {0,-1,0,1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n][n];
		min = Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(min);
	}
	
	static void dfs(int k, int cost) {
		if(min<cost) {
			return;
		}
		if(k==3) {
			if(min>cost) {
				min = cost;
			}
			return;
		}
		
		for(int i=1;i<n-1;i++) {
			for(int j=1;j<n-1;j++){
				boolean check = true;
				for(int d=0;d<5;d++) {
					if(visited[i+dr[d]][j+dc[d]]) {
						check = false;
					}
				}
				if(check) {
					int cnt = 0;
					for(int d=0;d<5;d++) {
						visited[i+dr[d]][j+dc[d]] = true;
						cnt+=map[i+dr[d]][j+dc[d]];
					}				
					dfs(k+1,cost+cnt);
					for(int d=0;d<5;d++) {
						visited[i+dr[d]][j+dc[d]] = false;
					}
				}
			}
		}
	}

}

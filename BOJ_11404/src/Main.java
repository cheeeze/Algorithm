import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #11404 플로이드
 * 시작일 : 2020-09-24
 * 완료일 : ``
 * 그래프 최단 경로, 플로이드-와샬
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] adj = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				adj[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a][b] = Integer.min(adj[a][b], c);
		}

		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE) {
						adj[i][j] = Math.min(adj[i][k]+adj[k][j], adj[i][j]);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j || adj[i][j] == Integer.MAX_VALUE) {
					sb.append("0 ");
				}else {
					sb.append(adj[i][j]+" ");
				}
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
		
	}

}

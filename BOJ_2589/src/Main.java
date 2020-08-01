import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #2589 보물섬
 * 시작일 : 2020-08-01
 * 완료일 : ``
 * BFS
 */
public class Main {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
		}
		int answer = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='L') {
					boolean[][] visited = new boolean[n][m];
					LinkedList<Loc> q = new LinkedList<>();
					q.offer(new Loc(i,j));
					visited[i][j] = true;
					int dis = -1;
					while(!q.isEmpty()) {
						int qSize = q.size();
						dis++;
						for(int z=0;z<qSize;z++) {
							Loc temp = q.poll();
							for(int d=0;d<4;d++) {
								int tr = temp.r+dr[d];
								int tc = temp.c+dc[d];
								if(tr<0 || tc<0 || tr>=n || tc>=m || visited[tr][tc]) {
									continue;
								}
								if(map[tr][tc]=='L') {
									visited[tr][tc] = true;
									q.offer(new Loc(tr,tc));
								}
							}
						}
					}
					answer = Math.max(answer, dis);
				}
			}
		}

		System.out.println(answer);
	}
	
	static class Loc {
		int r;
		int c;
		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}

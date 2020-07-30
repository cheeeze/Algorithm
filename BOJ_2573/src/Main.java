import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #2573 빙산
 * 시작일 : 2020-07-30
 * 완료일 : ``
 * 완전탐색 BFS
 */
public class Main {
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean check = true;
		int answer = 0;
		while(check) {
			check = false;
			int cnt = 0;
			boolean[][] visited = new boolean[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(!visited[i][j] && map[i][j]>0) {
						cnt++;
						visited[i][j] = true;
						LinkedList<Loc> q = new LinkedList<>();
						q.add(new Loc(i,j));
						
						while(!q.isEmpty()) {
							Loc temp = q.poll();
							for(int d=0;d<4;d++) {
								int tr = temp.r+dr[d];
								int tc = temp.c+dc[d];
								if(tr<0 || tc<0 || tr>=n || tc>=m || visited[tr][tc]) {
									continue;
								}
								if(map[tr][tc]>0) {
									q.add(new Loc(tr,tc));
									visited[tr][tc] = true;
								}
							}
						}
					}
				}
			}

			if(cnt>=2) {
				break;
			}else if(cnt==0) {
				answer = 0;
				break;
			}
			
			int[][] melt = new int[n][m];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]>0) {
						check = true;
					}
					for(int d=0;d<4;d++) {
						int tr = i+dr[d];
						int tc = j+dc[d];
						if(tr<0 || tc<0 || tr>=n || tc>=m) {
							continue;
						}
						if(map[tr][tc]<=0) {
							melt[i][j]++;
						}
					}
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]-=melt[i][j];
				}
			}
			answer++;
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

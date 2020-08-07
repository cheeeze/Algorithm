import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #3197 백조의 호수
 * 시작일 : 2020-08-04
 * 완료일 : 2020-08-07
 * BFS, 이분탐색
 */
public class Main {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		Loc[] swan = new Loc[2];
		int temp  = 0;
		LinkedList<Loc> melt = new LinkedList<>();
		int[][] melted = new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				melted[i][j] = -1;
			}
		}
		for(int i=0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<c;j++) {
				if(map[i][j] == 'L') {
					swan[temp] = new Loc(i,j);
					temp++;
					melt.add(new Loc(i,j));
					melted[i][j] = 0;
				}else if(map[i][j] == '.') {
					melt.add(new Loc(i,j));
					melted[i][j] = 0;
				}
			}
		}
		int cnt = 0;
		while(!melt.isEmpty()) {
			cnt++;
			int size = melt.size();
			for(int i=0;i<size;i++) {
				Loc t = melt.poll();
				for(int d=0;d<4;d++) {
					int tr = t.r+dr[d];
					int tc = t.c+dc[d];
					if(tr<0 || tc<0 || tr>=r || tc>=c) {
						continue;
					}
					if(melted[tr][tc] == -1) {
						map[tr][tc] = '.';
						melt.offer(new Loc(tr,tc));
						melted[tr][tc] = cnt;
					}
				}
			}
		}
	
		int min = 0;
		int max = cnt+1;
		while(max>min) {
			int middle = (max+min)/2;
			boolean[][] visited = new boolean[r][c];
			LinkedList<Loc> q = new LinkedList<>();
			q.add(swan[0]);
			visited[swan[0].r][swan[0].c] = true;
			boolean check = false;
			Loop : while(!q.isEmpty()) {
				Loc t = q.poll();
				for(int d=0;d<4;d++) {
					int tr = t.r+dr[d];
					int tc = t.c+dc[d];
					if(tr==swan[1].r && tc==swan[1].c) {
						check = true;
						break Loop;
					}
					if(tr<0 || tc<0 || tr>=r || tc>=c || visited[tr][tc]) {
						continue;
					}
					if(melted[tr][tc]<=middle) {
						visited[tr][tc] = true;
						q.offer(new Loc(tr,tc));
					}					
				}
			}
			if(check) {
				max = middle;
			}else {
				min = middle+1;
			}
		}
		System.out.println(max);
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

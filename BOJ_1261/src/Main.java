import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BOJ #1261 알고스팟
 * 시작일 : 2020-06-07
 * 완료일 : ``
 * 우선순위큐 활용 BFS
 */
public class Main {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		for(int i=0;i<m;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = temp[j]-'0';
			}
		}
		
		PriorityQueue<Loc> q = new PriorityQueue<>();
		q.add(new Loc(0,0,0));
		int answer = 0;
		while(!q.isEmpty()) {
			Loc temp = q.poll();
			int cnt = temp.w;
			
			if(temp.r==m-1 && temp.c==n-1) {
				answer = cnt;
				break;
			}
			for(int d=0;d<4;d++) {
				int tr = temp.r+dr[d];
				int tc = temp.c+dc[d];
				
				if(tr<0 || tc<0 || tr>=m || tc>=n || visited[tr][tc]) {
					continue;
				}
				
				if(map[tr][tc]==0) { //뚫림
					q.add(new Loc(tr,tc,cnt));
					visited[tr][tc] = true;
				} else { //벽
					q.add(new Loc(tr,tc,cnt+1));
					visited[tr][tc] = true;
				}
				
			}
		}
		
		System.out.println(answer);

	}
	
	static class Loc implements Comparable<Loc>{
		int r;
		int c;
		int w;
		
		public Loc(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Loc o) {
			return w-o.w;
		}
	}

}

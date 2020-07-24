import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #7562 나이트의 이동
 * 시작일 : 2020-07-24
 * 완료일 : ``
 * BFS
 */
public class Main {

	static int[] dr = {-1,-2,-2,-1,1,2,2,1};
	static int[] dc = {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int tt=0;tt<testcase;tt++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startr = Integer.parseInt(st.nextToken());
			int startc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int endr = Integer.parseInt(st.nextToken());
			int endc = Integer.parseInt(st.nextToken());
			if(startr==endr && startc==endc) {
				System.out.println(0);
				continue;
			}
			boolean[][] visited = new boolean[n][n];
			LinkedList<Loc> q = new LinkedList<>();
			visited[startr][startc] = true;
			q.offer(new Loc(startr,startc));
			int level = 0;
			Loop : while(!q.isEmpty()) {
				int qSize = q.size();
				for(int i=0;i<qSize;i++) {
					Loc temp = q.poll();
					for(int d=0;d<8;d++) {
						int tr = temp.r+dr[d];
						int tc = temp.c+dc[d];
						
						if(tr<0 || tc<0 || tr>=n || tc>=n || visited[tr][tc]) {
							continue;
						}
						if(tr==endr && tc==endc) {
							level++;
							break Loop;
						}
						visited[tr][tc] = true;
						q.offer(new Loc(tr,tc));
					}
				}
				level++;				
			}
			System.out.println(level);
			
		}

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

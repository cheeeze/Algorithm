import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #3709 레이저빔은 어디로
 * 시작일 : 2020-07-12
 * 완료일 : 2020-07-13
 * 구현
 */
public class Main {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int testcase=0;testcase<t;testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			boolean[][] map = new boolean[n+2][n+2];
			int[][] visited = new int[n+2][n+2];
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = true;
			}//우향우 거울
			st = new StringTokenizer(br.readLine());
			//레이저 시작점
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = 0;
			if(r==0) {
				d = 2;
			}else if(c==0) {
				d = 1;
			}else if(r==n+1) {
				d = 0;
			}else if(c==n+1) {
				d = 3;
			}
			
			int answerr = 0;
			int answerc = 0;
			
			while(true) {			
				int tr = r+dr[d];
				int tc = c+dc[d];

				//visit check bit op
				if((visited[tr][tc] & (1<<d)) != (1<<d)) {
					visited[tr][tc] = visited[tr][tc] | (1<<d);
					
					if(map[tr][tc]) {
						d = (d+1)%4;
					}
					r = tr;
					c = tc;
					
				}else {
					break;
				}
				
				if(r*c==0 || r==n+1 || c==n+1) {
					answerr = r;
					answerc = c;
					break;
				}				
			}
			System.out.println(answerr+" "+answerc);
		}

	}

}

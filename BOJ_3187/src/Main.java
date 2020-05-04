import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 * BOJ #3187 양치기 꿍
 * 시작일 : 2020-05-04
 * 완료일 : ``
 * BFS
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		boolean[][] visited = new boolean[r][c];
		for(int i=0; i<r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		LinkedList<Loc> q = new LinkedList<>();

		int sheepSave = 0;
		int wolfSave = 0;
		int sheep = 0;
		int wolf = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='#') {
					continue;
				}
				if(!visited[i][j]) {
					visited[i][j] = true;
					q.offer(new Loc(i,j));
					if(map[i][j] =='v') {
						wolf++;
					}else if(map[i][j]=='k') {
						sheep++;
					}
					while(!q.isEmpty()) {
						Loc l = q.poll();
						for(int d=0;d<4;d++) {
							int tr = l.x+dr[d];
							int tc = l.y+dc[d];
							if(tr>=r || tc>=c || tr<0 || tc<0) {
								continue;
							}
							if(!visited[tr][tc] && map[tr][tc]!='#') {
								visited[tr][tc] = true;
								q.offer(new Loc(tr,tc));
								if(map[tr][tc] =='v') {
									wolf++;
								}else if(map[tr][tc]=='k') {
									sheep++;
								}
							}
						}
					}
					if(wolf==0 && sheep==0) {
						continue;
					}
					
					if(sheep>wolf) {
						sheepSave+=sheep;
					}else {
						wolfSave+=wolf;
					}
					wolf = 0;
					sheep = 0;
					
				}
			}
		}
		System.out.println(sheepSave+" "+wolfSave);

	}
	
	static class Loc {
		int x;
		int y;
		
		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}

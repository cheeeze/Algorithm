import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #1194 달이 차오른다, 가자.
 * 시작일 : 2020-02-26
 * 완료일 : 2020-08-30
 * BFS, 비트마스크
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
		LinkedList<Loc> q = new LinkedList<>();
		boolean[][][] visited = new boolean[n][m][1<<6];
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(map[i][j] == '0') {
					q.offer(new Loc(i,j,0));
					visited[i][j][0] = true;
				}
			}
		}
			
		int answer = 1;
		boolean check = false;
		Loop : while(!q.isEmpty()) {		
			int qSize = q.size();
			for(int i=0;i<qSize;i++) {
				Loc l = q.poll();
				int key = l.key;
				for(int d=0;d<4;d++) {
					int tr = l.r+dr[d];
					int tc = l.c+dc[d];

					if(tr<0 || tc<0 || tr>=n || tc>=m || map[tr][tc] == '#') {
						continue;
					}
					
					if(map[tr][tc] == '1') {		
						check = true;
						break Loop;
					}
					
					if(!visited[tr][tc][key]) {
						if(map[tr][tc]>='A' && map[tr][tc]<='F') {
							int lock = map[tr][tc]-'A';
							lock = 1<<lock;
							if((key & lock) == lock) {
								visited[tr][tc][key] = true;
								q.offer(new Loc(tr,tc,key));
							}
						}else {
							if(map[tr][tc]>='a' && map[tr][tc]<='f') {
								int newKey = map[tr][tc]-'a';
								newKey = 1<<newKey;
								if((newKey & key) != newKey) {
									visited[tr][tc][key+newKey] = true;
									q.offer(new Loc(tr,tc,key+newKey));
								}else {
									visited[tr][tc][key] = true;
									q.offer(new Loc(tr,tc,key));
								}								
							}else {
								visited[tr][tc][key] = true;
								q.offer(new Loc(tr,tc,key));
							}
							
						}
					}
				}
			}
			answer++;			
		}
		
		if(check) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}

	}
	
	static class Loc {
		int r;
		int c;
		int key;
		
		public Loc(int r, int c, int key) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
		}	
	}

}

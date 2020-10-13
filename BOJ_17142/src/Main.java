import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #17142 연구소 3
 * 시작일 : 2020-10-13
 * 완료일 : ``
 * BFS, 시뮬레이션
 */
public class Main {

	static int n;
	static int m;
	static int[][] map;
	static boolean[] checked;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int blank = 0;
	static int min = Integer.MAX_VALUE;
	static ArrayList<Loc> virus;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new boolean[n][n];
		virus = new ArrayList<>();
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2){
					virus.add(new Loc(i,j));
				}else if(map[i][j] == 0){
					blank++;
				}
			}
		}
		if(blank==0){
			System.out.println(0);
		}else{
			int v = virus.size();
			checked = new boolean[v];
			min = Integer.MAX_VALUE;
			comb(m, v, 0, 0);
			if(min==Integer.MAX_VALUE){
				min = -1;
			}
			System.out.println(min);
		}
	}
	
	static void comb(int m, int v, int k, int s){
		if(m==k){
			//BFS
			LinkedList<Loc> q = new LinkedList<>();
			visited = new boolean[n][n];
			int answer = 0;
			for(int i=0;i<v;i++){
				if(checked[i]){
					Loc temp = virus.get(i);
					q.offer(temp);
					visited[temp.r][temp.c] = true;
				}
			}
			int level = 0;
			Loop : while(!q.isEmpty()){
				int qSize = q.size();
				for(int i=0;i<qSize;i++){
					Loc temp = q.poll();
					for(int d=0;d<4;d++){
						int tr = temp.r+dr[d];
						int tc = temp.c+dc[d];
						
						if(tr<0 || tc<0 || tr>=n || tc>=n || visited[tr][tc] || map[tr][tc]==1){
							continue;
						}
						
						visited[tr][tc] = true;
						q.offer(new Loc(tr,tc));
						if(map[tr][tc] == 0){
							answer++;
						}
						if(answer==blank){
							level++;
							break Loop;
						}
					}	
				}
				level++;
			}
			if(answer!=blank){
				return;
			}
			min = Math.min(min, level);
			return;
		}
		
		for(int i=s;i<v;i++){
			if(!checked[i]){
				checked[i] = true;
				comb(m,v,k+1,i);
				checked[i] = false;
			}
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

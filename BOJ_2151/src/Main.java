import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
 * BOJ #2151 거울 설치
 * 시작일 : 2020-10-17
 * 완료일 : ``
 * BFS
 */
public class Main {

	static int n;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		Loc[] door = new Loc[2];
		for(int i=0;i<n;i++){
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<n;j++){
				if(map[i][j]=='#'){
					if(door[0]!=null){
						door[1] = new Loc(i,j,0);
					}else{
						door[0] = new Loc(i,j,0);
					}
				}
			}
		}
		int[][][] visited = new int[n][n][4];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				for(int k=0;k<4;k++){
					visited[i][j][k] = Integer.MAX_VALUE-1;
				}
			}
		}
		
		LinkedList<Loc> q = new LinkedList<>();
		q.offer(door[0]);
		for(int d=0;d<4;d++){
			visited[door[0].r][door[0].c][d] = 0;
		}
		while(!q.isEmpty()){
			Loc temp = q.poll();
			if(map[temp.r][temp.c]=='#'){
				if(door[0].r==temp.r && door[0].c==temp.c){
					for(int d=0;d<4;d++){
						int tr = temp.r+dr[d];
						int tc = temp.c+dc[d];
						if(check(map,visited,tr,tc,visited[temp.r][temp.c][0],d)){
							visited[tr][tc][d] = visited[temp.r][temp.c][0];
							q.offer(new Loc(tr,tc,d));
						}
					}
				}else{//도착
					continue;
				}
			}else if(map[temp.r][temp.c]=='.'){
				int tr = temp.r+dr[temp.d];
				int tc = temp.c+dc[temp.d];
				if(check(map,visited,tr,tc,visited[temp.r][temp.c][temp.d],temp.d)){
					visited[tr][tc][temp.d] = visited[temp.r][temp.c][temp.d];
					q.offer(new Loc(tr,tc,temp.d));
				}
			}else if(map[temp.r][temp.c]=='!'){
				//거울 설치 가능
				for(int d=0;d<4;d++){
					if((temp.d+2)%4==d){
						continue;
					}
					int tr = temp.r+dr[d];
					int tc = temp.c+dc[d];
					if(temp.d==d){
						if(check(map,visited,tr,tc,visited[temp.r][temp.c][temp.d],d)){
							visited[tr][tc][d] = visited[temp.r][temp.c][temp.d];
							q.offer(new Loc(tr,tc,d));
						}
					}else{ //거울 설치
						if(check(map,visited,tr,tc,visited[temp.r][temp.c][temp.d]+1,d)){
							visited[tr][tc][d] = visited[temp.r][temp.c][temp.d]+1;
							q.offer(new Loc(tr,tc,d));
						}
					}
				}
			}else{
				//벽
				continue;
			}
		}
		int answer = Integer.MAX_VALUE;
		for(int d=0;d<4;d++){
			if(answer>visited[door[1].r][door[1].c][d]){
				answer = visited[door[1].r][door[1].c][d];
			}
		}
		System.out.println(answer);

	}
	
	static boolean check(char[][] map, int[][][] visited, int tr, int tc, int v, int d){
		if(tr<0 || tc<0 || tr>=n || tc>=n || map[tr][tc] == '*'){
			return false;
		}
		if(visited[tr][tc][d]>v){
			return true;
		}
		return false;
	}
	
	static class Loc {
		int r;
		int c;
		int d;
		public Loc(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

}

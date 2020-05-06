import java.util.LinkedList;
import java.util.Scanner;

/*
 * BOJ #16234 인구이동
 * 시작일 : 2020-05-06 (2회차)
 * 완료일 : ``
 * 완전탐색
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		boolean[][] visited = new boolean[n][n];
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int answer = 0;
		boolean flag = false;
		LinkedList<Loc> q = new LinkedList<>();
		LinkedList<Loc> moved = new LinkedList<>();
		int sum = 0;
		int cnt = 0;
		while(true) {
			visited = new boolean[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {				
					if(!visited[i][j]) {
						visited[i][j] = true;
						q.add(new Loc(i,j));
						moved.add(new Loc(i,j));
						cnt++;
						sum+=map[i][j];
						while(!q.isEmpty()) {
							Loc temp = q.poll();
							for(int d=0;d<4;d++) {
								int tr = temp.r+dr[d];
								int tc = temp.c+dc[d];
								if(tr<0 || tc<0 || tr>=n || tc>=n) {
									continue;
								}
								int diff = Math.abs(map[temp.r][temp.c]-map[tr][tc]);
								if(!visited[tr][tc] && diff>=l && diff<=r) {
									visited[tr][tc] = true;
									q.offer(new Loc(tr,tc));
									moved.offer(new Loc(tr,tc));
									cnt++;
									sum+=map[tr][tc];
								}
							}
						}
						if(cnt>1) {
							flag = true;
							int move = sum/cnt;
							while(!moved.isEmpty()) {
								Loc temp = moved.poll();
								map[temp.r][temp.c] = move;
							}						
						}						
					}
					moved.clear();
					cnt = 0;
					sum = 0;
				}
			}

			if(!flag) {
				break;
			}
			answer++;
			flag = false;
		}
		
		System.out.println(answer);

	}
	
	static class Loc{
		int r;
		int c;
		
		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

}

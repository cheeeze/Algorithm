import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #2583 영역 구하기
 * 시작일 : 2020-07-15
 * 완료일 : ``
 * BFS
 */
public class Main {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[m][n];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=a;j<x;j++) {
				for(int z=b;z<y;z++) {
					visited[z][j] = true;
				}
			}
		}
		LinkedList<Integer> answer = new LinkedList<>();
		LinkedList<Loc> q = new LinkedList<>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					int cnt = 1;
					visited[i][j] = true;
					q.offer(new Loc(i,j));
					while(!q.isEmpty()) {
						Loc temp = q.poll();
						for(int d=0;d<4;d++) {
							int tr = temp.r+dr[d];
							int tc = temp.c+dc[d];
							
							if(tr<0 || tc<0 || tr>=m || tc>=n || visited[tr][tc]) {
								continue;
							}
							
							visited[tr][tc] = true;
							q.offer(new Loc(tr,tc));
							cnt++;
						}
					}
					answer.add(cnt);
				}
			}
		}
		
		Collections.sort(answer);
		System.out.println(answer.size());
		Iterator<Integer> it = answer.iterator();
		StringBuilder sb = new StringBuilder();
		while(it.hasNext()) {
			sb.append(it.next());
			sb.append(" ");
		}
		System.out.println(sb.toString());
		
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

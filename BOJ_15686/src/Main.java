import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * BOJ #15686 치킨 배달
 * 시작일 : 2020-06-07
 * 완료일 : ``
 * 재풀이
 * 조합
 */
public class Main {
	static boolean[] visited;
	static ArrayList<Loc> store;
	static ArrayList<Loc> home;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][n];
		store = new ArrayList<>();
		home = new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					home.add(new Loc(i,j));
				}else if(map[i][j] == 2) {
					store.add(new Loc(i,j));
				}
			}
		}
		answer = Integer.MAX_VALUE;
		int size = store.size();
		visited = new boolean[size];
		
		dfs(size,m,0,0);
		System.out.println(answer);

	}
	
	static void dfs(int n, int m, int k, int cnt) {
		if(m<=k) {
			int l = home.size();
			int[] len = new int[l];
			Arrays.fill(len, Integer.MAX_VALUE);
			for(int i=0;i<l;i++) {
				for(int j=0;j<n;j++) {
					if(visited[j]) {
						int distance = Math.abs(home.get(i).r-store.get(j).r)+Math.abs(home.get(i).c-store.get(j).c);
						len[i] = Math.min(distance, len[i]);
					}
				}
			}
			int sum = 0;
			for(int i=0;i<l;i++) {
				sum+=len[i];
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=cnt;i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(n,m,k+1,i);
				visited[i] = false;
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

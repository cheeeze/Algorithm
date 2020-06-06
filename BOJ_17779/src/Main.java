import java.util.Arrays;
import java.util.Scanner;

/*
 * BOJ #17779 게리맨더링 2
 * 시작일 : 2020-05-28
 * 완료일 : 2020-06-06
 * DFS
 */
public class Main {
	static int[][] map;
	static int[][] type;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n+1][n+1];
		type = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[][] division = new int[n+1][n+1];
		int answer = Integer.MAX_VALUE;
		for(int x=1;x<=n;x++) {
			for(int y=1;y<=n;y++) {
				for(int d1=1;d1<=n;d1++) {
					for(int d2=1;d2<=n;d2++) {
						if(x<x+d1+d2 && x+d1+d2<=n && 1<=y-d1 && y-d1 < y && y<y+d2 && y+d2<=n) {
							division = new int[n+1][n+1];
							for(int t=0;t<x;t++) {
								division[t][y] = 1;
							}
							for(int t=n;t>y+d2;t--) {
								division[x+d2][t] = 2;
							}
							for(int t=0;t<y-d1;t++) {
								division[x+d1][t] = 3;
							}
							for(int t=n;t>x+d1+d2;t--) {
								division[t][y-d1+d2] = 4;
							}
							
							for(int t=0;t<=d1;t++) {
								division[x+t][y-t] = 5;
								division[x+d2+t][y+d2-t] = 5;
							}
							for(int t=0;t<=d2;t++) {
								division[x+t][y+t] = 5;
								division[x+d1+t][y-d1+t] = 5;
							}
							
							dfs(division,n,1,1,1);
							dfs(division,n,1,n,2);
							dfs(division,n,n,1,3);
							dfs(division,n,n,n,4);
							answer = Math.min(count(division,n),answer);
						}
					}
				}
			}
		}
		System.out.println(answer);

	}
	
	static void dfs(int[][] div, int n, int x, int y, int value) {
		if(x<1 || y<1 || x>n || y>n) {
			return;
		}
		if(div[x][y]!=0) {
			return;
		}
		
		for(int d=0;d<4;d++) {
			div[x][y] = value;
			dfs(div,n,x+dx[d],y+dy[d],value);
		}
	}
	
	static int count(int[][] div, int n) {
		int[] cnt = new int[6];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				switch(div[i][j]) {
				case 0:
					cnt[0]+=map[i][j];
					break;
				case 1:
					cnt[1]+=map[i][j];
					break;
				case 2:
					cnt[2]+=map[i][j];
					break;
				case 3:
					cnt[3]+=map[i][j];
					break;
				case 4:
					cnt[4]+=map[i][j];
					break;
				case 5:
					cnt[5]+=map[i][j];
					break;
				}
			}
		}
		cnt[5]+=cnt[0];
		cnt[0] = -100;
		Arrays.sort(cnt);
		int diff = cnt[5]-cnt[1];
		return diff;
	}
	
// 브루트포스(시뮬레이션)으로 시도 : 실패
//		static void coloring(int[][] div, int n, int x, int y, int d1, int d2) {
//			for(int i=1;i<=n;i++) {
//				for(int j=1;j<=n;j++) {
//					if(i<x+d1 && j<=y) {
//						//1
//						div[j][i] = 1;
//					}else if(i<x+d2 && y<j) {
//						//2
//						div[j][i] = 2;
//					}else if(x+d1<=i && j<y-d1+d2) {
//						//3
//						div[j][i] = 3;
//					}else if(x+d2<i && y-d1+d2<=j) {
//						//4
//						div[j][i] = 4;
//					}
//				}
//			}
//		}
//	
//	static void init5(int[][] map, int n) {
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n;j++) {
//				map[i][j] = 5;
//			}
//		}
//	}

}

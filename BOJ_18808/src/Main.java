import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #18808 스티커 붙이기
 * 시작일 : 2020-10-11
 * 완료일 : 2020-10-12
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int answer = 0;
		boolean[][] book = new boolean[n][m];
		for(int tc=0;tc<k;tc++){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] sti = new int[r][c];
			int count = 0;
			for(int i=0;i<r;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<c;j++){
					sti[i][j] = Integer.parseInt(st.nextToken());
					if(sti[i][j] == 1){
						count++;
					}
				}
			}
			
			int d = 0;
			Loop : while(d<4){
				for(int i=0;i<=n-r;i++){
					for(int j=0;j<=m-c;j++){
						boolean check = true;
						for(int x=0;x<r;x++){
							for(int y=0;y<c;y++){
								if(sti[x][y]==1 && book[i+x][j+y]){
									check = false;
								}
							}
						}
						if(check){
							for(int x=0;x<r;x++){
								for(int y=0;y<c;y++){
									if(sti[x][y]==1){
										book[i+x][j+y] = true;
									}
								}
							}
							answer += count;
							break Loop;
						}
					}
				}
				//90도 시계방향 돌리기
				int[][] copy = new int[c][r];
				for(int a=0;a<r;a++){
					for(int b=0;b<c;b++){
						copy[b][r-a-1] = sti[a][b];
					}
				}
				d++;
				int t = c;
				c = r;
				r = t;
				sti = new int[r][c];
				for(int a=0;a<r;a++){
					sti[a] = copy[a].clone();
				}
			}
		}
		System.out.println(answer);

	}

}

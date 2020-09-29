import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #2293 동전 1
 * 시작일 : 2020-09-29
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n+1][k+1];
		int[] coin = new int[n];

		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		dp[0][0] = 1;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=k;j++) {
				if(coin[i-1]>j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j]+dp[i][j-coin[i-1]];
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}

}

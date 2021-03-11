import java.util.Scanner;

/*
 * BOJ #2225 합분해
 * 시작일 : 2021-03-09
 * 완료일 : 2021-03-11
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] dp = new int[n+1][k+1];
	
		for(int i=0;i<=n;i++) {
			dp[i][1] = 1;
		}
		for(int i=0;i<=k;i++) {
			dp[0][i] = 1;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=2;j<=k;j++) {
				for(int l=0;l<=i;l++) {
					dp[i][j] += dp[i-l][j-1];
					dp[i][j] %= 1000000000;
				}
			}
		}
		
		System.out.println(dp[n][k]);

	}

}

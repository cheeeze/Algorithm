import java.util.Scanner;

/*
 * BOJ #11057 오르막 수
 * 시작일 : 2021-03-06
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][10];
		for(int i=0;i<10;i++) {
			dp[1][i] = 1;
		}
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<=j;k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		int answer = 0;
		for(int i=0;i<10;i++) {
			answer += dp[n][i];
			answer %= 10007;
		}
		System.out.println(answer);

	}

}

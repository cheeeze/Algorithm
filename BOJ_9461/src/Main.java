import java.util.Scanner;

/*
 * BOJ #9461 파도반 수열
 * 시작일 : 2021-03-09
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int N = 101;
		long[] dp = new long[N];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		for(int i=5;i<N;i++) {
			dp[i] = dp[i-1]+dp[i-5];
		}
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}

	}

}

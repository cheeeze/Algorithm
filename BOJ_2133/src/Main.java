import java.util.Scanner;

/*
 * BOJ #2133 타일 채우기
 * 시작일 : 2020-08-19
 * 완료일 : 2020-08-23
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[0] = 1;
		if(n<=1) {
			System.out.println(dp[n]);
			return;
		}
		dp[2] = 3;
		
		for(int i=4;i<=n;i+=2) {
			dp[i] = dp[i-2]*3;
			for(int j=4;j<=i;j+=2) {
				dp[i] += dp[i-j]*2;
			}
		}
		System.out.println(dp[n]);
	}

}

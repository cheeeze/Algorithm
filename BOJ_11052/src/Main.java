import java.util.Scanner;

/*
 * BOJ #11052 카드 구매하기
 * 시작일 : 2021-03-11
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i] = sc.nextInt();
		}
		
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			int max = 0;
			for(int j=0;j<=i;j++) {
				max = Integer.max(max, p[i-j]+dp[j]);
			}
			dp[i] = max;
		}
		
		System.out.println(dp[n]);

	}

}

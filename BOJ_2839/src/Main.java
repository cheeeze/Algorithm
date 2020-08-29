import java.util.Scanner;

/*
 * BOJ #2839 설탕 배달
 * 시작일 : 2020-08-29
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			dp[i] = 10000;
		}
		int[] arr = {3,5};
		
		for(int i=0;i<2;i++) {
			for(int j=arr[i];j<=n;j++) {
				dp[j] = Integer.min(dp[j], dp[j-arr[i]]+1);
			}
			
		}
		if(dp[n]==10000) {
			System.out.println(-1);
		}else {
			System.out.println(dp[n]);
		}
	}

}

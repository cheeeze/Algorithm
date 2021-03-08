import java.util.Scanner;

/*
 * BOJ #11053 가장 긴 증가하는 부분 수열
 * 시작일 : 2021-03-08
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[n];
		dp[0] = 1;
		for(int i=1;i<n;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j] < arr[i] && dp[j]+1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		int answer = 0;
		for(int i=0;i<n;i++) {
			answer = Integer.max(answer,  dp[i]);
		}
		System.out.println(answer);
		
	}

}

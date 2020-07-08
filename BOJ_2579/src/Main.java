import java.util.Scanner;

/*
 * BOJ #2579 계단 오르기
 * 시작일 : 2020-07-08
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
		if(n==1) {
			System.out.println(arr[0]);
			return;
		}else if(n==2){
			System.out.println(arr[0]+arr[1]);
			return;
		}
		
		dp[0] = arr[0];
		dp[1] = Math.max(dp[0]+arr[1], arr[1]);
		dp[2] = Math.max(dp[0]+arr[2], arr[1]+arr[2]);
		
		for(int i=3;i<n;i++) {
			dp[i] = Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
		}
		
		System.out.println(dp[n-1]);
	}

}

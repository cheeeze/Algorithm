import java.util.Scanner;

/*
 * BOJ #11055 가장 큰 증가 부분 수열
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
		dp[0] = arr[0];
		for(int i=1;i<n;i++) {
			int max = 0;
			for(int j=0;j<i;j++) {
				if(arr[j] < arr[i]) {
					if(max < dp[j]) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + arr[i];
		}
		
		int answer = 0;
		for(int i=0;i<n;i++) {
			if(answer < dp[i]) {
				answer = dp[i];
			}
		}
		System.out.println(answer);	

	}

}

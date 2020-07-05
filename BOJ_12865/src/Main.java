import java.util.Scanner;

/*
 * BOJ #12865 평범한 배낭
 * 시작일 : 2020-07-05
 * 완료일 : ``
 * 0/1 knapsack (DP)
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] w = new int[n];
		int[] v = new int[n];
		int[][] answer = new int[n+1][k+1];
		for(int i=0;i<n;i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1;j<=k;j++) {
				if(w[i-1] > j) {
					answer[i][j] = answer[i-1][j];
				}else{
					answer[i][j] = Math.max(v[i-1] + answer[i-1][j-w[i-1]], answer[i-1][j]);
				}		
			}
		}
		
		System.out.println(answer[n][k]);

	}

}

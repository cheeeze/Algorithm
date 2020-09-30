import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #2294 동전 2
 * 시작일 : 2020-09-30
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		for(int i=1;i<=k;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		for(int i=0;i<n;i++) {
			for(int j=0;j<=k;j++) {
				if(j>=coin[i]) {
					if(dp[j-coin[i]] != Integer.MAX_VALUE) {
						dp[j] = Integer.min(dp[j], dp[j-coin[i]]+1);
					}					
				}
			}
		}
		
		if(dp[k] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}

	}

}

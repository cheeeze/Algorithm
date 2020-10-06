import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #2156 포도주 시식
 * 시작일 : 2020-10-06
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] graph = new int[n+1];
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++){
			graph[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1;i<=n;i++){
			if(i==1){
				dp[i] = graph[i];
			}else if(i==2){
				dp[i] = dp[i-1]+graph[i];
			}else {
				int max = dp[i-1];
				if(max<dp[i-2]+graph[i]){
					max = dp[i-2]+graph[i];
				}
				if(max<dp[i-3]+graph[i-1]+graph[i]){
					max = dp[i-3]+graph[i-1]+graph[i];
				}
				dp[i] = max;	
			}
		}

		System.out.println(dp[n]);

	}

}

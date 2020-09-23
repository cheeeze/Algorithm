import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ #1912 연속합
 * 시작일 : 2020-09-23
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = 0;
		int[] sum = new int[n];
		num = Integer.parseInt(st.nextToken());
		sum[0] = num;
		for(int i=1;i<n;i++) {
			num = Integer.parseInt(st.nextToken());
			sum[i] = Math.max(num, sum[i-1]+num);			
		}
		
		Arrays.sort(sum);
		System.out.println(sum[n-1]);
	}

}

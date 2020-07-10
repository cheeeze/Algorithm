import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #2748 피보나치 수 2
 * 시작일 : 2020-07-10
 * 완료일 : ``
 * DP, Memoization
 */
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] fibo = new long[91];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2;i<=n;i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		
		System.out.println(fibo[n]);
	}

}

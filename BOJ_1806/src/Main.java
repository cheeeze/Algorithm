import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #1806 부분합
 * 시작일 : 2020-07-03
 * 완료일 : ``
 * 투포인터
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = arr[left];
		int answer = Integer.MAX_VALUE;
		
		while(left <= right && right < n) {
			if(sum < m) {
				right++;
				if(right < n) {
					sum += arr[right];
				}				
			} else {
				int len = right - left + 1;
				answer = Math.min(answer, len);
				sum -= arr[left];
				left++;
			}
		}
		if(answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		System.out.println(answer);
	}

}

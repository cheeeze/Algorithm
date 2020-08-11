import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #2003 수들의 합 2
 * 시작일 : 2020-08-11
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
		int answer = 0;
		while(left<n && right<n) {
			if(sum==m) {
				answer++;
				sum-=arr[left];
				left++;
			}else if(sum>m) {
				sum-=arr[left];
				left++;
			}else if(sum<m) {
				right++;
				if(right==n) {
					break;
				}
				sum+=arr[right];
			}
		}
		System.out.println(answer);
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ #2805 나무 자르기
 * 시작일 : 2020-07-12
 * 완료일 : ``
 * Parametric Search(이분 탐색)
 */
public class Main {

	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		long left = 0;
		long right = arr[n-1]+1L;
		
		while(left<right) {
			long mid = (left+right)/2;
			if(compare(mid,arr)==1) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		
		System.out.println(left-1);
	}
	
	static int compare(long t, int[] arr) {
		long total = 0;

		for(int i=0;i<n;i++) {
			if(t<=arr[i]) {
				total+=arr[i]-t;
			}
		}
		
		if(total>=m) {
			return 1;
		}else {
			return 0;
		}
	}

}

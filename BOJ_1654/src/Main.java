import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ #1654 랜선 자르기
 * 시작일 : 2020-07-12
 * 완료일 : ``
 * Parametric Search(이분 탐색 응용)
 */
public class Main {

	static int k;
	static int n;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[k];
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		long left = 0;
		long right = arr[k-1]+1L;
		
		while(left<right) {
			long mid = (left+right)/2;
			if(compare(mid)==1) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		System.out.println(left-1);

	}
	
	static long compare(long t) {
		long cnt = 0;
		for(int i=0;i<k;i++) {
			cnt+=arr[i]/t;
		}

		if(cnt>=n) {
			return 1;
		}else {
			return -1;
		}				
	}

}

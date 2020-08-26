import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ #3020 개똥벌레
 * 시작일 : 2020-08-25
 * 완료일 : 2020-08-26
 * 이분탐색(lower bound)
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int upindex = n/2;
		int downindex = n/2;
		if(n%2!=0) {
			upindex++;
		}
		
		int[] up = new int[upindex];
		int[] down = new int[downindex];
		
		
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				down[i/2] = Integer.parseInt(br.readLine());
			}else {
				up[i/2] = Integer.parseInt(br.readLine());
			}
		}
		Arrays.sort(down);
		Arrays.sort(up);
		int answer = Integer.MAX_VALUE;
		int count = 1;
		for(int i=1;i<=h;i++) {
			int upcnt = 0;
			int downcnt = 0;
			int start = 0;
			int end = downindex-1;
			int mid = 0;
			while(start<=end) {
				mid = (start+end)/2;
				if(down[mid]>=i) {
					downcnt = downindex - mid;
					end = mid-1;
				}else {
					start = mid+1;
				}
			}

			start = 0;
			end = upindex-1;
			mid = 0;
			while(start<=end) {
				mid = (start+end)/2;
				if(up[mid]>=(h-i+1)) {
					upcnt = upindex-mid;
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
			if(answer>upcnt+downcnt) {
				answer = upcnt+downcnt;
				count = 1;
			}else if(answer==upcnt+downcnt){
				count++;
			}
		}
		System.out.println(answer+" "+count);
	
		
	}

}

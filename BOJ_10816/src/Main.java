import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ #10816 숫자 카드 2
 * 시작일 : 2020-05-09
 * 완료일 : ``
 * 이진탐색, LowerBound, UpperBound
 */
public class Main {

	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n = Integer.parseInt(br.readLine());
		 int[] arr = new int[n];
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 for(int i=0;i<n;i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 int m = Integer.parseInt(br.readLine());
		 int[] ans = new int[m];
		 st = new StringTokenizer(br.readLine());
		 for(int i=0;i<m;i++) {
			 ans[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 Arrays.sort(arr);
		 
		 StringBuilder sb = new StringBuilder();
		 for(int i=0;i<m;i++) {
			 int l = lower(arr,ans[i]);
			 int u = upper(arr,ans[i]);
			 sb.append(u-l+" ");
		 }
		 System.out.println(sb.toString());

	}
	
	static int lower(int[] arr, int value) {
		int low = 0;
		int high = arr.length;
		
		while(low<high) {
			int mid = low+(high-low)/2;
			if(value<=arr[mid]) {
				high = mid;
			}else {
				low = mid+1;
			}
			
		}
		
		return low;
	}
	
	static int upper(int[] arr, int value) {
		int low = 0;
		int high = arr.length;
		
		while(low<high) {
			int mid = low+(high-low)/2;
			if(value>=arr[mid]) {
				low=mid+1;
			}else {
				high = mid;
			}
		}
		
		return low;
	}

}

import java.util.Scanner;

/*
 * BOJ #11054 가장 긴 바이토닉 부분 수열
 * 시작일 : 2021-03-09
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] asc = new int[n];
		int[] dsc = new int[n];
		
		for(int i=0;i<n;i++) {
			asc[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j] && asc[i] < asc[j]+1) {
					asc[i] = asc[j]+1;
				}
			}
		}
		
		for(int i=n-1;i>=0;i--) {
			dsc[i] = 1;
			for(int j=n-1;j>i;j--) {
				if(arr[i] > arr[j] && dsc[i] < dsc[j]+1) {
					dsc[i] = dsc[j]+1;
				}
			}
		}
		
		int answer = 0;
		for(int i=0;i<n;i++) {
			answer = Integer.max(answer, asc[i]+dsc[i]-1);
		}
		System.out.println(answer);

	}

}

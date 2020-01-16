import java.util.Scanner;

/*
 * SWEA #2477 [모의 SW 역량테스트] 차량 정비소
 * 시작일 : 2020-01-16
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int[] recep = new int[n+1];
			int[] repair = new int[m+1];
			int[] people = new int[k+1];
			for(int i=1;i<=n;i++) {
				recep[i] = sc.nextInt();
			}
			for(int i=1;i<=m;i++) {
				repair[i] = sc.nextInt();
			}
			for(int i=1;i<=k;i++) {
				people[i] = sc.nextInt();
			}
			
			int time = 0;
			int[] atime = new int[n+1];
			int[] btime = new int[m+1];
			int[] aanswer = new int[k+1];
			int[] banswer = new int[k+1];
			int cnt = 1;
			while(true) {
				if(banswer[k]!=0) {
					break;
				}
				for(int i=1;i<=n;i++) {
					if(atime[i]>=time) {
						
						break;
					}
				}
				
				//k가 time순서대로 오지 않음
			}
		}

	}

}

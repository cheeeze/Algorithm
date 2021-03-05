import java.util.Scanner;

/*
 * BOJ #1463 1로 만들기
 * 시작일 : 2021-03-05
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==1) {
			System.out.println(0);
		}else if(n==2) {
			System.out.println(1);
		}else {
			int[] arr = new int[n+1];
			arr[2] = 1;
			arr[3] = 1;
			int min = 0;
			for(int i=4;i<=n;i++) {
				min = Integer.MAX_VALUE;
				if(i%3==0) {
					min = arr[i/3];
				}
				if(i%2==0) {
					min = Integer.min(min, arr[i/2]);
				}
				min = Integer.min(min, arr[i-1]);
				arr[i] = min+1;
			}
			System.out.println(arr[n]);
		}
		
		
	}

}

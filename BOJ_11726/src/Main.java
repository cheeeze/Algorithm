import java.util.Scanner;

/*
 * BOJ #11726 2xn 타일링
 * 시작일 : 2021-03-05
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==1) {
			System.out.println(1);
		}else {
			int[] arr = new int[n+1];
			arr[1] = 1;
			arr[2] = 2;
			for(int i=3;i<=n;i++) {
				arr[i] = (arr[i-1]%10007+arr[i-2]%10007)%10007;
			}
			System.out.println(arr[n]);
		}
		
		

	}

}
